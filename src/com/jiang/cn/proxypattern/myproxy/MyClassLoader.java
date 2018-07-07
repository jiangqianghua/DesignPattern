package com.jiang.cn.proxypattern.myproxy;

import java.io.*;

public class MyClassLoader extends ClassLoader
{
    private File baseDir ;

    public MyClassLoader() {
        String baseDir = MyClassLoader.class.getResource("").getPath();
        this.baseDir = new File(baseDir);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName()+"."+name;
        if(baseDir != null){
            File classFile = new File(baseDir,name.replaceAll("\\.","/")+".class");
            System.out.println("class file path:"+classFile);
            System.out.println("class exites:"+classFile.exists());
            if(classFile.exists()){
                FileInputStream in = null ;
                ByteArrayOutputStream out = null ;

                try {
                    in = new FileInputStream(classFile);

                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[2014];
                    int len ;
                    while ((len = in.read(buff)) != -1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if(in != null){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if(out != null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
