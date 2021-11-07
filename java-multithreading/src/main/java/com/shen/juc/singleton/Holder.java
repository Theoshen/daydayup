package com.shen.juc.singleton;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Holder.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年11月07日 21:23:00
 */
public class Holder {
    private Holder(){
    }
    public static Holder getInstace(){
        return InnerClass.HOLDER;
    }
    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}
