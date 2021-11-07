package com.shen.juc.lock;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName LockDemo1.java
 * @email theoshen@foxmail.com
 * @Description 可重入锁（递归锁） synchronized
 * @createTime 2021年11月07日 21:30:00
 */
public class LockDemo1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sms();
        },"A").start();
        new Thread(()->{
            phone.sms();
        },"B").start();
    }
}
class Phone{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()
                + "sms");
        call(); // 这里也有锁(sms锁 里面的call锁)
    }
    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()
                + "call");
    }
}