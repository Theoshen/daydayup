package com.shen.multithreading.state;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestDaemon.java
 * @email theoshen@foxmail.com
 * @Description 测试守护线程
 * @createTime 2021年10月14日 17:11:00
 */
public class TestDaemon {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        // 默认 false 表示用户线程，正常的线程都是用户线程
        thread.setDaemon(true);

        // 上帝守护线程启动
        thread.start();

        
        // 用户线程启动
        new Thread(you).start();

    }
}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("God bless you");
        }
    }
}


class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("you still alive");
        }
        System.out.println("=======886 my world===========");
    }
}