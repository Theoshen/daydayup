package com.shen.juc.functionInterface;

import java.util.function.Predicate;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName PredicateDemo.java
 * @email theoshen@foxmail.com
 * @Description 断定型接口 一个参数，返回布尔
 * @createTime 2021年11月02日 20:09:00
 */
public class PredicateDemo {
    public static void main(String[] args) {
    	Predicate p = new Predicate<String>(){
            @Override
            public boolean test(String str){
                return str.isEmpty();
            }
        };

        System.out.println(p.test(""));
        System.out.println(p.test("222"));

        Predicate<String> predicate = (str) ->{
            return str.isEmpty();
        };
        System.out.println(predicate.test("3333333"));


    }
}
