package com.shen.juc.eightlockquestions;

import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Question1.java
 * @email theoshen@foxmail.com
 * @Description 1.标准情况下，两个线程 先执行 发短信 还是 打电话  ？
 * @createTime 2021年10月24日 16:13:00
 */
public class Question1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() ->{
            phone.sendMessage();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() ->{
            phone.call();
        },"B").start();
    }
}


class Phone{

    /**
     * @Description synchronized 锁的对象是方法的调用者
     *              两个方法用的是同一个锁，谁先拿到锁 谁先执行
     */
    public synchronized void sendMessage(){
        System.out.println("send message");
    }

    public synchronized void call(){
        System.out.println("call");
    }
}
