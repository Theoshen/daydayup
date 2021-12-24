package com.shen.adapter.entity;

import lombok.Data;

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
@Data
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
    private String bizTime;
    /**
     * @Description 业务描述
     */
    private String desc;

}
