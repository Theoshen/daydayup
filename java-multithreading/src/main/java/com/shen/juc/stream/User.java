package com.shen.juc.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName User.java
 * @email theoshen@foxmail.com
 * @Description
 * @createTime 2021年11月02日 20:23:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
}
