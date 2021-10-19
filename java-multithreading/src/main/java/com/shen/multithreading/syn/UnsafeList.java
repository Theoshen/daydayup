package com.shen.multithreading.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName UnsafeList.java
 * @email theoshen@foxmail.com
 * @Description list 不安全
 * @createTime 2021年10月19日 23:16:00
 */
public class UnsafeList {
    public static void main(String[] args) {
    	List<String> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread(() ->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    	}
}
