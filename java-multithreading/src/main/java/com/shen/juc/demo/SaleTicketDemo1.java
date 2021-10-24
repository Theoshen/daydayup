package com.shen.juc.demo;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestDemo1.java
 * @email theoshen@foxmail.com
 * @Description 多线程开发，降低耦合性
 * 线程是一个单独的资源类，没有任何的附属操作
 * 属性、方法
 * @createTime 2021年10月23日 15:58:00
 */
public class SaleTicketDemo1 {

    public static void main(String[] args) {
        // 并发：多线程操作同一个资源类，把资源类丢入线程
        Ticket ticket = new Ticket();

        // @FunctionalInterface 函数式接口  lambda
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"A").start();	 new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"B").start();	 new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"C").start();

    	}
}

/**
 * @Description 资源类  oop
 */
class Ticket {
    /**
     * @Description 属性 方法
     */
    private int number = 50;

    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--)+ "张票,剩余：" + number);
        }
    }
}
