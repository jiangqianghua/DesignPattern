package com.jiang.cn.proxypattern.myproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 自己实现类似java的proxy代理模式
 */
public class JProxy {

    private static String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader loader , Class<?>[] interfaces , MyInvovationHandler h){
        try {
            // 获取代理生成的源码
            String proxySrc = generateSrc(interfaces[0]);
            // 获取源码输出的磁盘
            String filePath = JProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            System.out.println(f.getAbsolutePath());
            fw.write(proxySrc);
            fw.flush();
            fw.close();
            // 编译源码，生成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            // 将class文件中的内容，动态加载到jvm中
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();
            //  返回被代理后的对象
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(MyInvovationHandler.class);
            return c.newInstance(h);
        }catch (Exception e){

        }
        return null ;

    }

    /**
     * 代理源码拼接
     */
    private static String generateSrc (Class<?> interfaces){
        StringBuffer src = new StringBuffer();
        src.append("package com.jiang.cn.proxypattern.myproxy;"+ln);
        src.append("import java.lang.reflect.Method;"+ln);
        src.append("public class $Proxy0 implements "+interfaces.getName() + " { "+ln);
        src.append("MyInvovationHandler h;"+ln);
        src.append("public $Proxy0(MyInvovationHandler h){"+ln);
        src.append("this.h = h;}"+ln);

        for(Method m:interfaces.getMethods()){
            src.append("public "+m.getReturnType().getName() + " " + m.getName() + "(){"+ln);
            src.append("try{"+ln);
            src.append("Method m = "+ interfaces.getName()+".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);"+ln);
            src.append("}catch(Throwable e){e.printStackTrace();}"+ln);
            src.append("}"+ln);
        }
        src.append("}");
        return src.toString();

    }
}
