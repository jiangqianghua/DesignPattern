package com.jiang.cn.adapterpattern;

/**
 * 表单适配器
 */
public class FormHandlerAdapter implements HandlerAdapter{

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof FormController);
    }

    @Override
    public void handler(Object handler) {
        ((FormController)handler).doFormHandler();
    }
}
