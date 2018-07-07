package com.jiang.cn.proxypattern;

public class AdminRegister implements IRegister {
    @Override
    public void register() {
        System.out.println("管理注册");
    }
}
