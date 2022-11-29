package com.cyril.web.test;

import com.cyril.web.mapper.LoginMapper;
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
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

        // 2、获取sqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取UserMapper接口的代理对象
        LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
        User user = loginMapper.login(username, password);

        System.out.println(user);
        if(user != null){
            PrintWriter writer = resp.getWriter();
            writer.write("Hello " + username);
        }

        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
