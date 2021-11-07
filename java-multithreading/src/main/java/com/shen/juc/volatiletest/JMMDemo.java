package com.shen.juc.volatiletest;

import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName JMMDemo.java
 * @email theoshen@foxmail.com
 * @Description JMM 内存模型 引出 volatile
 * @createTime 2021年11月06日 18:45:00
 */
public class JMMDemo {
    // 不加 volatile 程序死循环
    // 加 volatile 保证可见性
    private volatile static int num = 0;
    public static void main(String[] args) {
        new Thread(() ->{
            while (num ==0){

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;
        System.out.println(num);
    }
}
