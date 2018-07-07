package com.jiang.cn.proxypattern.myproxy;

import java.lang.reflect.Method;

public interface MyInvovationHandler {

    public Object invoke(Object proxy, Method method , Object[] args) throws Throwable;
}
