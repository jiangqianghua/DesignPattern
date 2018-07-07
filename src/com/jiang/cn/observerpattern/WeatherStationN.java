package com.jiang.cn.observerpattern;

/**
 * 气象站
 */
public class WeatherStationN extends Observable {

    private float temp ;

    public WeatherStationN() {
        super();
    }

    /**
     * 设置温度
     * @param temp
     */
    public void setMeasurements(float temp){
        this.temp = temp;
        notifyObserve(temp);
    }
}
