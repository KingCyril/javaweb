package com.cyril;

import com.cyril.mapper.UserMapper;
import com.cyril.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis快速入门
 */
public class MybatisDemo {

    public static void main(String[] args) throws IOException {

        // 1、加载mybatis的核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、获取sqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、执行sql
        // List<User> list = sqlSession.selectList("userInfo.selectAll");

        // 3、获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // List<User> users = userMapper.selectAll();
        User user = userMapper.selectById(1);
        //
        System.out.println(user);

        // 释放资源
        sqlSession.close();
    }


}
