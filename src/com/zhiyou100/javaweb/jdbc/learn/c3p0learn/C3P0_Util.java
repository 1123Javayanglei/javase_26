package com.zhiyou100.javaweb.jdbc.learn.c3p0learn;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @packageName: javase_26
 * @className: MyUtil01
 * @Description: TODO c3p0 工具类
 * @author: yanglei
 * @date: 2020/5/17
 */
public class C3P0_Util {
    private static DataSource dataSource;
    // 1 定义一个静态的成员变量记录池对象
    static {
        dataSource=new ComboPooledDataSource();
        // 不写配置文件路径，必须在src下
//        dataSource=new ComboPooledDataSource("src/com/zhiyou100/javaweb/jdbc/learn/c3p0learn/c3p0-config.xml");
    }

    /**
     * @name: getConnection
     * @param: null
     * @date: 2020/5/17 5:57 下午
     * @return: Connection
     * @description: TODO 2 获取连接
     */
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * @name: close
     * @param: Connection connection, Statement statement, ResultSet resultSet
     * @date: 2020/5/17 6:00 下午
     * @return: void
     * @description: TODO 3 关闭连接，池对象获取的连接的close方法被重写了，不是关闭而是把连接还给池对象
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        String sql="select * from class";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String string = resultSet.getString(1);
            String string1 = resultSet.getString(2);
            String string2 = resultSet.getString(3);
            System.out.println(string+","+string1+","+string2);
        }
        close(connection,statement,resultSet);
    }

}
