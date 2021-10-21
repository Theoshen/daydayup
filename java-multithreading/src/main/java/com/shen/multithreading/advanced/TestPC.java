package com.shen.multithreading.advanced;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestPC.java
 * @email theoshen@foxmail.com
 * @Description 生产消费者模型 --> 利用缓冲区解决： 管程法
 * @createTime 2021年10月21日 16:38:00
 */
public class TestPC {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Productor(container).start();
        new Consumer(container).start();
    }
}

/**
 * 生产者
 */
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container){
        this.container = container;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            container.push(new Laptop(i));
            System.out.println("生产了" + i + "台笔记本电脑");
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread{
    SynContainer container;

    public Consumer( SynContainer container){
        this.container = container;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了 ---->" + container.pop().id + "台笔记本电脑");
        }
    }
}

/**
 * 产品
 */
class Laptop {
    int id;

    public Laptop(int id) {
        this.id = id;
    }
}

class SynContainer{
    /**
     * 容器大小
     */
    Laptop[] laptops =new Laptop[10];

    /**
     * 计数器
     */
    int count = 0;

    /**
     * 生产者放入产品
     */
    public synchronized void push(Laptop laptop){
        // 容器满了，等待消费者消费
        if (count == laptops.length){
            // 通知消费者消费，生产等待
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        // 容器未满，加入产品
        laptops[count] = laptop;
        count ++;

        // 通知消费者消费
        this.notifyAll();
    }

    public synchronized Laptop pop(){
        if (count == 0 ){
            // 等待生产者生产，消费者等待
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //如果可以消费
        count--;
        Laptop laptop = laptops[count];

        // 无货，则继续生产
        this.notifyAll();

        return laptop;
    }


}