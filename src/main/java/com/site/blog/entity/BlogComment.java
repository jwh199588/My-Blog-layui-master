package com.site.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 评论信息表
 * </p>
 *
 * @author: 贾先生
 * @since 2019-09-04
 */
public class BlogComment implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    /**
     * 关联的blog主键
     */
    @TableField("blog_id")
    @NotNull(message = "非法请求")
    @Min(value = 0,message = "非法请求")
    private Long blogId;

    /**
     * 评论者名称
     */
    @TableField("commentator")
    @NotBlank(message = "请输入称呼")
    @Length(min = 1,max = 6,message = "名称过长或过短")
    private String commentator;

    /**
     * 评论人的邮箱
     */
    @TableField("email")
    @Email(message = "邮箱地址不合法")
    private String email;

    /**
     * 网址
     */
    @TableField("website_url")
    private String websiteUrl;

    /**
     * 评论内容
     */
    @TableField("comment_body")
    @NotBlank(message = "请输入评论内容")
    @Length(min = 1,max = 200,message = "评论内容过长或过短")
    private String commentBody;

    /**
     * 评论提交时间
     */
    @TableField("comment_create_time")
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")    //将Date转换成String,一般后台传值给前台时
    private Date commentCreateTime;

    /**
     * 评论时的ip地址
     */
    @TableField("commentator_ip")
    private String commentatorIp;

    /**
     * 回复内容
     */
    @TableField("reply_body")
    private String replyBody;

    /**
     * 回复时间
     */
    @TableField("reply_create_time")
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private Date replyCreateTime;

    /**
     * 是否审核通过 0-未审核 1-审核通过
     */
    @TableField("comment_status")
    private Integer commentStatus;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public String getCommentatorIp() {
        return commentatorIp;
    }

    public void setCommentatorIp(String commentatorIp) {
        this.commentatorIp = commentatorIp;
    }

    public String getReplyBody() {
        return replyBody;
    }

    public void setReplyBody(String replyBody) {
        this.replyBody = replyBody;
    }

    public Date getReplyCreateTime() {
        return replyCreateTime;
    }

    public void setReplyCreateTime(Date replyCreateTime) {
        this.replyCreateTime = replyCreateTime;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
