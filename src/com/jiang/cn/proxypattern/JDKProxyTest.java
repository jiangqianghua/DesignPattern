package com.jiang.cn.proxypattern;

/**
 * 以下使用jdk提供的proxy代理实现代理功能
 */
public class JDKProxyTest {

    static ILogin login ;
   // static IRegister register;

    public static void main(String[] args) {
        //login = (ILogin) new LogAopHandler().getInstance(new AdminLogin());
        //login = new LogginProxy(new AdminLogin());
        login = new AdminLogin();
        login.login();









        //register = (IRegister) new LogAopHandler().getInstance(new AdminRegister())
        //register.register();
    }
}


