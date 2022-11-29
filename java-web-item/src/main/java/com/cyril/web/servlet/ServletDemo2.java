package com.cyril.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/demo")
public class ServletDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get请求...
        // 获取请求行信息
        System.out.println(req.getMethod()); // 获取请求方式
        System.out.println(req.getContextPath()); // 获取虚拟目录（项目访问路径）
        System.out.println(req.getRequestURI()); // 获取URI（统一资源标识符）
        System.out.println(req.getRequestURL().toString()); // 获取URL（统一资源定位符）
        System.out.println(req.getQueryString()); // 获取get请求的参数

        // 获取请求头
        System.out.println(req.getHeader("user-agent"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post请求...
        /**
         * 获取请求体
         * getInputStream() 获取字节输入流，文件之类的使用
         * getReader() 获取字符输入流
         */
        // 获取字符输入流
        BufferedReader reader = req.getReader();
        // 读取数据
        String line = reader.readLine();
        System.out.println(line);
    }
}
