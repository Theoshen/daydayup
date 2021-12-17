package com.shen.adapter.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName OrderMq.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年12月17日 17:15:00
 */
@Data
public class OrderMq implements Serializable {
    private String uid;

    private String sku;

    private String orderId;

    private Date createOrderTime;
}
