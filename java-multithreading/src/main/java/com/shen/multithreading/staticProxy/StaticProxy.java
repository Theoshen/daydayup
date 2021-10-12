package com.shen.multithreading.staticProxy;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName StaticProxy.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年10月12日 13:34:00
 */
public class StaticProxy {
    public static void main(String[] args) {
        SantiagoBernabeu santiagoBernabeu = new SantiagoBernabeu(new You());
        santiagoBernabeu.championLeague();
    }

}

interface Match {
    /**
     * @Description 欧冠比赛方法，测试用
     * @author chensihua
     * @createTime 13:56 2021/10/12
     * @return void
     * @version 1.0.0
     */
    void championLeague();
}

/**
 * @Description  真实角色，参加欧冠
 * @author chensihua
 * @createTime 13:37 2021/10/12
 * @version 1.0.0
 */
class You implements Match {

    @Override
    public void championLeague() {
        System.out.println("比赛开始，冲");
    }
}

/** 
 * @Description 代理角色，提供场地
 * @author chensihua
 * @createTime 13:41 2021/10/12
 * @return 
 * @version 1.0.0
 */
class SantiagoBernabeu implements Match {

    private Match target ;

    public SantiagoBernabeu(Match target) {
        this.target = target;
    }

    @Override
    public void championLeague() {
        before();
        this.target.championLeague();
        after();
    }

    private void after() {
        System.out.println("比赛之后，总结、吃饭");
    }

    private void before() {
        System.out.println("比赛之前，热身、训练");
    }
}

