package com.it.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _02ShiWu {

    public static void main(String[] args) throws Exception {

        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1?useSSL=false","root","Aa123456");
        // 定义sql语句，期望：这两个sql要么同时执行成功，要么同时失败
        String sql1 = "UPDATE account SET money = 4000 WHERE id = 1";
        String sql2 = "UPDATE account SET money = 4000 WHERE id = 2";
        // 获取执行sql对象
        Statement statement = conn.createStatement();
        try {
            // 开启事务
            conn.setAutoCommit(false);
            // 执行sql1
            int i = statement.executeUpdate(sql1);
            // 处理返回结果
            System.out.println(i);

            // int num = 3 / 0; // 手动造错误

            // 执行sql2
            int count = statement.executeUpdate(sql2);
            // 处理返回结果
            System.out.println(count);

            // 提交事务
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();

            // 回滚事务
            conn.rollback();
        }
        // 释放资源
        statement.close();
        conn.close();
    }
}
