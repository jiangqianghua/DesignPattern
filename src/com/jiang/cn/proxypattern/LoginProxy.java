package com.jiang.cn.proxypattern;

public class LoginProxy implements ILogin {
    ILogin login ;
    public LoginProxy(ILogin login){
        this.login = login ;
    }
    public void login(){
        System.out.println("操作前记录操作日志...");
        login.login();
        System.out.println("操作后记录操作日志...");
    }
}
