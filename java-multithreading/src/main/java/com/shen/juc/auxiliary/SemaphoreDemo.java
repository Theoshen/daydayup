package com.shen.juc.auxiliary;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName SemaphoreDemo.java
 * @email theoshen@foxmail.com
 * @Description Semaphore 模拟停车  并发限流，多个资源互斥使用
 * @createTime 2021年10月27日 11:21:00
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 线程数量
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <=6; i++) {
            final int temp = i;
            new Thread(() ->{
                // acquire() 得到
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "停在" + temp + "位置");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "离开车位");;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
                // release() 释放
            },String.valueOf(i)).start();
        }
    }
}
