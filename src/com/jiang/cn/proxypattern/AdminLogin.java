package com.jiang.cn.proxypattern;

public class AdminLogin implements ILogin {
    @Override
    public void login() {
        System.out.println("管理员登录...");
    }
}
