package com.cyril.web.test;

import com.cyril.web.mapper.LoginMapper;
import com.cyril.web.mapper.RegisterMapper;
import com.cyril.web.pojo.User;
import com.cyril.web.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/register")
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

        // 2、获取sqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3、获取UserMapper接口的代理对象
        RegisterMapper registerMapper = sqlSession.getMapper(RegisterMapper.class);
        int i = registerMapper.register(username, password);

        if(i != 0){
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.write(username + "注册成功！");
        }

        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
