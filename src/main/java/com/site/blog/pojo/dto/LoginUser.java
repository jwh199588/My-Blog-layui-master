package com.site.blog.pojo.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @Author: jiawenhao
 * @Date: 2021/1/18 11:11
 * @Description: 登陆信息保存
 * @see
 * @since 2.0
 */

public class LoginUser extends User {

    public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username,password,authorities);
        this.username = username;
        this.password = password;

    }

    private String username;

    private String nickName;

    private String password;


    public String getNickName() {
        return nickName;
    }

    public LoginUser setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public LoginUser setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public LoginUser setPassword(String password) {
        this.password = password;
        return this;
    }
}
