package com.jiang.cn.proxypattern.jdkproxy;

public class Master implements Person{
    @Override
    public void searchHome() {
        System.out.println("我是主人，我要找房子，一室一厅!");
    }
}
