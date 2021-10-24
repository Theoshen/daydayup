package com.shen.juc.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName SaleTicketDemo2.java
 * @email theoshen@foxmail.com
 * @Description
 * @createTime 2021年10月23日 16:22:00
 */
public class SaleTicketDemo2 {

    public static void main(String[] args) {
        // 并发：多线程操作同一个资源类，把资源类丢入线程
        Ticket2 ticket2 = new Ticket2();

        // @FunctionalInterface 函数式接口  lambda
        new Thread(() -> { for (int i = 0; i < 40; i++) {
            ticket2.sale();
        }
        },"A").start();
        new Thread(() -> { for (int i = 0; i < 40; i++) {
            ticket2.sale();
        }
        },"B").start();
        new Thread(() -> { for (int i = 0; i < 40; i++) {
            ticket2.sale();
        }
        },"C").start();


    }
}

/**
 * Lock
 * 1. new ReentrantLock();
 * 2. lock.lock()
 * 3. finally - > lock.unlock()
 */
class Ticket2 {
    /**
     * @Description 属性 方法
     */
    private int number = 50;

    Lock lock = new ReentrantLock();

    public  void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--)+ "张票,剩余：" + number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
}
