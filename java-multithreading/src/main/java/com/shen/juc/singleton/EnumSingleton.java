package com.shen.juc.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName EnumSingleton.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年11月07日 21:24:00
 */
public enum EnumSingleton {
    INSTANCE;
    public EnumSingleton getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingleton instance2 = declaredConstructor.newInstance();
        // NoSuchMethodException: com.shen.singleton.EnumSingleton.<init>()
        System.out.println(instance1);
        System.out.println(instance2);
    }
}