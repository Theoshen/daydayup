package com.shen.juc.unsafedemo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName SetTest.java
 * @email theoshen@foxmail.com
 * @Description Set
 * @createTime 2021年10月27日 10:20:00
 */
public class SetTest {
    public static void main(String[] args) {
        /**
         * 并发下 HashSet 不安全
         * Set<String> set = new HashSet<>() 不安全;  java.util.ConcurrentModificationException 并发修改异常
         * 解决方案： 1、 Collections.synchronizedSet(new HashSet<>());
         *          2、 new CopyOnWriteArraySet<>();
         * CopyOnWriteArrayList 写入时复制 计算机程序设计领域的一种优化策略
         * 多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）
         * 在写入的时候避免覆盖，造成数据问题！
         * 读写分离
         * CopyOnWriteArrayList add方法使用lock锁 ; Vector add方法使用 synchronized
         */
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }

    }
}
