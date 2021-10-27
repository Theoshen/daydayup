package com.shen.juc.unsafedemo;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName ListTest.java
 * @email theoshen@foxmail.com
 * @Description List
 * @createTime 2021年10月27日 09:59:00
 */
public class ListTest {
    public static void main(String[] args) {
        /**
         * 并发下 ArrayList 不安全
         * List<String> list = new ArrayList<>() 不安全;  java.util.ConcurrentModificationException 并发修改异常
         * 解决方案： 1、 new Vector<>();
         *          2、 Collections.synchronizedList(new ArrayList<>());
         *          3、 new CopyOnWriteArrayList<>();
         * CopyOnWriteArrayList 写入时复制 计算机程序设计领域的一种优化策略
         * 多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）
         * 在写入的时候避免覆盖，造成数据问题！
         * 读写分离
         * CopyOnWriteArrayList add方法使用lock锁 ; Vector add方法使用 synchronized
         */
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
                      new Thread(()->{
                          list.add(UUID.randomUUID().toString().substring(0,5));
                          System.out.println(list);
                     },String.valueOf(i)).start();
                  }
    }
}
