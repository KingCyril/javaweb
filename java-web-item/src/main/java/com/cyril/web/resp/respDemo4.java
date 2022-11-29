package com.cyril.web.resp;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp4")
public class respDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取文件
        FileInputStream fileInputStream = new FileInputStream("static/girl.jpeg");

        // 获取字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();

        // copy
            /*
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
        */

        // 简化copy
        /**
         *     <dependency>
         *       <groupId>commons-io</groupId>
         *       <artifactId>commons-io</artifactId>
         *       <version>2.6</version>
         *     </dependency>
         */
        IOUtils.copy(fileInputStream,outputStream);

        // 关闭
        fileInputStream.close();
    }
}
