package com.jiang.cn.proxypattern.jdkproxy;

/**
 * 以下使用jdk提供的proxy代理实现代理功能
 */
public class JDKProxyTest {

    public static void main(String[] args) {

        Person person = (Person) new HomeLink().getInstance(new Master());
        person.searchHome();

    }
}


