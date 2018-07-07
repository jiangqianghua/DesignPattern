package com.jiang.cn.proxypattern.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HomeLink implements InvocationHandler{

    private Person target ;

    public Object getInstance(Person target){
        this.target = target ;
        Class clazz = target.getClass();
        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
        return obj ;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是链家的房子");
        method.invoke(target,args);
        System.out.println("我是链接，房子已经找完了");
        return null;
    }
}
