package com.shen.multithreading.advanced;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestSignal.java
 * @email theoshen@foxmail.com
 * @Description 测试生产者消费者问题2 ：信号灯法，标志位解决
 * @createTime 2021年10月21日 17:05:00
 */
public class TestSignal {

    public static void main(String[] args) {
        Film film = new Film();
        new Actor(film).start();
        new Audience(film).start();
    }
}

/**
 * 生产者 --> 演员
 */
class Actor extends Thread {
    Film film;

    public Actor(Film film) {
        this.film = film;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.film.make("IronMan");
            } else {
                this.film.make("SpiderMan");
            }
        }
    }

}

/**
 * 消费者 --> 观众
 */
class Audience extends Thread {
    Film film;

    public Audience(Film film) {
        this.film = film;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            film.watch();
        }
    }
}

/**
 * 产品 --> 电影
 */
class Film {
    String name;
    boolean flag = true;

    /**
     * 拍戏
     */
    public synchronized void make(String name) {

        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员拍了：" + name);
        this.notifyAll();
        this.name = name;
        this.flag = !this.flag;
    }

    /**
     * 观看
     */
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("观看了：" + name);
        this.notifyAll();
        this.flag = !this.flag;

    }
}