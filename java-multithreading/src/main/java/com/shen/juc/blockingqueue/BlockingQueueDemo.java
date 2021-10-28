package com.shen.juc.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName BlockingQueueDemo.java
 * @email theoshen@foxmail.com
 * @Description 阻塞队列
 * @createTime 2021年10月28日 10:54:00
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        test4();
    	}

        /**
         * @Description 队列满抛出异常
         */
        public static void test1(){
            ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
            System.out.println(blockingQueue.add("a"));
            System.out.println(blockingQueue.add("b"));
            System.out.println(blockingQueue.add("c"));
            // java.lang.IllegalStateException: Queue full
            // System.out.println(blockingQueue.add("d"));
            System.out.println("================");

            System.out.println(blockingQueue.remove());
            System.out.println(blockingQueue.remove());
            System.out.println(blockingQueue.remove());
            // java.util.NoSuchElementException
            // System.out.println(blockingQueue.remove());

        }

        /**
         * @Description 不抛出异常
         */
        public static void test2(){
            ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
            System.out.println(blockingQueue.offer("a"));
            System.out.println(blockingQueue.offer("b"));
            System.out.println(blockingQueue.offer("c"));
            // 返回 false
            System.out.println(blockingQueue.offer("d"));

            System.out.println("================");
            // 检测队首元素 peek()
            System.out.println(blockingQueue.peek());

            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll());
            // 返回 null
            System.out.println(blockingQueue.poll());
        }

        /**
         * @Description 等待，一直阻塞
         */
        public static void test3() throws InterruptedException {
            ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
            blockingQueue.put("a");
            blockingQueue.put("b");
            blockingQueue.put("c");
            // 一直阻塞
            // blockingQueue.put("d");
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            // 无元素，一直等待
            System.out.println(blockingQueue.take());
        }

        /**
         * @Description 等待，超时退出
         */
        public static void test4()  throws InterruptedException{
            ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
            blockingQueue.offer("a");
            blockingQueue.offer("b");
            blockingQueue.offer("c");
            // 等待超过2s后退出
            blockingQueue.offer("d",2, TimeUnit.SECONDS);

            System.out.println("================");
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll());
            blockingQueue.poll(2,TimeUnit.SECONDS);
        }

}
