package com.jiang.cn.bridgingpattern.sample01;

public class V1Drawing implements Drawing {
    DP1 dp1 ;

    public V1Drawing() {
        dp1 = new DP1();
    }

    @Override
    public void drawRantangle() {
        dp1.draw_1_Rantangle();
    }

    @Override
    public void drawCircle() {
        dp1.draw_1_Circle();
    }
}
