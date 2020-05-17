package com.zhiyou100.javaweb.jdbc.learn;

import com.zhiyou100.javaweb.jdbc.homework.may14.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @packageName: javase_26
 * @className: PreparedStatementDemo01
 * @Description: TODO PreparedStatement使用
 * @author: yanglei
 * @date: 2020/5/15
 */
public class PreparedStatementDemo01 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(7, "杨磊", "男", 123456, false, "2001-11-23");
        updateOneByPreparedStatement(teacher);
    }

    /**
     * @name: getAll
     * @param: null
     * @date: 2020/5/17 2:24 下午
     * @return: ArrayList<Teacher>
     * @description: TODO 获取所有
     */
    private static ArrayList<Teacher> getAll() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        Connection connection = JavaDataBaseConnectivityUtil.getConnection();
        // 获取连接
        String sql = "select * from teacher";
        // 准备sql语句
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 发送sql语句
            ResultSet resultSet = preparedStatement.executeQuery();
            // 获取结果集
            while (resultSet.next()) {
                // 处理查询结果集
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                double salary = resultSet.getDouble(4);
                boolean aBoolean = resultSet.getBoolean(5);
                String birthday = resultSet.getString(6);
                teachers.add(new Teacher(id, name, gender, salary, aBoolean, birthday));
            }
            JavaDataBaseConnectivityUtil.close(resultSet, preparedStatement, connection);
            // 关闭资源
            return teachers;
        } catch (SQLException thenables) {
            throw new RuntimeException("发送sql语句失败");
        }
    }

    /**
     * @name: getId
     * @param: int intoId
     * @date: 2020/5/17 2:36 下午
     * @return: Teacher
     * @description: TODO 根据id获取一个teacher
     */
    private static Teacher getId(int intoId) {
        Teacher teacher = null;
        Connection connection = JavaDataBaseConnectivityUtil.getConnection();
        // 获取连接
        String sql = "select * from teacher where id=?";
        // 准备sql语句
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            // 发送sql语句
            statement.setInt(1, intoId);
            // 设置预备的sql语句
            ResultSet resultSet = statement.executeQuery();
            // 获取查询结果
            if (resultSet != null) {
                // 如果查询结果存在
                while (resultSet.next()) {
                    // 处理结果集
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String gender = resultSet.getString(3);
                    double salary = resultSet.getDouble(4);
                    boolean aBoolean = resultSet.getBoolean(5);
                    String birthday = resultSet.getString(6);
                    teacher = new Teacher(id, name, gender, salary, aBoolean, birthday);
                }
                JavaDataBaseConnectivityUtil.close(resultSet, statement, connection);
                // 关闭连接
                return teacher;
            } else {
                throw new RuntimeException("没有查询结果");
            }
        } catch (SQLException thenables) {
            throw new RuntimeException("发送sql语句失败");
        }
    }

    /***
     * @name: delOne
     * @param: int id
     * @date: 2020/5/17 3:29 下午
     * @return: void
     * @description: TODO 根据id删除1一个
     */
    private static void delOne(int id) {
        try {
            Connection connection = JavaDataBaseConnectivityUtil.getConnection();
            // 获取连接
            String sql = "delete from teacher where id = ?";
            // 准备sql语句
            PreparedStatement statement = connection.prepareStatement(sql);
            // 发送sql语句
            statement.setInt(1, id);
            statement.executeUpdate();
            JavaDataBaseConnectivityUtil.close(null, statement, connection);
            // 关闭
        } catch (Exception e) {
            throw new RuntimeException("失败");
        }

    }

    /**
     * @name: addOne
     * @param: Teacher t
     * @date: 2020/5/17 3:38 下午
     * @return: void
     * @description: TODO 根据teacher添加一个
     */
    private static void addOne(Teacher t) {
        try {
            Connection connection = JavaDataBaseConnectivityUtil.getConnection();
            // 获取连接
            String sql = "insert into teacher " +
                    "(id, name, gender, salary, isItAPartyMember, birthday)" +
                    "values (?,?,?,?,?,?)";
            // 准备sql语句
            PreparedStatement statement = connection.prepareStatement(sql);
            // 发送sql语句
            statement.setInt(1,t.getId());
            statement.setString(2,t.getName());
            statement.setString(3,t.getGender());
            statement.setDouble(4,t.getSalary());
            statement.setBoolean(5,t.isOrIsNotPoliticalPartyMember());
            statement.setString(6,t.getBirthday());
            // 给占位符赋值
            statement.executeUpdate();
            // 执行
            JavaDataBaseConnectivityUtil.close(null,statement,connection);
            // 关闭连接
        } catch (Exception e) {
            throw new RuntimeException("出错");
        }

    }

    /***
     * @name: updateOneByPreparedStatement
     * @param: Teacher teacher
     * @date: 2020/5/17 2:44 下午
     * @return: void
     * @description: TODO 修改一个
     */
    private static void updateOneByPreparedStatement(Teacher teacher) {
        try {
            Connection connection = JavaDataBaseConnectivityUtil.getConnection();
            // 获取连接
           String sql="update teacher\n" +
                   "set name =? ,gender=?  ,salary=?,isItAPartyMember=?,birthday=?\n" +
                   "where id=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            // 发送sql语句
            statement.setString(1,teacher.getName());
            statement.setString(2,teacher.getGender());
            statement.setDouble(3,teacher.getSalary());
            statement.setBoolean(4,teacher.isOrIsNotPoliticalPartyMember());
            statement.setString(5,teacher.getBirthday());
            statement.setInt(6,teacher.getId());
            // 填充模版
            statement.executeUpdate();
            // 执行
            JavaDataBaseConnectivityUtil.close(null,statement,connection);
            // 关闭

        } catch (Exception e) {
            throw new RuntimeException("失败");
        }
    }
}
