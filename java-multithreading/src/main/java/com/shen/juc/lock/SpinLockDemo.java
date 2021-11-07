package com.shen.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName SpinLockDemo.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年11月07日 21:41:00
 */
public class SpinLockDemo {
    // int   0
    // Thread  null
    // 原子引用
    AtomicReference<Thread> atomicReference =
            new AtomicReference<>();
    // 加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()
                + "==> mylock");
        // 自旋锁
        while (!atomicReference.compareAndSet(null,thread)){
        }
    }
    // 解锁
    // 加锁
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()
                + "==> myUnlock");
        atomicReference.compareAndSet(thread,null);// 解锁
    }
}
class TestSpinLock {
    public static void main(String[] args) throws
            InterruptedException {
//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lock();
//        reentrantLock.unlock();
        // 底层使用的自旋锁CAS
        SpinLockDemo lock = new SpinLockDemo();// 定义锁
        new Thread(()-> {
            lock.myLock();// 加锁
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();// 解锁
            }
        },"T1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()-> {
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        },"T2").start();
    }
}



