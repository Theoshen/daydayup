package com.shen.multithreading.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestSleep2.java
 * @email theoshen@foxmail.com
 * @Description 模拟倒计时
 * @createTime 2021年10月14日 16:30:00
 */
public class TestSleep2{

    public static void main(String[] args) {
        nowTime();
    }

    /** 
     * @Description 打印系统当前时间
     * @author chensihua
     * @param 
     * @createTime 16:37 2021/10/14
     * @return void
     * @version 1.0.0
     */
    public static void nowTime(){
        Date nowTime = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(nowTime));
                nowTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    /** 
     * @Description 模拟倒计时
     * @author chensihua
     * @param 
     * @createTime 16:34 2021/10/14
     * @return void
     * @version 1.0.0
     */
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<= 0 ){
                break;
            }
        }
    }
}
