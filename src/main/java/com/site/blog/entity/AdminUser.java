package com.site.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 后台管理员信息表
 * </p>
 *
 * @author: 贾先生
 * @since 2019-08-25
 */
public class AdminUser implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 管理员id
     */
    @TableId(value = "admin_user_id", type = IdType.AUTO)
    private Integer adminUserId;

    /**
     * 管理员登陆名称
     */
    @TableField("login_user_name")
    private String loginUserName;

    /**
     * 管理员登陆密码
     */
    @TableField("login_password")
    private String loginPassword;

    /**
     * 管理员显示昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 是否锁定 0未锁定 1已锁定无法登陆
     */
    @TableField("locked")
    private Integer locked;

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public AdminUser setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
        return this;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public AdminUser setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
        return this;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public AdminUser setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public AdminUser setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }
}
