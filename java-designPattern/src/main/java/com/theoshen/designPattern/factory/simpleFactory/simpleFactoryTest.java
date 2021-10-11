package com.theoshen.designPattern.factory.simpleFactory;

import java.util.Scanner;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName simpleFactoryTest.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年05月06日 15:11:00
 */
public class simpleFactoryTest {
    public static void main(String[] args) {
        SimpleHotpotFactory factory = new SimpleHotpotFactory();
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        factory.createHotpot(type);

    }
}
