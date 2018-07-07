package com.jiang.cn.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者，管理被观察者列表
 */
public class Observable implements Subject {
    private List<Observer> observerList ;
    private Object args  ;

    public Observable() {
        observerList = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observerList.indexOf(o);
        if(i >=0 )
            observerList.remove(o);
    }

    @Override
    public void notifyObserve(Object args) {
        this.args = args ;
        for(int i = 0 ; i < observerList.size() ; i++){
            Observer o = observerList.get(i);
            o.update(this,args);
        }
    }


}
