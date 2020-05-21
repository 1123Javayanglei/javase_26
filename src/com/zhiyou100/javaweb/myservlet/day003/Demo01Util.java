package com.zhiyou100.javaweb.myservlet.day003;

import java.sql.*;

/**
 * @packageName: javase_26
 * @className: Demo01Util
 * @Description: TODO JDBC 工具类
 * @author: yang
 * @date: 2020/5/21
 */
public class Demo01Util {
    /*
     * 1 导入jar包
     */
    /**
     * 2 准备四大驱动
     */
    private static final String URL = "jdbc:mysql://localhost:3306/Demo001";
    private static final String NAME = "root";
    private static final String PWD = "yanglei1123";
    private static final String CLASS_NAME = "com.mysql.jdbc.Driver";

    /*
     * 3 注册驱动
     */
    static {
        try {
            Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("注册驱动失败！");
        }
    }

    /**
     * @Description: TODO  获取连接
     * @param: []
     * @return: java.sql.Connection
     * @date: 2020/5/21 3:55 下午
     * @auther: yang
     */

    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, NAME, PWD);
        } catch (Exception e) {
            throw new RuntimeException("链接失败！");
        }
        return connection;
    }

    /**
     * @Description: TODO  关闭连接
     * @param: [resultSet, statement, connection]
     * @return: void
     * @date: 2020/5/21 3:58 下午
     * @auther: yang
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

}
