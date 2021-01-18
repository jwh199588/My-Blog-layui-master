package com.site.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 博客信息表
 * </p>
 *
 * @author: 贾先生
 * @since 2019-08-27
 */
public class BlogInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 博客表主键id
     */
    @TableId(value = "blog_id", type = IdType.AUTO)
    private Long blogId;

    /**
     * 博客标题
     */
    @TableField("blog_title")
    private String blogTitle;

    /**
     * 博客自定义路径url
     */
    @TableField("blog_sub_url")
    private String blogSubUrl;

    /**
     * 博客前言
     */
    @TableField("blog_preface")
    private String blogPreface;

    /**
     * 博客内容
     */
    @TableField("blog_content")
    private String blogContent;

    /**
     * 博客分类id
     */
    @TableField("blog_category_id")
    private Integer blogCategoryId;

    /**
     * 博客分类(冗余字段)
     */
    @TableField("blog_category_name")
    private String blogCategoryName;

    /**
     * 博客标签(冗余字段)
     */
    @TableField("blog_tags")
    private String blogTags;

    /**
     * 0-草稿 1-发布
     */
    @TableField("blog_status")
    private Integer blogStatus;

    /**
     * 阅读量
     */
    @TableField("blog_views")
    private Long blogViews;

    /**
     * 0-允许评论 1-不允许评论
     */
    @TableField("enable_comment")
    private Integer enableComment;

    /**
     * 是否删除 0=否 1=是
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    /**
     * 添加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")    //将Date转换成String,一般后台传值给前台时
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")    //将Date转换成String,一般后台传值给前台时
    @TableField("update_time")
    private Date updateTime;

    public Long getBlogId() {
        return blogId;
    }

    public BlogInfo setBlogId(Long blogId) {
        this.blogId = blogId;
        return this;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogSubUrl() {
        return blogSubUrl;
    }

    public void setBlogSubUrl(String blogSubUrl) {
        this.blogSubUrl = blogSubUrl;
    }

    public String getBlogPreface() {
        return blogPreface;
    }

    public void setBlogPreface(String blogPreface) {
        this.blogPreface = blogPreface;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Integer getBlogCategoryId() {
        return blogCategoryId;
    }

    public BlogInfo setBlogCategoryId(Integer blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
        return this;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public BlogInfo setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
        return this;
    }

    public String getBlogTags() {
        return blogTags;
    }

    public BlogInfo setBlogTags(String blogTags) {
        this.blogTags = blogTags;
        return this;
    }

    public Integer getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(Integer blogStatus) {
        this.blogStatus = blogStatus;
    }

    public Long getBlogViews() {
        return blogViews;
    }

    public BlogInfo setBlogViews(Long blogViews) {
        this.blogViews = blogViews;
        return this;
    }

    public Integer getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(Integer enableComment) {
        this.enableComment = enableComment;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public BlogInfo setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public BlogInfo setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
