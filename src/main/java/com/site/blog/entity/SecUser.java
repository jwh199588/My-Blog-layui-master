package com.site.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 *
 * </p>
 *
 * @author zhulin
 * @since 2021-01-14
 */

public class SecUser implements Serializable {

    private static final long serialVersionUID = 1L;

    public SecUser(){

    }

    public SecUser(String username,String password,String userRoles){
        this.username = username;
        this.password = password;
        this.userRoles = userRoles;
    }

    @TableId("user_name")
    private String username;

    /**
     * 用户角色
     */
    @TableField("user_roles")
    private String userRoles;


    @TableField("nick_name")
    private String nickName;

    @TableField("user_password")
    private String password;


    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
