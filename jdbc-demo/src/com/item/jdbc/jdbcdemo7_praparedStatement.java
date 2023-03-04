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

}
