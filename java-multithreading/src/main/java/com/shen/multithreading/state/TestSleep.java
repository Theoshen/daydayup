package com.shen.multithreading.state;

import com.shen.multithreading.basic.TestThread3;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestSleep.java
 * @email theoshen@foxmail.com
 * @Description 模拟网络延时，放大问题的发生性
 * @createTime 2021年10月14日 16:27:00
 */
public class TestSleep implements Runnable{
    private int qualification_num = 32;

    @Override
    public void run() {
        while (true) {
            if (qualification_num <= 1) {
                break;
            }
            try {
                // 模拟延时
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->获取了第" + qualification_num-- + "资格");


        }
    }

    /**
     * 发现问题：多个线程操作同一个资源，线程不安全，数据紊乱。
     */
    public static void main(String[] args) {
        TestSleep num = new TestSleep();

        new Thread(num, "皇马").start();
        new Thread(num, "巴萨").start();
        new Thread(num, "曼联").start();
        new Thread(num, "曼城").start();
        new Thread(num, "切尔西").start();

    }
}
