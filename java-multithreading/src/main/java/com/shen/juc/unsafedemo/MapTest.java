package com.shen.juc.unsafedemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName MapTest.java
 * @email theoshen@foxmail.com
 * @Description Map
 * @createTime 2021年10月27日 10:27:00
 */
public class MapTest {
    public static void main(String[] args) {
        // map 如何使用，默认等价于什么？
		// 不会使用new HashMap<>()
		// 默认等价于 new HashMap<>(16,0.75)
		// 加载因子，初始化容量
		// 并发下 HashMap 不安全
		// Map<String, String> map = new HashMap<>(); 不安全  java.util.ConcurrentModificationException 并发修改异常
		// 解决方案： 1、Collections.synchronizedMap(new HashMap<>());
		// 			2、new ConcurrentHashMap();

        Map<String, String> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 30; i++) {
			new Thread(()->{
				map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
				System.out.println(map);
			},String.valueOf(i)).start();
		}
    }
}
