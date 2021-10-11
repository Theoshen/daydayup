package com.theoshen.designPattern.singleton;

public enum SingletonEnum {
    instance;

    private SingletonEnum() {}

    public void method(){
    }

    public static void main(String[] args) {
        long start = System.nanoTime(); //获取开始时间
        SingletonEnum.instance.method();
        long end = System.nanoTime(); //获取结束时间
        System.out.println(instance.hashCode());
        System.out.println(instance);

        System.out.println("程序运行时间： " + (end - start) + "ns");
    	}
}
