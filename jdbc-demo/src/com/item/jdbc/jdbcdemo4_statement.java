package com.item.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcdemo4_statement {

  /**
   * 执行DML语句
   * @throws Exception
   */
  @Test
  public void testDML() throws Exception {
    //1.注册驱动
    //Class.forName("com.mysql.jdbc.Driver");
    //2.获取链接

    String url = "jdbc:mysql:///db1?useSSL=false";
    String username = "root";
    String password = "123456";
    Connection conn = DriverManager.getConnection(url, username, password);

    //3.定义sql
    String sql1 = "update account set money = 3000 where uid = 1";
    //4.获取执行sql的对象Statement
    Statement stmt = conn.createStatement();
    //5.执行sql
    int count1 = stmt.executeUpdate(sql1);//受影响的行数
    //6.处理结果
    //System.out.println(count1);
    if (count1 > 0){
      System.out.println("修改成功");
    }else {
      System.out.println("修改失败");
    }

    //7.释放资源
    stmt.close();
    conn.close();

  }


  /**
   * 执行DDL语句
   * @throws Exception
   */
  @Test
  public void testDDL() throws Exception {
    //1.注册驱动
    //Class.forName("com.mysql.jdbc.Driver");
    //2.获取链接

    String url = "jdbc:mysql:///db1?useSSL=false";
    String username = "root";
    String password = "123456";
    Connection conn = DriverManager.getConnection(url, username, password);

    //3.定义sql
    String sql1 = "drop database db2";
    //4.获取执行sql的对象Statement
    Statement stmt = conn.createStatement();
    //5.执行sql
    int count1 = stmt.executeUpdate(sql1);//受影响的行数
    //6.处理结果
    //System.out.println(count1);
    if (count1 > 0){
      System.out.println("修改成功");
    }else {
      System.out.println("修改失败");
    }

    //7.释放资源
    stmt.close();
    conn.close();

  }
}
