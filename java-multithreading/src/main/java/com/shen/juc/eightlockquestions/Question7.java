package com.shen.juc.eightlockquestions;

import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Question7.java
 * @email theoshen@foxmail.com
 * @Description 7.一个静态同步方法，一个普通的同步方法，一个对象，先执行谁？
 * @createTime 2021年10月24日 16:41:00
 */
public class Question7 {
    public static void main(String[] args) {
        Phone7 phone = new Phone7();

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

class Phone7{

    /**
     * @Description static 静态方法，类一记载就有了  锁的就是Class
     */
    public static synchronized void sendMessage(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("send message");
    }

    /**
     * synchronized 锁的对象是方法的调用者
     */
    public synchronized void call(){
        System.out.println("call");
    }
}
