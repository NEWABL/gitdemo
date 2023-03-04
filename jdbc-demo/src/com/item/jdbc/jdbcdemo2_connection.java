package com.item.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcdemo2_connection {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接

        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql1 = "update account set money = 3000 where uid = 1";
        String sql2 = "update account set money = 3000 where uid = 2";
        //4.获取执行sql的对象Statement
        Statement stmt = conn.createStatement();



        try {
            //开启事务
            conn.setAutoCommit(false);
            //5.执行sql
            int count1 = stmt.executeUpdate(sql1);
            //6.处理结果
            System.out.println(count1);
            int i = 3/0;
            //5.执行sql
            int count2 = stmt.executeUpdate(sql2);
            //6.处理结果
            System.out.println(count2);

            //提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚事务
            conn.rollback();

            throw new RuntimeException(e);
        }


        //提交事务

        //7.释放资源
        stmt.close();
        conn.close();
    }
}
