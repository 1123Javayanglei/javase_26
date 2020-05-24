package com.zhiyou100.javaweb.myservlet.day002;

import com.zhiyou100.javaweb.jdbc.learn.JavaDataBaseConnectivityUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @packageName: javase_26
 * @className: StudentDao
 * @Description: TODO 学生实体类的JDBC工具类
 * @author: yang
 * @date: 2020/5/24
 */
public class StudentDao {
    /**
     * @Description: TODO 获取所有的学生
     * @name: getAll
     * @param: []
     * @return: java.util.ArrayList<com.zhiyou100.javaweb.myservlet.day002.Student>
     * @date: 2020/5/24 12:54 下午
     * @auther: yang
     */

    public ArrayList<Student> getAll() {
        try {
            ArrayList<Student> student = new ArrayList<Student>();
            // 创建容器
            Connection connection = JavaDataBaseConnectivityUtil.getConnection();
            String sql = "select * from student";
            // select * from student;
            PreparedStatement statement = connection.prepareStatement(sql);
            // 获取预编译对象
            ResultSet resultSet = statement.executeQuery();
            // 获取结果集
            while (resultSet.next()) {
                // 处理结果集
                int studentId = resultSet.getInt("studentId");
                String studentName = resultSet.getString("studentName");
                String studentGender = resultSet.getString("studentGender");
                double studentScore = resultSet.getDouble("studentScore");
                com.zhiyou100.javaweb.myservlet.day002.Student studentIn = new Student(studentId, studentName, studentGender, studentScore);
                student.add(studentIn);
                // 添加到集合
            }
            JavaDataBaseConnectivityUtil.close(resultSet, statement, connection);
            // 关闭连接
            return student;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
