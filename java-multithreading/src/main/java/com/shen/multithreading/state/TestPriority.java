package com.shen.multithreading.state;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestPriority.java
 * @email theoshen@foxmail.com
 * @Description 线程优先级
 * @createTime 2021年10月14日 17:04:00
 */
public class TestPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);

        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t3.setPriority(Thread.MAX_PRIORITY);
        t4.start();

    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
    }
}
