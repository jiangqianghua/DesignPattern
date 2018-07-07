package com.jiang.cn.observerpattern;

/**
 * 测试类
 */
public class ObserverDemo {

    public static void main(String args[]) {
        WeatherStationN weatherStation = new WeatherStationN();
        ConditionDisplay conditionDisplay = new ConditionDisplay(weatherStation);

        weatherStation.setMeasurements(10);
        weatherStation.setMeasurements(20);
    }

}
