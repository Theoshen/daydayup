package com.shen.multithreading.syn;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName BuyTicket.java
 * @email theoshen@foxmail.com
 * @Description 线程不安全的买票问题
 * @createTime 2021年10月19日 22:45:00
 */
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"我").start();
        new Thread(station,"你").start();
        new Thread(station,"黄牛").start();
    }
}


class BuyTicket implements Runnable{

    private int ticketNum = 10;

    private boolean flag = true;

    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Description synchronized 同步方法
     * @author chensihua
     * @createTime 23:35 2021/10/19
     */
    private synchronized void buy() throws InterruptedException {
        if (ticketNum <= 0){
            flag = false;
            return;
        }

        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNum--);
    }
}