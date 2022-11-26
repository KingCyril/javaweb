package com.it.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class _06Test {

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

        queryAll(connection); // 查询数据库所有数据
        // addData(connection); // 添加一条数据
        // updateData(connection); // 更新一条数据
        // deleteData(connection); // 删除一条数据
    }

    public static void deleteData(Connection connection) throws Exception{
        int id = 3;
        // 定义sql语句
        String sql = "delete from tb_brand WHERE id = ?";
        // 获取preparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 设置参数
        preparedStatement.setInt(1,id);

        // 执行sql
        int i = preparedStatement.executeUpdate();
        // 处理返回结果
        if(i != 0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        // 释放资源
        preparedStatement.close();
        connection.close();
    }

    public static void updateData(Connection connection) throws Exception{
        // 定义sql语句
        String sql = "update tb_brand set description=? WHERE id = ?";
        // 获取preparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 设置参数
        preparedStatement.setString(1,"iphone is the lastest");
        preparedStatement.setInt(2,4);
        // 执行sql
        int i = preparedStatement.executeUpdate();
        // 处理返回结果
        if(i != 0){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
        // 释放资源
        preparedStatement.close();
        connection.close();
    }

    public static void addData(Connection connection) throws Exception {
        // 定义sql语句
        String sql = "insert into tb_brand (brand_name, company_name, ordered, description, status) values(?,?,?,?,?)";
        // 获取preparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 设置参数
        preparedStatement.setString(1,"iphone");
        preparedStatement.setString(2,"苹果公司");
        preparedStatement.setInt(3,2);
        preparedStatement.setString(4,null);
        preparedStatement.setInt(5,1);
        // 执行sql
        int i = preparedStatement.executeUpdate();
        // 处理返回结果
        if(i != 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
        // 释放资源
        preparedStatement.close();
        connection.close();
    }

    public static void queryAll(Connection connection) throws Exception {
        ArrayList<Brand> list = new ArrayList<>();

        // 定义sql语句
        String sql = "select * from tb_brand";
        // 获取preparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 执行sql
        ResultSet resultSet = preparedStatement.executeQuery();
        // 处理返回结果
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");

            Brand obj = new Brand(id,brandName,companyName,ordered,description,status);
            list.add(obj);
        }
        System.out.println(list);
        // 释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}