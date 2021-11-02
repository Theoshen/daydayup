package com.shen.juc.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Test.java
 * @email theoshen@foxmail.com
 * @Description stream计算 链式编程
 * 一分钟完成
 * 现在有5个用户，筛选
 * 1、id 必须为偶数
 * 2、年龄必须大于23岁
 * 3、用户名转为大写字母
 * 4、用户名倒着排序
 * 5、只输出一个用户
 * @createTime 2021年11月02日 20:41:00
 */
public class Test {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 22);
        User u3 = new User(3, "c", 23);
        User u4 = new User(4, "d", 24);
        User u5 = new User(5, "e", 25);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        list.stream().filter((u) -> {
                    return u.getId() % 2 == 0;
                })
                .filter((u) -> {
                    return u.getAge() > 23;
                })
                .map( u -> {return u.getName().toUpperCase();})
                .sorted((uu1,uu2) -> {
                    return uu1.compareTo(uu2);})
                .limit(1)
                .forEach(System.out::println);
    }
}
