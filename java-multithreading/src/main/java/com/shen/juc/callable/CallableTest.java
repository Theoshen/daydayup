package com.shen.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName CallableTest.java
 * @email theoshen@foxmail.com
 * @Description callable
 * @createTime 2021年10月27日 10:41:00
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // new Thread(new Runnable()).start
        // new Thread(new FutureTask(V)()).start
        // new Thread(new Runnable(V)(Callble)).start
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        // 获取返回结果
        String s =(String) futureTask.get();
        // get 方法可能会产生阻塞，放到最后或者异步通信处理
        System.out.println(s);

    }
}

class MyThread implements Callable<String>{
    @Override
    public String call(){
        System.out.println("call");
        return "123";
    }
}
