package com.site.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 博客跟标签的关系表
 * </p>
 *
 * @author: 贾先生
 * @since 2019-08-28
 */
public class BlogTagRelation implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 关系表id
     */
    @TableId(value = "relation_id", type = IdType.AUTO)
    private Long relationId;

    /**
     * 博客id
     */
    @TableField("blog_id")
    private Long blogId;

    /**
     * 标签id
     */
    @TableField("tag_id")
    private Integer tagId;

    /**
     * 添加时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public BlogTagRelation setBlogId(Long blogId) {
        this.blogId = blogId;
        return this;
    }

    public Integer getTagId() {
        return tagId;
    }

    public BlogTagRelation setTagId(Integer tagId) {
        this.tagId = tagId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
