package com.item.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcdemo3_drivermanager {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接

        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql = "update account set money = 1000 where uid = 1";

        //4.获取执行sql的对象Statement
        Statement stmt = conn.createStatement();
        //5.执行sql
        int count = stmt.executeUpdate(sql);
        //6.处理结果
        System.out.println(count);
        //7.释放资源
        stmt.close();
        conn.close();
    }
}
