package com.theoshen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName UserEntity.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2022年04月16日 15:01:00
 */
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 5237730257103305078L;
    private Long id;

    private String name;

    private Integer age;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
