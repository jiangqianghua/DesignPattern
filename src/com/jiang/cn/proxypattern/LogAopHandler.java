package com.jiang.cn.proxypattern;

import com.jiang.cn.proxypattern.myproxy.JProxy;
import com.jiang.cn.proxypattern.myproxy.MyClassLoader;
import com.jiang.cn.proxypattern.myproxy.MyInvovationHandler;

import java.lang.reflect.Method;

/**
 * 专门记录操作日志的切面
 */
public class LogAopHandler implements MyInvovationHandler{

    private Object target ;

    public Object getInstance(Object target){
        this.target = target ;
        Class clazz = target.getClass();
        Object obj = JProxy.newProxyInstance(new MyClassLoader(),clazz.getInterfaces(),this);
        return obj ;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("操作前记录操作日志...");
        method.invoke(target,args);
        System.out.println("操作后记录操作日志...");
        return null;
    }
}
