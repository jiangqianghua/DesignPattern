package com.jiang.cn.adapterpattern;

public class AdapterDemo {
    public static void main(String[] args) {
        HttpServletRequest request = new HttpServletRequest();
        request.setContextPath(HttpController.class);
        HttpServletResponse response = null;

        // 模拟执行disaptchSerlvet，实际这块是由tomcat请求
        DispatchServlet dispatchServlet = new DispatchServlet();
        dispatchServlet.doDispatch(request,response);
    }
}
