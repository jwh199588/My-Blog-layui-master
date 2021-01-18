package com.site.blog.pojo.dto;

/**
 * 前台博客分页条件
 * @author Linn-cn
 * @create 2020/12/07
 */
public class BlogPageCondition {

    private Integer pageNum;

    private Integer pageSize;

    private String keyword;

    private String pageName;

    private String tagId;

    private String categoryName;

    public Integer getPageNum() {
        return pageNum;
    }

    public BlogPageCondition setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public BlogPageCondition setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public String getPageName() {
        return pageName;
    }

    public BlogPageCondition setPageName(String pageName) {
        this.pageName = pageName;
        return this;
    }

    public String getTagId() {
        return tagId;
    }

    public BlogPageCondition setTagId(String tagId) {
        this.tagId = tagId;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public BlogPageCondition setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }
}
