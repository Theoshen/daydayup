package com.shen.multithreading.lambda;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestLambda2.java
 * @email theoshen@foxmail.com
 * @Description lambda 测试
 * @createTime 2021年10月12日 17:24:00
 */
public class TestLambda2 {

    public static void main(String[] args) {
        Ilove love = null;
        // 1. lambda 简化
    	love = (int a) -> {
            System.out.println("7777777" + "--->>>" + a);
        };

        // 2. 简化参数类型
        love = (a) -> {
            System.out.println("7777777" + "--->>>" + a);
        };


        // 3. 简化括号
        love = a -> {
            System.out.println("7777777" + "--->>>" + a);
        };


        // 4. 简化花括号
        love = a -> System.out.println("7777777" + "--->>>" + a);

         love.love(77);
    	}

        // 总结 ：
                // lambda 表达式只能有一行代码的情况下才能简化成为一行，如果有多行，用代码块包裹
                // 前提是接口为函数式接口
                // 多个参数也可以去掉参数类型，要去掉就都去掉，必须加上括号，



}

interface Ilove{
    void love(int a);
}

