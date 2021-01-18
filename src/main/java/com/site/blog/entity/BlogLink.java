package com.site.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 友情链接表
 * </p>
 *
 * @author: 贾先生
 * @since 2019-09-02
 */
public class BlogLink implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 友链表主键id
     */
    @TableId(value = "link_id", type = IdType.AUTO)
    private Integer linkId;

    /**
     * 友链类别 0-友链 1-推荐 2-个人网站
     */
    @TableField("link_type")
    private Integer linkType;

    /**
     * 网站名称
     */
    @TableField("link_name")
    private String linkName;

    /**
     * 网站链接
     */
    @TableField("link_url")
    private String linkUrl;

    /**
     * 网站描述
     */
    @TableField("link_description")
    private String linkDescription;

    /**
     * 用于列表排序
     */
    @TableField("link_rank")
    private Integer linkRank;

    /**
     * 是否删除 0-未删除 1-已删除
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    /**
     * 添加时间
     */
    @TableField("create_time")
    private Date createTime;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public BlogLink setLinkType(Integer linkType) {
        this.linkType = linkType;
        return this;
    }

    public String getLinkName() {
        return linkName;
    }

    public BlogLink setLinkName(String linkName) {
        this.linkName = linkName;
        return this;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public Integer getLinkRank() {
        return linkRank;
    }

    public void setLinkRank(Integer linkRank) {
        this.linkRank = linkRank;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
