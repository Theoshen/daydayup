package com.shen.adapter.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName RabateInfo.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年12月17日 16:19:00
 */

public class RebateInfo implements Serializable {

    private static final long serialVersionUID = -8735570684620676246L;
    /**
     * @Description 用户id
     */
    private String userId;
    /**
     * @Description 业务id
     */
    private String bizId;
    /**
     * @Description 业务时间
     */
    private Date bizTime;
    /**
     * @Description 业务描述
     */
    private String desc;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Date getBizTime() {
        return bizTime;
    }

    public void setBizTime(Date bizTime) {
        this.bizTime = bizTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
