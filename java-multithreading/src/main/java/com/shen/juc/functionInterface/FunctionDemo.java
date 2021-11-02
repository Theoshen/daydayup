package com.shen.juc.functionInterface;

import java.util.function.Function;

/**
 * @Description 函数式接口 1
 * @author chensihua
 * @createTime 20:06 2021/11/2
 * @return
 * @version 1.0.0
 */
public class FunctionDemo {
    public static void main(String[] args) {
    	Function function = new Function<String,String>(){
            @Override
            public String apply(String s){
                return s;
            }
        };

        Function f = (str) -> {return str;};

        System.out.println(f.apply("22222"));
        System.out.println(function.apply("111111"));
    	}

}
