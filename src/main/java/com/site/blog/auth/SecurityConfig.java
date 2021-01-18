package com.site.blog.auth;

import com.site.blog.auth.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthUserService authUserService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//开启登录配置
//                .antMatchers("/hello").hasRole("admin")//表示访问 /hello 这个接口，需要具备 admin 这个角色
                .antMatchers("/admin/**").authenticated()//表示剩余的其他接口，登录之后就能访问
                .and()
                .formLogin().permitAll()
                //指定登录页的路径
                .loginPage("/login")
                .failureUrl("/login?error")
                .successHandler(new CustomAuthenticationSuccessHandler("/admin/v1/index"))
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .and()
                .sessionManagement()    //添加session管理器
                .invalidSessionUrl("/login") //Session失效后跳转到这个链接;
                .maximumSessions(1)  //最大只能允许一个登录
                .expiredSessionStrategy(new CustomSessionInformationExpiredStrategy());
        //必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
        //这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。

        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
        http.csrf().disable();
        //X-Frame-Options HTTP 响应头是用来给浏览器指示允许一个页面可否在 <frame><iframe> 或者 <object> 中展现的标记。网站可以使用此功能，来确保自己网站的内容没有被嵌到别人的网站中去，也从而避免了点击劫持 (clickjacking) 的攻击。
        http.headers().frameOptions().sameOrigin();
    }

    // 密码加密方式
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 重写方法，自定义用户
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authUserService); // 注入MyUserService，这样SpringSecurity会调用里面的loadUserByUsername(String s)
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置该地址匿名访问
        web.ignoring().antMatchers("/admin/v1/reload", "/admin/dist/**", "/admin/plugins/**", "/X-admin/**");
    }
}
