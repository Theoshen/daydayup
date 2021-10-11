package com.shen.multithreading.basic;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestThread3.java
 * @email theoshen@foxmail.com
 * @Description 模拟获取资格
 * @createTime 2021年10月11日 11:42:00
 */


public class TestThread3 implements Runnable {

    private int qualification_num = 32;

    @Override
    public void run() {
        while (true) {
            if (qualification_num <= 1) {
                break;
            }
            try {
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
        TestThread3 num = new TestThread3();

        new Thread(num, "皇马").start();
        new Thread(num, "巴萨").start();
        new Thread(num, "曼联").start();
        new Thread(num, "利物浦").start();
        new Thread(num, "曼城").start();
        new Thread(num, "切尔西").start();
        new Thread(num, "国米").start();
        new Thread(num, "拜仁").start();
        new Thread(num, "尤文").start();
        new Thread(num, "多特").start();
        new Thread(num, "本菲卡").start();


    }
}
