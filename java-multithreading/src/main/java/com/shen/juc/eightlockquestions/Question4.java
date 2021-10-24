package com.shen.juc.eightlockquestions;

import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Question4.java
 * @email theoshen@foxmail.com
 * @Description 4.两个不同的对象，先执行哪个方法
 * @createTime 2021年10月24日 16:29:00
 */
public class Question4 {
    public static void main(String[] args) {
        // 两个不同的对象，两把锁
        Phone4 phone = new Phone4();
        Phone4 phone2 = new Phone4();

        new Thread(() ->{
            phone.sendMessage();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() ->{
            phone2.call();
        },"B").start();
    }
}


class Phone4{

    /**
     * @Description synchronized 锁的对象是方法的调用者
     *              两个方法用的是同一个锁，谁先拿到锁 谁先执行
     */
    public synchronized void sendMessage(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("send message");
    }

    public synchronized void call(){
        System.out.println("call");
    }
}
