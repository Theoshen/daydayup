package com.shen.multithreading.state;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestJoin.java
 * @email theoshen@foxmail.com
 * @Description join 方法，近似于插队
 * @createTime 2021年10月14日 16:49:00
 */
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("vip is coming" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i==50){
                thread.join();
            }
            System.out.println("main is excuting");
        }
    }
}
