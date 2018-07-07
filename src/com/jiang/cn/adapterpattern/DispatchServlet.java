package com.jiang.cn.adapterpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * servlet请求，消息分发,请求内容是从request来的，这里模拟直接new
 */
public class DispatchServlet {


    private  List<HandlerAdapter> handlerAdapterList = new ArrayList<HandlerAdapter>();

    public DispatchServlet() {
        handlerAdapterList.add(new HttpHandlerAdapter());
        handlerAdapterList.add(new FormHandlerAdapter());
    }

    /**
     * 模拟Servlet doDispatch
     * @param request
     * @param response
     */
    public void doDispatch(HttpServletRequest request , HttpServletResponse response){

        // 模拟获取Context参数
        Class<? extends Controller> clazz = request.getContextPath();
        if(clazz == null){
            System.out.println("can not find context...");
        }

        Controller controller = null;
        try {
            controller = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        HandlerAdapter handler = getHandler(controller);

        if(handler == null){
            System.out.println("can not find handler");
        }

        handler.handler(controller);


    }


    private HandlerAdapter getHandler(Controller controller){
        for(HandlerAdapter adapter:this.handlerAdapterList){
            if(adapter.supports(controller))
                return adapter;
        }
        return null ;
    }
}
