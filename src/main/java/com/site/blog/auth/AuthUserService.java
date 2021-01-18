package com.site.blog.auth;


import com.site.blog.entity.SecUser;
import com.site.blog.service.TbSecUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthUserService implements UserDetailsService {

    @Autowired
    private TbSecUserService tbSecUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //  然后返回User对象，注意，这里的User对象是org.springframework.security.core.userdetails.User
        SecUser oneSecUser = tbSecUserService.findOneTbSecUser(s);
        if(oneSecUser == null){
            throw new UsernameNotFoundException("用户不存在"); // 若不存在抛出用户不存在异常
        }
         // 权限字符串转化
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        String[] roles = oneSecUser.getUserRoles().split(",");// 获取后的Roles必须有ROLE_前缀，否则会抛Access is denied无权限异常
        for (String role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        // 交给security进行验证并返回
        return new User(oneSecUser.getUsername(), oneSecUser.getPassword(), simpleGrantedAuthorities);
    }


}
