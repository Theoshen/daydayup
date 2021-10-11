package com.shen.multithreading.basic;


/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Race.java
 * @email theoshen@foxmail.com
 * @Description 龟兔赛跑的例子
 * @createTime 2021年10月11日 16:56:00
 */
public class Race implements Runnable{

    private static String winnner;


    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            // 模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子") && i%10 == 0){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--->跑了" + i + "步");
        }
    }

    private boolean gameOver(int steps){
        if (winnner != null){
            return true;
        }{
            if(steps >= 100){
                winnner = Thread.currentThread().getName();
                System.out.println("winner is " + winnner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
