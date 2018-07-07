package com.jiang.cn.bridgingpattern.sample01;

public class Circle extends Shape {

    public Circle(Drawing myDrawing) {
        super(myDrawing);
    }

    @Override
    public void draw() {
        drawCircle();
    }
}
