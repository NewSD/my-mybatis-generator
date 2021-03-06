package com.my.mybatis.generator.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zouzhigang on 2016/9/18.
 */
public class ConfigHelperTest {

    @Test
    public void testFindConnectorLibPath_Oracle() {
        String path = ConfigHelper.findConnectorLibPath("Oracle");
        Assert.assertTrue(path.contains("ojdbc"));
    }

    @Test
    public void testFindConnectorLibPath_Mysql() {
        String path = ConfigHelper.findConnectorLibPath("MySQL");
        Assert.assertTrue(path.contains("mysql-connector"));
    }

    @Test
    public void testFindConnectorLibPath_PostgreSQL() {
        String path = ConfigHelper.findConnectorLibPath("PostgreSQL");
        Assert.assertTrue(path.contains("postgresql"));
    }

    @Test
    public void testFindConnectorLibPath_SqlServer() {
        String path = ConfigHelper.findConnectorLibPath("SqlServer");
        Assert.assertTrue(path.contains("sqljdbc4"));
    }
}
