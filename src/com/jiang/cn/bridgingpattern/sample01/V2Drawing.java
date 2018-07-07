package com.jiang.cn.bridgingpattern.sample01;

public class V2Drawing implements Drawing {
    DP2 dp2 ;

    public V2Drawing() {
        dp2 = new DP2();
    }

    @Override
    public void drawRantangle() {
        dp2.draw_2_Rantangle();
    }

    @Override
    public void drawCircle() {
        dp2.draw_2_Circle();
    }
}
