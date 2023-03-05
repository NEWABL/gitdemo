package com.item.jdbc;

import org.junit.Test;

import java.sql.*;

public class jdbcdemo7_praparedStatement {


    /**
     * 查询account账户表数据，封装为Account对象中，并且存储到Arraylist中
     * 1.定义实体类Account
     * 2.查询数据，分装到Account对象中
     * 3.将Account对象存入arraylist对象中
     *
     *
     * @throws Exception
     */
    @Test
    public void testResultSet2() throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接

        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        //接收用户输入
        String name = "zhangsan";
        String pwd = "' or '1' = '1";//' or '1' = '1

        //定义sql
        String sql = "select * from tb_user where username = ? and password =?";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置？的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);
/*        String sql = "select * from tb_user where username= '"+name+"' and password = '"+pwd+"'";

        //获取stmt对象
        Statement stmt = conn.createStatement();*/

        //执行sql
        ResultSet rs = pstmt.executeQuery();

        //判断登录是否失败
        if (rs.next()){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }


        //7.释放资源
        rs.close();
        pstmt.close();
        conn.close();

    }


    /**
     * 查询account账户表数据，封装为Account对象中，并且存储到Arraylist中
     * 1.定义实体类Account
     * 2.查询数据，分装到Account对象中
     * 3.将Account对象存入arraylist对象中
     *
     *
     * @throws Exception
     */
    @Test
    public void testResultSet() throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接

        String url = "jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        //接收用户输入
        String name = "zhangsan";
        String pwd = "' or '1' = '1";//' or '1' = '1

        //定义sql
        String sql = "select * from tb_user where username = ? and password =?";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置？的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);
/*        String sql = "select * from tb_user where username= '"+name+"' and password = '"+pwd+"'";

        //获取stmt对象
        Statement stmt = conn.createStatement();*/

        //执行sql
        ResultSet rs = pstmt.executeQuery();

        //判断登录是否失败
        if (rs.next()){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }


        //7.释放资源
        rs.close();
        pstmt.close();
        conn.close();

    }
    /**
     * PreparedStatement原理
     * @throws Exception
     */
    @Test
    public void testPreparedStatement2() throws Exception {
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        // useServerPrepStmts=true 参数开启预编译功能
        String url = "jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "' or '1' = '1";
        // 定义sql
        String sql = "select * from tb_user where username = ? and password = ?";
        // 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        Thread.sleep(10000);
        // 设置？的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);
        ResultSet rs = null;
        // 执行sql
        rs = pstmt.executeQuery();
        // 设置？的值
        pstmt.setString(1,"aaa");
        pstmt.setString(2,"bbb");
        // 执行sql
        rs = pstmt.executeQuery();
        // 判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功~");
        }else{
            System.out.println("登录失败~");
        }
          //7. 释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }
}
