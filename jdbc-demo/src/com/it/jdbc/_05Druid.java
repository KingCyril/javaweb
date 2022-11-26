package com.it.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

public class _05Druid {

    public static void main(String[] args) throws Exception {

        // 1、导入jar包
        // 2、定义配置文件
        // 3、加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        // 4、获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 5、获取数据库连接 Connection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
        // 定义sql语句
        String sql = "UPDATE account SET money = 8000 WHERE id = 1";
        // 获取执行sql对象
        Statement statement = connection.createStatement();
        // 执行sql
        int i = statement.executeUpdate(sql);
        // 处理返回结果
        System.out.println(i);
        // 释放资源
        statement.close();
        connection.close();
    }
}
