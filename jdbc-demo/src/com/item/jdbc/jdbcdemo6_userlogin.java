package com.item.jdbc;

import com.item.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class jdbcdemo6_userlogin {


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
        String pwd = "' or '1' = '1";//

        String sql = "select * from tb_user where username= '"+name+"' and password = '"+pwd+"'";

        //获取stmt对象
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //判断登录是否失败
        if (rs.next()){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }


/*        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();*/

    }

}
