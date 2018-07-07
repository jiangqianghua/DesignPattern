package com.jiang.cn.factorypattern;

/**
 * 工厂模式
 */
public class FactoryPatternDemo {
    public static void main(String args[]){
        Circle circle = (Circle)ShapeFactory.getClass(Circle.class);
        circle.draw();

        Rectangle rectangle = (Rectangle)ShapeFactory.getClass(Rectangle.class);
        rectangle.draw();
    }

}
