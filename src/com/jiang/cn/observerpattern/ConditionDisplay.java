package com.jiang.cn.observerpattern;

/**
 * 气象显示站
 */
public class ConditionDisplay implements Observer,DispayElement {

    private float temp ;

    private Observable weatherStation ;

    public ConditionDisplay(Observable weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("显示温度："+temp);
    }

    @Override
    public void update(Observable observable, Object args) {
        if(observable instanceof WeatherStationN){
            this.temp = (float)args;
            display();
        }
    }
}
