package com.shen.juc.productorandconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Demo2.java
 * @email theoshen@foxmail.com
 * @Description 线程间的通信问题：生产者和消费者问题  等待唤醒，通知唤醒
 * 线程交替执行   A、B 操作同一个变量   num =0
 * A   num + 1
 * B   num - 1
 * 线程间通信
 * 多消费多生产问题中
 * 线程会被唤醒、但不会被通知，中断或超时，就会产生虚假唤醒，循环体不能用 if ，要用 while
 * if 只判断一次
 * @createTime 2021年10月23日 16:41:00
 */
public class Demo2 {

    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();


    }
}

/**
 * @author chensihua
 * @version 1.0.0
 * @Description condition.await(); 等待
 * condition.signalAll();  唤醒
 */
class Data2 {
    private int num = 0;
    Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0) {
                // 等待
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "--->" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (num == 0) {
                // 等待
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "--->" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

}
