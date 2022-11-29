package com.cyril.web.resp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resp1")
public class respDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("resp1...");

        // 获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        /**
         * // 设置响应状态码
         * resp.setStatus(302);
         * // 设置响应头，重定向
         * resp.setHeader("Location",contextPath + "/resp2");
         */

         // 简化写法，要带上虚拟路径
         resp.sendRedirect(contextPath + "/resp2");
         // resp.sendRedirect("https://baidu.com");
    }
}
