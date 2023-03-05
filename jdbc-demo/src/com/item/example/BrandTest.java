package com.item.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.item.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {
    /**
     * ��ѯ����
     * 1.sql��select * from tb_brand
     * 2.����������Ҫ
     * 3.�����list<brand>
     */
    @Test
    public void testSelectAll() throws Exception {
       //1.��ȡ���ݿ����Ӷ���
        //���������ļ�
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //��ȡ���Ӷ���
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //��ȡ���ݿ����� Connection
        Connection conn = dataSource.getConnection();

        //2.����sql
        String sql = "select * from tb_brand";

        //3.��ȡpstmt����
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.���ò���

        //5.ִ��sql
        ResultSet rs = pstmt.executeQuery();

        //6.������ List<Brand>��װBrand����ת��List����
        Brand brand = null;
        List<Brand> brands = new ArrayList<>();
        while (rs.next()){
            //��ȡ����
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String conpanyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String deccription = rs.getString("description");
            int status = rs.getInt("status");
            //��װBrand����
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(conpanyName);
            brand.setOrdered(ordered);
            brand.setDescription(deccription);
            brand.setStatus(status);
            //װ�ؼ���
            brands.add(brand);
        }
        System.out.println(brands);
        //�ͷ���Դ
        rs.close();
        pstmt.close();
        conn.close();
    }
    /**
     * ���
     * 1. SQL��insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);
     * 2. ��������Ҫ������id֮������в�����Ϣ
     * 3. �����boolean
     */
    @Test
    public void testAdd() throws Exception {
        // ����ҳ���ύ�Ĳ���
        String brandName = "��ƮƮ";
        String companyName = "��ƮƮ";
        int ordered = 1;
        String description = "�Ƶ���һȦ";
        int status = 1;
        //1. ��ȡConnection
        //3. ���������ļ�
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //4. ��ȡ���ӳض���
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5. ��ȡ���ݿ����� Connection
        Connection conn = dataSource.getConnection();
        //2. ����SQL
        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);";
        //3. ��ȡpstmt����
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4. ���ò���
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        //5. ִ��SQL
        int count = pstmt.executeUpdate(); // Ӱ�������
        //6. ������
        System.out.println(count > 0);
        //7. �ͷ���Դ
        pstmt.close();
        conn.close();
    }
    /**
     * �޸�
     * 1. SQL��
     update tb_brand
     set brand_name = ?,
     company_name= ?,
     ordered = ?,
     description = ?,
     status = ?
     where id = ?
     * 2. ��������Ҫ����������
     * 3. �����boolean
     */
    @Test
    public void testUpdate() throws Exception {
        // ����ҳ���ύ�Ĳ���
        String brandName = "��ƮƮ";
        String companyName = "��ƮƮ";
        int ordered = 1000;
        String description = "�Ƶ�����Ȧ";
        int status = 1;
        int id = 4;
        //1. ��ȡConnection
        //3. ���������ļ�
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //4. ��ȡ���ӳض���
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5. ��ȡ���ݿ����� Connection
        Connection conn = dataSource.getConnection();
        //2. ����SQL
        String sql = " update tb_brand\n" +
                " set brand_name = ?,\n" +
                " company_name= ?,\n" +
                " ordered = ?,\n" +
                " description = ?,\n" +
                " status = ?\n" +
                " where id = ?";
        //3. ��ȡpstmt����
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4. ���ò���
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);
        //5. ִ��SQL
        int count = pstmt.executeUpdate(); // Ӱ�������
        //6. ������
        System.out.println(count > 0);
        //7. �ͷ���Դ
        pstmt.close();
        conn.close();
    }/**
     * ɾ��
     * 1. SQL��
     delete from tb_brand where id = ?
     * 2. ��������Ҫ��id
     * 3. �����boolean
     */
    @Test
    public void testDeleteById() throws Exception {
        // ����ҳ���ύ�Ĳ���
        int id = 4;
        //1. ��ȡConnection
        //3. ���������ļ�
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //4. ��ȡ���ӳض���
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5. ��ȡ���ݿ����� Connection
        Connection conn = dataSource.getConnection();
        //2. ����SQL
        String sql = " delete from tb_brand where id = ?";
        //3. ��ȡpstmt����
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4. ���ò���
        pstmt.setInt(1,id);
        //5. ִ��SQL
        int count = pstmt.executeUpdate(); // Ӱ�������
        //6. ������
        System.out.println(count > 0);
        //7. �ͷ���Դ
        pstmt.close();
        conn.close();
    }
}
