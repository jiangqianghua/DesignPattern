package com.jiang.cn.factorypattern;

public class ShapeFactory {

    /**
     * 利用反射返回对象
     * @param clazz
     * @return
     */
    public static Object getClass(Class<?extends Shape> clazz){
        Object obj = null ;
        try {
            obj = Class.forName(clazz.getName()).newInstance();
        }catch(Exception e){
            e.printStackTrace();
        }
        return obj ;
    }
}
