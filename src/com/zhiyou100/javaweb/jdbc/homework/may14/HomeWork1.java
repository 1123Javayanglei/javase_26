package com.zhiyou100.javaweb.jdbc.homework.may14;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;
import com.zhiyou100.javaweb.jdbc.learn.JavaDataBaseConnectivityUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @packageName: javase_26
 * @className: HomeWork1
 * @Description: TODO
 * @author: yanglei
 * @date: 2020/5/14
 */
public class HomeWork1 {
    // 3 写一个方法：  再写一个方法 根据性别获取

    /**
     * @name: getAll
     * @param: null
     * @date: 2020/5/14 7:41 下午
     * @return: ArrayList<Teacher>
     * @description: TODO 获取所有
     */
    private static ArrayList<Teacher> getAll() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        Connection connection = JavaDataBaseConnectivityUtil.getConnection();
        // 获取连接
        try {
            Statement statement = connection.createStatement();
            // 获取 statement
            String sql = "select * from teacher";
            // 准备 写出sql语句
            ResultSet resultSet = statement.executeQuery(sql);
            // 获取resultSet
            while (resultSet.next()) {
                // 遍历结果集
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                float salary = resultSet.getFloat("salary");
                boolean isItPartyMember = resultSet.getBoolean("isItAPartyMember");
                String birthday = JavaDataBaseConnectivityUtil.dateToStringDate(resultSet.getDate("birthday"));
                teachers.add(new Teacher(id, name, gender, salary, isItPartyMember, birthday));
                // 添加到ArrayList中
            }
            JavaDataBaseConnectivityUtil.close(resultSet, statement, connection);
            // 关闭sql
        } catch (SQLException throwable) {
            throw new RuntimeException("statement 获取失败！");
        }

        return teachers;
    }

    /**
     * @name: getAllGender
     * @param: String gender
     * @date: 2020/5/14 7:41 下午
     * @return: ArrayList<Teacher>
     * @description: TODO 根据性别获取所有
     */
    private static ArrayList<Teacher> getAllGender(String myGender) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        Connection connection = JavaDataBaseConnectivityUtil.getConnection();
        // 获取连接
        try {
            Statement statement = connection.createStatement();
            // 获取 statement
            String sql = "select * from teacher where gender='" + myGender + "'";
            // select * from teacher where gender='男';
            // 准备 写出sql语句
            ResultSet resultSet = statement.executeQuery(sql);
            // 获取resultSet
            while (resultSet.next()) {
                // 遍历结果集
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                float salary = resultSet.getFloat("salary");
                boolean isItPartyMember = resultSet.getBoolean("isItAPartyMember");
                String birthday = JavaDataBaseConnectivityUtil.dateToStringDate(resultSet.getDate("birthday"));
                teachers.add(new Teacher(id, name, gender, salary, isItPartyMember, birthday));
                // 添加到ArrayList中
            }
            JavaDataBaseConnectivityUtil.close(resultSet, statement, connection);
            // 关闭sql
        } catch (SQLException throwable) {
            throw new RuntimeException("根据性别获取中 statement 获取失败！");
        }
        return teachers;
    }

    /**
     * @name: updateSome
     * @param: String gender,float money
     * @date: 2020/5/14 8:22 下午
     * @return: void
     * @description: TODO  给指定性别的老师工资加money
     */
    private static void updateSome(String gender, double money) {
        Connection connection = JavaDataBaseConnectivityUtil.getConnection();
        // 获取连接
        try {
            Statement statement = connection.createStatement();
            // 创建 statement
            // update teacher set salary=salary+10.5 where gender='男';
            String sql = "update " +
                    "teacher set salary=salary+" + money + " where gender='" + gender + "'";
            // 准备sql语句
            int i = statement.executeUpdate(sql);
            System.out.println("更改成功，本次修改了 " + i + " 行");
            JavaDataBaseConnectivityUtil.close(null, statement, connection);
            // 释放sql
        } catch (SQLException throwaways) {
            throw new RuntimeException("创建statement失败");
        }
    }

    /**
     * @name: getMaxId
     * @param: null
     * @date: 2020/5/14 9:16 下午
     * @return: int
     * @description: TODO 获取当前表中最大的id
     */
    private static int getMaxId() {
        ArrayList<Teacher> all = getAll();
        int max = 0;
        for (Teacher t :
                all) {
            if (t.getId() > max) {
                max = t.getId();
            }
        }
        return max;
    }

    /**
     * @name: addOneTeacher
     * @param: Teacher teacher
     * @date: 2020/5/14 9:17 下午
     * @return: void
     * @description: TODO 添加一个teacher，id自动增加
     */
    private static void addOneTeacher(Teacher teacher) {
        Connection connection = JavaDataBaseConnectivityUtil.getConnection();
        // 获取连接
        try {
            Statement statement = connection.createStatement();
            // 创建 statement
            int id = getMaxId() + 1;
            String name = teacher.getName();
            String gender = teacher.getGender();
            double salary = teacher.getSalary();
            boolean isNotPoliticalPartyMember = teacher.isOrIsNotPoliticalPartyMember();
            String birthday = teacher.getBirthday();
            String sql = "insert into teacher (id, name, gender, salary, isItAPartyMember, birthday) values (" + id + ",'" + name + "','" + gender + "'," + salary + "," + isNotPoliticalPartyMember + ",'" + birthday + "')";
            // insert into teacher (id, name, gender, salary, isItAPartyMember, birthday) values (3,'张雷','男',65.8,true,'2001-11-23')
            // 准备sql语句
            statement.executeUpdate(sql);
            JavaDataBaseConnectivityUtil.close(null, statement, connection);
            // 释放sql
        } catch (SQLException throwaways) {
            throw new RuntimeException("创建statement失败");
        }
    }


    /**
     * @name: delSome
     * @param: double money
     * @date: 2020/5/14 9:21 下午
     * @return: void
     * @description: TODO 删除工资高于money的记录
     */
    private static void delSome(double money) {
        Connection connection = JavaDataBaseConnectivityUtil.getConnection();
        // 获取连接
        try {
            Statement statement = connection.createStatement();
            // 创建 statement
            String sql = "delete from teacher where salary>=" + money;
            // 准备sql语句
            int i = statement.executeUpdate(sql);
            System.out.println("删除成功，本次修改了 " + i + " 行");
            JavaDataBaseConnectivityUtil.close(null, statement, connection);
            // 释放sql
        } catch (SQLException throwaways) {
            throw new RuntimeException("创建statement失败");
        }
    }


    /**
     * @name: add
     * @param: null
     * @date: 2020/5/14 9:54 下午
     * @return: void
     * @description: TODO 添加方法，用于测试
     */
    public static void add() {
        for (int i = 0; i < 100; i++) {
            addOneTeacher(new Teacher(
                            "张" + HomeWorkOfMath.randomOfMinToMax(0, 100),
                            HomeWorkOfMath.randomOfMinToMax(0, 1) == 1 ? "男" : "女",
                            (HomeWorkOfMath.randomOfMinToMax(0, 9) * 100 + HomeWorkOfMath.randomOfMinToMax(0, 9) * 10 + HomeWorkOfMath.randomOfMinToMax(0, 9)),
                            HomeWorkOfMath.randomOfMinToMax(0, 1) != 0, "2020-11-1"
                    )
            );
        }
    }
}
