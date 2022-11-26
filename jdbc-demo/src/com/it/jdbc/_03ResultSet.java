package com.it.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class _03ResultSet {

    public static void main(String[] args) throws Exception {

        ArrayList<Account> list = new ArrayList<>();

        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1?useSSL=false","root","Aa123456");
        // 定义sql语句
        String sql = "select * from account";
        // 获取执行sql对象
        Statement statement = conn.createStatement();
        // 执行sql
        ResultSet ret = statement.executeQuery(sql);
        // 处理返回结果
        while (ret.next()){
            /**
             * 通过int类型参数获取数据
             */
            int id = ret.getInt(1);
            String name = ret.getString(3);
            double salary = ret.getDouble(2);
            System.out.println(id + " " + name + " " + salary);
            /**
             * 通过列名获取参数
             */
            int id1 = ret.getInt("id");
            String name1 = ret.getString("ename");
            double salary1 = ret.getDouble("money");
            System.out.println(id1 + " " + name1 + " " + salary1);
            Account account = new Account(id,name,salary);
            list.add(account);
        }
        // 释放资源
        ret.close();
        statement.close();
        conn.close();

        System.out.println(list);
    }
}
