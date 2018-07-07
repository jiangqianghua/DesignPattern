package com.jiang.cn.bridgingpattern.sample01;

public abstract class Shape {

    protected Drawing myDrawing ;

    public Shape(Drawing myDrawing) {
        this.myDrawing = myDrawing;
    }
    abstract  public void draw();

    protected  void drawRectangle(){
        myDrawing.drawRantangle();

    }

    protected  void drawCircle(){
        myDrawing.drawCircle();
    }
}
