package com.shen.juc.eightlockquestions;

import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Question3.java
 * @email theoshen@foxmail.com
 * @Description 3.增加一个普通方法 hello ，先执行 哪个方法？
 * @createTime 2021年10月24日 16:26:00
 */
public class Question3 {
    public static void main(String[] args) {
        Phone3 phone = new Phone3();

        new Thread(() ->{
            phone.sendMessage();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() ->{
            phone.hello();
        },"B").start();
    }
}


class Phone3{
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

    /**
     * @Description 无锁，不需要等待
     */
    public void hello(){
        System.out.println("hello");
    }
}
