package com.shen.juc.eightlockquestions;

import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Question8.java
 * @email theoshen@foxmail.com
 * @Description 8.一个静态同步方法，一个普通的同步方法，两个对象，先执行谁？
 * @createTime 2021年10月24日 16:42:00
 */
public class Question8 {
    public static void main(String[] args) {
        Phone8 phone = new Phone8();
        Phone8 phone2 = new Phone8();

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

class Phone8{

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
