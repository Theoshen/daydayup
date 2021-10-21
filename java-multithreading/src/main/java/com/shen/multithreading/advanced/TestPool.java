package com.shen.multithreading.advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestPool.java
 * @email theoshen@foxmail.com
 * @Description 测试线程池
 * @createTime 2021年10月21日 17:20:00
 */
public class TestPool {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        // 关闭
        service.shutdown();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());

    }
}
