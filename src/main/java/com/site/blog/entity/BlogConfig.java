package com.site.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author: 贾先生
 * @since 2019-08-30
 */
public class BlogConfig implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 字段名
     */
    @TableId("config_field")
    private String configField;

    /**
     * 配置名
     */
    @TableField("config_name")
    private String configName;

    /**
     * 配置项的值
     */
    @TableField("config_value")
    private String configValue;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    public String getConfigField() {
        return configField;
    }

    public BlogConfig setConfigField(String configField) {
        this.configField = configField;
        return this;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigValue() {
        return configValue;
    }

    public BlogConfig setConfigValue(String configValue) {
        this.configValue = configValue;
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

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
