package com.cyril.web.resp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp3")
public class respDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应头，响应html，和解决中文乱码问题
        resp.setContentType("text/html;charset=utf-8");
        // 获取字符输出流
        PrintWriter writer = resp.getWriter();
        // 响应
        writer.write("你好");
        writer.write("<h1>Cyril</h1>");
    }
}
