package com.item.jdbc;

import com.item.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class jdbcdemo5_resultset {
    /**
     *
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
        String sql = "select * from account";
        //4.获取执行sql的对象Statement
        Statement stmt = conn.createStatement();
        //5.执行sql
        ResultSet rs = stmt.executeQuery(sql);
        //6.处理结果
/*        //6.1光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()){
            //6.2 获取数据getXXX
            int id = rs.getInt(1);
            String name= rs.getString(2);
            double money = rs.getDouble(3);

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);

            System.out.println("--------------");


        }*/
        //6.1光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()){
            //6.2 获取数据getXXX
            int id = rs.getInt("uid");
            String name= rs.getString("name");
            double money = rs.getDouble("money");

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);

            System.out.println("--------------");


        }
        //7.释放资源
        rs.close();
        stmt.close();
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
    public void testResultSet2() throws Exception {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取链接

        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.定义sql
        String sql = "select * from account";
        //4.获取执行sql的对象Statement
        Statement stmt = conn.createStatement();
        //5.执行sql
        ResultSet rs = stmt.executeQuery(sql);
        //创建集合
        List<Account> list = new ArrayList<>();
        //6.处理结果
        //6.1光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()){
            Account account = new Account();
            //6.2 获取数据getXXX
            int id = rs.getInt("uid");
            String name= rs.getString("name");
            double money = rs.getDouble("money");

           //赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);
            //存入集合
            list.add(account);
        }
        System.out.println(list);
        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();

    }

}
