package com.it.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class _01Basic {

    public static void main(String[] args) throws Exception {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1?useSSL=false","root","Aa123456");
        // 定义sql语句
        String sql = "UPDATE account SET money = 3000 WHERE id = 1";
        // 获取执行sql对象
        Statement statement = conn.createStatement();
        // 执行sql
        int i = statement.executeUpdate(sql);
        // 处理返回结果
        System.out.println(i);
        // 释放资源
        statement.close();
        conn.close();
    }
}
