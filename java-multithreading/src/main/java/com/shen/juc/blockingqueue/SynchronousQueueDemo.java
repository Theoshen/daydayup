package com.shen.juc.blockingqueue;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName SynchronousQueueDemo.java
 * @email theoshen@foxmail.com
 * @Description 同步队列
 * @createTime 2021年10月28日 20:50:00
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + "put 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName() + "put 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName() + "put 3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
