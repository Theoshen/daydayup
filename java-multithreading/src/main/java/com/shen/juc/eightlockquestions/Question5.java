package com.shen.juc.eightlockquestions;

import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Question5.java
 * @email theoshen@foxmail.com
 * @Description 5.两个静态的同步方法，只有一个对象，先执行谁？
 * @createTime 2021年10月24日 16:33:00
 */
public class Question5 {
    public static void main(String[] args) {
        Phone5 phone = new Phone5();

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

/**
 * @Description 唯一的一个对象
 */
class Phone5{

    /**
     * @Description synchronized 锁的对象是方法的调用者
     *              static 静态方法，类一记载就有了  锁的就是Class
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


