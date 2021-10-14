package com.shen.multithreading.state;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestStop.java
 * @email theoshen@foxmail.com
 * @Description 测试 stop 停止状态
 * 1、建议线程正常停止 ----》 利用次数，不建议死循环
 * 2、建议使用标志位  设置一个标志位
 * 3、不要使用stop或者destroy等过时或者jdk不建议使用的方法
 * @createTime 2021年10月14日 16:10:00
 */
public class TestStop implements Runnable {
    /**
     * @Description 1、设置一个标识位
     * @author chensihua
     * @createTime 16:18 2021/10/14
     * @return
     * @version 1.0.0
     */
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run....Thread" + i++);
        }
    }

    /** 
     * @Description 2、设置一个公开的方法停止线程，转换标识位
     * @author chensihua
     * @param 
     * @createTime 16:19 2021/10/14
     * @return void
     * @version 1.0.0
     */
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();

        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if (i == 900){
                testStop.stop();
                System.out.println("线程该停止了");
            }
        }
    }

}
