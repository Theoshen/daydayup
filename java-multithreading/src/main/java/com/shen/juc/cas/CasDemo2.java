package com.shen.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName CasDemo2.java
 * @email theoshen@foxmail.com
 * @Description 乐观锁
 * @createTime 2021年11月07日 21:28:00
 */
public class CasDemo2 {
    // CAS compareAndSet : 比较并交换！
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);
        /*
         * 类似于我们平时写的SQL：乐观锁
         *
         * 如果某个线程在执行操作某个对象的时候，其他线程若操作了该对象，
         * 即使对象内容未发生变化，也需要告诉我。
         *
         * 期望、更新：
         * public final boolean compareAndSet(int
         *                                    expect, int update)
         * 如果我期望的值达到了，那么就更新，否则，就不更新,
         *                                    CAS 是CPU的并发原语！
         */
        // ============== 捣乱的线程 ==================
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());
        // ============== 期望的线程 ==================
        System.out.println(atomicInteger.compareAndSet(2020, 6666));
        System.out.println(atomicInteger.get());
    }
}
