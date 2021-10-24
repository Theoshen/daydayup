package com.shen.juc.eightlockquestions;

import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Question6.java
 * @email theoshen@foxmail.com
 * @Description 6.两个对象，增加两个静态的方法，先执行谁？
 * @createTime 2021年10月24日 16:37:00
 */
public class Question6 {
    public static void main(String[] args) {
        // 两个对象只有一个class 模板
        Phone6 phone = new Phone6();
        Phone6 phone2 = new Phone6();

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


class Phone6{

    /**
     * @Description synchronized 锁的对象是方法的调用者
     *              两个方法用的是同一个锁，谁先拿到锁 谁先执行
     */
    public static synchronized void sendMessage(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("send message");
    }

    public static synchronized void call(){
        System.out.println("call");
    }
}
