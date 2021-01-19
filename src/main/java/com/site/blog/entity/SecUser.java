package com.site.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

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


    public SecUser(String username, String password, String userRoles) {

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

    public SecUser setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SecUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SecUser setPassword(String password) {
        this.password = password;
        return this;
    }
}
