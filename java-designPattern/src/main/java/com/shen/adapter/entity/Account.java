package com.shen.adapter.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Account.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年12月17日 16:46:00
 */
@Data
public class Account implements Serializable {
    private static final long serialVersionUID = -6688453900961476288L;

    private String number;

    private String address;

    private Date accountDate;

    private String desc;
}
