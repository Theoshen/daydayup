package com.shen.multithreading.syn;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName UnsafeBank.java
 * @email theoshen@foxmail.com
 * @Description 线程不安全的取钱问题
 * @createTime 2021年10月19日 23:01:00
 */
public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(1000,"结婚资金");

        Drawing you = new Drawing(account,50,"你");
        Drawing girlfriend = new Drawing(account,100,"女朋友");


        you.start();
        girlfriend.start();

    }
}


class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}


class Drawing extends Thread {
    Account account;

    int drawingMoney;

    int nowMoney;

    public Drawing( Account account,int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        // synchronized 同步块
        synchronized (account){
            // 判断是否有钱
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够，不能取");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.money = account.money - drawingMoney;

            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额为" + account.money);

            System.out.println(this.getName() + "手里的钱" + nowMoney);
        }

    }

}