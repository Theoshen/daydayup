package com.shen.juc.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName ReadLockDemo.java
 * @email theoshen@foxmail.com
 * @Description ReadWriteLock
 *              独占锁（写锁）一次只能被一个线程占有
 *              共享锁（读锁）多个线程可以同时占有
 *              读 - 读 可以共存
 *              读 - 写 不共存
 *              写 - 写 不共存
 * @createTime 2021年10月28日 10:29:00
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCacheLock myCache = new MyCacheLock();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "",temp + "");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            },String.valueOf(i)).start();
        }
    }
}

class MyCacheLock{
    private volatile Map<String,Object> map = new HashMap<>();
    /** 
     * @Description 读写锁，更细粒度控制
     */
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /** 
     * @Description 存，写入的时候只有一个线程在写
     * @author chensihua
     * @param key
     * @param value
     * @createTime 10:39 2021/10/28
     * @return void
     * @version 1.0.0
     */
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "写入完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }


    /** 
     * @Description 读取的时候都可以读取
     * @author chensihua
     * @param key
     * @createTime 10:39 2021/10/28
     * @return void
     * @version 1.0.0
     */
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}


/**
 * @Description 自定义缓存 无锁
 * @author chensihua
 * @version 1.0.0
 */
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();

    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName() + "写入完毕");

    }

    public void get(String key){
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完毕");
    }
}