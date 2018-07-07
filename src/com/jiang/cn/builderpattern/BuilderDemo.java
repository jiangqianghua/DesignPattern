package com.jiang.cn.builderpattern;

public class BuilderDemo {

    public static void main(String args[]){
        UserInfo userInfo = new UserInfoBuilder("hudan").setSex("female").setAge(27).create();
        System.out.println(userInfo.toString());
    }
}
