package com.zhiyou100.javaweb.jdbc.learn;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * @author yanglei
 * abbr. Java数据库连接（Java DataBase Connectivity）
 * @Description: jdbc 工具类 获取连接，关闭链接
 */
public class JavaDataBaseConnectivityUtil {
    public JavaDataBaseConnectivityUtil() {
    }

    public JavaDataBaseConnectivityUtil(String databaseName) {
        JavaDataBaseConnectivityUtil.databaseName = databaseName;
    }

    /**
     * 准备参数
     */

    private static String databaseName = "homework";
    private static final String USER_NAME = "root";
    private static final String PASS_WORD = "yanglei1123";
    private static final String URL = "jdbc:mysql://localhost:3306/" + databaseName;
    private static final String CLASS_NAME = "com.mysql.jdbc.Driver";

    // 注册驱动
    static {
        try {
            Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            // 转换异常
            throw new RuntimeException("驱动注册失败");
        }
    }

    /**
     * @name: getConnection
     * @param: null
     * @date: 2020/5/14 7:06 下午
     * @return: Connection
     * @description: TODO 创建一个方法获取连接
     */
    public static Connection    getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
        } catch (SQLException throwable) {
            throw new RuntimeException("连接失败!");
        }
        return connection;
    }

    /**
     * @name: close
     * @param: ResultSet resultSet, Statement statement, Connection connection
     * @date: 2020/5/14 7:12 下午
     * @return: void
     * @description: TODO 关闭连接
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwable) {
                throw new RuntimeException("resultSet 关闭失败");
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwable) {
                throw new RuntimeException("statement 关闭失败！");
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwable) {
                throw new RuntimeException("connection 关闭失败！");
            }
        }
    }

    /**
     * @name: dateToStringDate
     * @param: Date date
     * @date: 2020/5/14 7:50 下午
     * @return: String
     * @description: TODO 把参数date转为 yyyy-MM-dd 类型的字符串
     */
    public static String dateToStringDate(Date date){
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

}
