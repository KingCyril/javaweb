package com.cyril.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet("/demo1")
public class ServletDemo1 implements Servlet {

    /**
     * 初始化方法，在Servlet被创建时执行，只执行一次
     */
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    /**
     * 获取ServletConfig对象
     */
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法，每次Servlet被访问，都会调用该方法
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 获取请求方式
        String method = request.getMethod();
        // 判断
        if("GET".equals(method)){
            // get请求...
        } else if ("POST".equals(method)) {
            // post请求...
        }
    }

    /**
     * 获取Servlet信息
     */
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法，当Servlet被销毁时，调用该方法。在内存释放或服务器关闭时销毁Servlet对象
     */
    public void destroy() {

    }
}
