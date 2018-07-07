package com.jiang.cn.adapterpattern;

/**
 * http请求适配器
 */
public class HttpHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof  HttpController);
    }

    @Override
    public void handler(Object handler) {
        ((HttpController)handler).doHttpHandler();
    }
}
