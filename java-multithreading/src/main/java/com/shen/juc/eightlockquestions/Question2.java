package com.shen.juc.eightlockquestions;

import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Question2.java
 * @email theoshen@foxmail.com
 * @Description 2.sendMessage 方法延迟4s ，先执行 发短信 还是 打电话  ？
 * @createTime 2021年10月24日 16:19:00
 */
public class Question2 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();

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


class Phone2{
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
