package com.shen.juc.auxiliary;

import java.util.concurrent.CountDownLatch;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName CountDownLatchDemo.java
 * @email theoshen@foxmail.com
 * @Description CountDownLatch 计数器
 * @createTime 2021年10月27日 11:10:00
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 总数为6，必须要执行任务的时候使用
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "go out");
                // 数量 -1
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        // 等待计数器归零，再向下执行
        countDownLatch.await();
        System.out.println("end");
    }
}
