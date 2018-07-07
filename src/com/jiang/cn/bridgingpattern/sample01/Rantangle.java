package com.jiang.cn.bridgingpattern.sample01;

public class Rantangle extends Shape{
    public Rantangle(Drawing myDrawing) {
        super(myDrawing);
    }

    @Override
    public void draw() {
        drawRectangle();
    }
}
