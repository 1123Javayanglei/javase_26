package com.zhiyou100.javaweb.myservlet.day002;

import com.zhiyou100.javaweb.jdbc.learn.JavaDataBaseConnectivityUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @packageName: javase_26
 * @className: TeacherDao
 * @Description: TODO 老师JDBC类
 * @author: yang
 * @date: 2020/5/24
 */
public class TeacherDao {
    /**
     * @Description: TODO 获取登陆信息
     * @name: `login`
     * @param: [name, pwd]
     * @return: com.zhiyou100.javaweb.myservlet.day002.Teacher
     * @date: 2020/5/24 12:18 下午
     * @auther: yang
     */

    public Teacher login(String name, String pwd) {
        boolean login = isLogin(name, pwd);
        if (login) {
            try {
                Teacher teacher = new Teacher();
                Connection connection = JavaDataBaseConnectivityUtil.getConnection();
                String sql = "select * from teacher where teacherName=? and teacherPwd=?;";
                // select * from teacher where teacherName='王五' and teacherPwd='1024';
                PreparedStatement statement = connection.prepareStatement(sql);
                // 获取预编译对象
                statement.setString(1, name);
                statement.setString(2, pwd);
                // 设定参数
                ResultSet resultSet = statement.executeQuery();
                // 获取结果集
                while (resultSet.next()) {
                    int teacherId = resultSet.getInt(1);
                    String teacherName = resultSet.getString(2);
                    String teacherPwd = resultSet.getString(3);
                    teacher = new Teacher(teacherId, teacherName, teacherPwd);
                }
                JavaDataBaseConnectivityUtil.close(resultSet, statement, connection);
                // 关闭连接
                return teacher;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    /**
     * @Description: TODO 判断是否登陆成功
     * @name: isLogin
     * @param: [intoName, intoPwd]
     * @return: boolean
     * @date: 2020/5/24 12:19 下午
     * @auther: yang
     */

    private boolean isLogin(String intoName, String intoPwd) {
        try {
            Connection connection = JavaDataBaseConnectivityUtil.getConnection();
            String sql = "select * from teacher where teacherName=? and teacherPwd=?;";
            // select * from teacher where teacherName='王五' and teacherPwd='1024';
            PreparedStatement statement = connection.prepareStatement(sql);
            // 获取预编译对象
            statement.setString(1, intoName);
            statement.setString(2, intoPwd);
            // 设定参数
            ResultSet resultSet = statement.executeQuery();
            // 获取结果集
            boolean next = resultSet.next();
            // 获取状态
            JavaDataBaseConnectivityUtil.close(resultSet, statement, connection);
            // 关闭连接
            // 判断是否登陆成功
            return next;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
