package com.it.jdbc;

import java.sql.*;
import java.util.ArrayList;

public class _04Sql_Inject {

    public static void main(String[] args) throws Exception {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1?useSSL=false","root","Aa123456");

        // 用户信息
        // 正确的用户名和密码，可以登陆成功
        // String username = "zs";
        // String password = "123";
        // 错误的用户名和密码，登陆失败
        String username = "sdfsgshg";
        String password = "' or '1' = '1";
        // 定义sql语句
        String sql = "select * from db_user where name = ? and psd = ?";

        // 获取preparedStatement对象
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        // 设置 ？ 的值
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        // 执行sql
        ResultSet ret = preparedStatement.executeQuery();
        // 处理返回结果
        if (ret.next()){
            System.out.println("登陆成功！");
        }else{
            System.out.println("登陆失败");
        }
        // 释放资源
        ret.close();
        preparedStatement.close();
        conn.close();
    }
}
