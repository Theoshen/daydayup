package com.shen.multithreading.lambda;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName TestLambda1.java
 * @email theoshen@foxmail.com
 * @Description 推导lambda
 * @createTime 2021年10月12日 17:03:00
 */
public class TestLambda1 {


    /**
     * @Description 3.静态内部类
     * @author chensihua
     * @createTime 17:09 2021/10/12
     * @return
     * @version 1.0.0
     */
    static class Like2 implements Ilike{

        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }


    public static void main(String[] args) {
       Ilike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        /** 
         * @Description 4.局部内部类
         * @author chensihua
         * @param args
         * @createTime 17:13 2021/10/12
         * @return void
         * @version 1.0.0
         */
        class Like3 implements Ilike{

            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        like = new Like3();
        like.lambda();
        
        
        /** 
         * @Description 5.匿名内部类
         * @author chensihua
         * @param args
         * @createTime 17:14 2021/10/12
         * @return void
         * @version 1.0.0
         */
        like = new Ilike(){
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };

        like.lambda();
        
        /** 
         * @Description 6.lambda 简化
         * @author chensihua
         * @param args
         * @createTime 17:22 2021/10/12
         * @return void
         * @version 1.0.0
         */
        like = () -> {
            System.out.println("I like lambda5");
        };
        like.lambda();
        
    }
}

/**
 * @Description 1.定义一个函数接口 函数式接口方法，测试用第一步
 * @author chensihua
 * @param
 * @createTime 17:06 2021/10/12
 * @return void
 * @version 1.0.0
 */
interface Ilike{
    void lambda();
}

/**
 * @Description 2.实现类
 * @author chensihua
 * @createTime 17:08 2021/10/12
 * @return
 * @version 1.0.0
 */
class Like implements Ilike {

    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}