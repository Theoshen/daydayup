package com.shen.multithreading.basic;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestThread1.java
 * @email theoshen@foxmail.com
 * @Description 创建线程方式一：继承Thread 类，重写run()方法，调用start
 * @createTime 2021年10月11日 11:23:00
 */
public class TestThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("run方法:=====" + i);
        }
    }

    public static void main(String[] args) {

        TestThread1 testThread1 = new TestThread1();
//        // 先后执行
//        testThread1.run();
        // 同时执行
        testThread1.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("main方法:======" + i);
        }
    }
}
