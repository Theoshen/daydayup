package com.theoshen.designPattern.factory.simpleFactory;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName HotPot.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年05月06日 14:45:00
 */
public abstract class Hotpot {
    protected String name;

    public void perpare(){
        System.out.println("点菜，选锅底");
    }

    public void fire(){
        System.out.println("煮火锅");
    }

    public void eat(){
        System.out.println("煮好了，吃嘛");
    }
}
