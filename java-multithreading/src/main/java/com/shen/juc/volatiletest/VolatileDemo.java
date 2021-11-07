package com.shen.juc.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName VolatileDemo.java
 * @email theoshen@foxmail.com
 * @Description volatile 不保证原子性 如何保证原子性？
 *              不加 lock 或者 synchronized 如何实现
 *              使用原子类
 * @createTime 2021年11月06日 19:54:00
 */
public class VolatileDemo {
    /**
     * @Description volatile 不保证原子性
     * @author chensihua
     */
    private volatile static AtomicInteger num =new AtomicInteger();

    public static void add(){
//        num ++;
        num.getAndIncrement(); // AtomicInteger + 1 方法
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2){
            // main gc 线程固定
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + num);
    }
}
