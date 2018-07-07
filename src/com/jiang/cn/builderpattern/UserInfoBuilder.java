package com.jiang.cn.builderpattern;

public class UserInfoBuilder {

    private String name ;

    private String sex ;

    private int age ;
    public UserInfoBuilder(String name){
        this.name = name ;
    }

    public UserInfoBuilder setSex(String sex){
        this.sex = sex ;
        return this;
    }

    public UserInfoBuilder setAge(int age){
        this.age = age ;
        return this;
    }

    public UserInfo create(){
        return new UserInfo(name,sex,age);
    }
}
