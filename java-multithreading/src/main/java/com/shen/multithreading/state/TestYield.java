package com.shen.multithreading.state;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestYield.java
 * @email theoshen@foxmail.com
 * @Description 礼让线程，不一定成功
 * @createTime 2021年10月14日 16:42:00
 */
public class TestYield {


    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }


}
class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"结束执行");
    }
}