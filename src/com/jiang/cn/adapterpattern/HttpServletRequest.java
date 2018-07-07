package com.jiang.cn.adapterpattern;

public class HttpServletRequest {

    private Class<? extends Controller> clazz ;
    public void setContextPath(Class<? extends Controller> clazz){
        this.clazz = clazz;
    }
    public Class<? extends Controller> getContextPath(){
        return clazz ;
    }

}
