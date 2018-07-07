package com.jiang.cn.observerpattern;

/**
 * 主题
 */
public interface Subject {

    void  registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserve(Object args);
}
