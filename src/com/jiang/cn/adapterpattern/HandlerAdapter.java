package com.jiang.cn.adapterpattern;

/**
 * 定义一个适配器接口，仿照springmvc
 */
public interface HandlerAdapter {

    /**
     * 判断该对象是否支持适配器
     * @param handler
     * @return
     */
    boolean supports(Object handler);

    /**
     * 执行handler
     * @param handler
     */
    public void handler(Object handler);
}
