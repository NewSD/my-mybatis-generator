package com.my.mybatis.generator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Connection conn;
        Statement stmt;
        ResultSet rs;
        String url = "jdbc:sqlserver://192.168.44.150:1433;DatabaseName=test;";
        String sql = "select * from Table_1";
        try {
            // 连接数据库
            conn = DriverManager.getConnection(url, "sa", "gsm");
            // 建立Statement对象
            stmt = conn.createStatement();


          //  Connection conn = DriverManager.getConnection(url, config.getUsername(), config.getPassword());
            DatabaseMetaData md = conn.getMetaData();
             rs = md.getTables(null,null, null, null);
            List<String> tables = new ArrayList<>();
            while (rs.next()) {
                tables.add(rs.getString(3));
            }

            /**
             * Statement createStatement() 创建一个 Statement 对象来将 SQL 语句发送到数据库。
             */
            // 执行数据库查询语句
            rs = stmt.executeQuery(sql);
            /**
             * ResultSet executeQuery(String sql) throws SQLException 执行给定的 SQL
             * 语句，该语句返回单个 ResultSet 对象
             */
            while (rs.next()) {
                int id = rs.getInt("id");
//                String name = rs.getString("Sname");
//                int age = rs.getInt("Sage");
                System.out.println("Sno:" + id + "\tSame:" );
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}