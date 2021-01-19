package com.site.blog.auth;

import com.site.blog.constants.SessionConstants;
import com.site.blog.constants.SysConfigConstants;
import com.site.blog.entity.SecUser;
import com.site.blog.pojo.dto.LoginUser;
import com.site.blog.service.BlogConfigService;
import com.site.blog.service.impl.BlogConfigServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

/**
 * @Author: jiawenhao
 * @Date: 2021/1/14 14:03
 * @Description: 登陆成功后，将信息保存到session中
 * @see
 * @since 2.0
 */

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private BlogConfigService blogConfigService;

    private String defaultTargetUrl = "/";

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public CustomAuthenticationSuccessHandler(String defaultTargetUrl) {
        this.defaultTargetUrl = defaultTargetUrl;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException {
        // 登录成功后，进行数据处理
        System.out.println("用户登录成功啦！！！");
        LoginUser principal = (LoginUser) authentication.getPrincipal();
        System.out.println(principal.getUsername());

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_USER, principal.getNickName());
        session.setAttribute(SessionConstants.LOGIN_USER_NAME, principal.getUsername());
        session.setAttribute(SessionConstants.LOGIN_USER_ID, principal.getUsername());

        //处理完成后，跳转回原请求URL
        handle(request, response, authentication);
    }

    @Override
    protected void handle(HttpServletRequest request,
                          HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
       //TODO 可以根据角色去处理跳转页面
        return this.defaultTargetUrl;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    @Override
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
