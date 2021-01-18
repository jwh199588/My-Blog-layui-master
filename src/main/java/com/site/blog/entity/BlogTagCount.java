package com.site.blog.entity;

public class BlogTagCount {
    private Integer tagId;

    private String tagName;

    private long tagCount;

    public Integer getTagId() {
        return tagId;
    }

    public BlogTagCount setTagId(Integer tagId) {
        this.tagId = tagId;
        return this;
    }

    public String getTagName() {
        return tagName;
    }

    public BlogTagCount setTagName(String tagName) {
        this.tagName = tagName;
        return this;
    }

    public long getTagCount() {
        return tagCount;
    }

    public BlogTagCount setTagCount(long tagCount) {
        this.tagCount = tagCount;
        return this;
    }
}
