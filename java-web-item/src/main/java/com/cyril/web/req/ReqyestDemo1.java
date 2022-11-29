package com.cyril.web.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/demo4")
public class ReqyestDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 浏览器使用utf-8字符集将中文编码
         * tomcat使用ISO-8859-1字符集解码
         * 产生乱码
         */
        // 获取参数
        String username = req.getParameter("username");
        // 得到字节码
        byte[] bytes = username.getBytes("ISO-8859-1");
        // 转为汉字
        String s = new String(bytes, "utf-8");
        System.out.println(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决post中文乱码
        req.setCharacterEncoding("UTF-8");

        // 获取参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String s : parameterMap.keySet()) {
            System.out.print(s + ":");

            String[] strings = parameterMap.get(s);
            for (String string : strings) {
                System.out.print(string + " ");
            }

            System.out.println();
        }
    }
}
