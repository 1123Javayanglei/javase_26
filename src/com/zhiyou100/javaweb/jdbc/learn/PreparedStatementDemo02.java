package com.zhiyou100.javaweb.jdbc.learn;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;

import java.sql.*;
import java.util.ArrayList;

/**
 * @packageName: javase_26
 * @className: PreparedStatementDemo02
 * @Description: TODO
 * @author: yanglei
 * @date: 2020/5/17
 */
public class PreparedStatementDemo02 {
    public static void main(String[] args) throws SQLException {
        String name="韩梅梅";
        String password="123";
        // 密码错误
        System.out.println("第1次 "+ login(name,password));
        // false
        System.out.println("第2次" +whetherTheLoginIsSuccessful(name,password));
        // false
        name="韩梅梅' or 'a'='a";
        // select * from user where name='韩梅梅' or 'a'='a' and passWord='123'
        System.out.println("第3次" +whetherTheLoginIsSuccessful(name,password));
        // true

        addAll1(createAll());

    }
    /**
     * @name: login
     * @param: String name,String password
     * @date: 2020/5/17 4:14 下午
     * @return: boolean
     * @description: TODO 判断是否登陆成功
     */
    public static boolean login(String name, String password) throws SQLException {
        Connection connection = JavaDataBaseConnectivityUtil.getConnection();
        // 获取连接
        String sql = "select * from user where name=? and passWord=?";
        // 准备sql
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        boolean next = resultSet.next();
        // 获取是否登陆成功
        JavaDataBaseConnectivityUtil.close(resultSet, statement, connection);
        // 关闭
        return next;
    }
    public static boolean whetherTheLoginIsSuccessful(String name,String password) throws SQLException {
        Connection connection = JavaDataBaseConnectivityUtil.getConnection();
        // 获取连接
        String sql="select * from user where name='"+name+"' and passWord='"+password+"'";
        // 准备sql语句
        System.out.println(sql);
        Statement statement = connection.createStatement();
        // 获取 statement
        ResultSet resultSet = statement.executeQuery(sql);
        // 获取结果集
        return resultSet.next();
    }

    /**
     * @name: createAll
     * @param: null
     * @date: 2020/5/17 5:07 下午
     * @return: ArrayList<MyUsers>
     * @description: TODO 创建一个集合
     */
    public static ArrayList<MyUsers> createAll(){
        ArrayList<MyUsers> myUsers= new ArrayList<MyUsers> ();
        for (int i = 0; i < 100000; i++) {
            MyUsers abc = new MyUsers("杨" + HomeWorkOfMath.randomOfMinToMax(0, 100), "abc");
            myUsers.add(abc);
        }
        return myUsers;
    }

    /**
     * @name: addAll
     * @param: ArrayList<MyUsers>
     * @date: 2020/5/17 4:39 下午
     * @return: void
     * @description: TODO 把一个集合的user添加到数据库
     */
    public static void addAll(ArrayList<MyUsers> list)throws SQLException {
        Connection connection = JavaDataBaseConnectivityUtil.getConnection();
        // 获取连接
        String sql="insert into user (name, passWord)\n" +
                "values (?,?)";
        // 准备sql语句
        PreparedStatement statement = connection.prepareStatement(sql);
        // 发送sql
        for (MyUsers myUsers : list) {
            statement.setString(1,myUsers.getName());
            statement.setString(2,myUsers.getPassword());
            // 填充模版
            statement.executeUpdate();
            // 执行execute方法
        }
        JavaDataBaseConnectivityUtil.close(null,statement,connection);
        // 关闭连接

    }
    public static void addAll1(ArrayList<MyUsers> list) throws SQLException {
        Connection connection = JavaDataBaseConnectivityUtil.getConnection();
        // 获取连接
        Statement statement = connection.createStatement();
        // 获取statement对象
        for (MyUsers myUsers : list) {
            String sql="insert into user (name, passWord)\n" +
                    "values ('"+myUsers.getName()+"','"+myUsers.getPassword()+"')";
            // 准备sql语句
            statement.executeUpdate(sql);
            // 执行sql语句
        }
        JavaDataBaseConnectivityUtil.close(null,statement,connection);
        // 关闭
    }

}

