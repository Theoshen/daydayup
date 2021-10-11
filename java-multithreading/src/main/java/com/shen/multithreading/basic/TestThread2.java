package com.shen.multithreading.basic;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestThread2.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年10月11日 11:35:00
 */
public class TestThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("run方法:=====" + i);
        }
    }

    public static void main(String[] args) {
        // 创建runnable接口的实现类对象
        TestThread2 testThread2 = new TestThread2();
        // 创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(testThread2).start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("main方法:======" + i);
        }

    }
}
