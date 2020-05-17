package com.zhiyou100.javaweb.jdbc.learn;

import java.sql.*;

/**
 * @author yanglei
 */
public class Demo1 {
    private static final String USER_NAME = "root";
    private static final String PASS_WORD = "yanglei1123";
    private static final String URL = "jdbc:mysql://localhost:3306/homework";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 注册驱动：通过Class
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
            // 获取连接：通过DriverManager
            Statement statement = connection.createStatement();
            // 获取statement对象：sql语句发送对象
            String mysqlString = "select * from student";
            // 准备sql语句
            ResultSet resultSet = statement.executeQuery(mysqlString);
            // 铜通过statement把sql发送给数据库：如果是增删改 执行 executeUpdate , 查 executeQuery
            // 获取处理结果集

            while (resultSet.next()) {
                // 处理查询结果
                int id = resultSet.getInt("studentId");
                // columnLabel 结果集合的列名
                int studentId = resultSet.getInt("studentId");
                String studentName = resultSet.getString("studentName");
                String studentGender = resultSet.getString("studentGender");
                float studentScore = resultSet.getFloat("studentScore");
                boolean studentPosition = resultSet.getBoolean("studentPosition");
                int myClassId = resultSet.getInt("myClassId");

                int myId=resultSet.getInt(1);

                Student1 student1 = new Student1(studentId, studentName, studentGender, studentScore, studentPosition, myClassId);
                System.out.println(student1);

                System.out.println(myId);
            }

            resultSet.close();
            statement.close();
            connection.close();
            // 关闭连接，释放资源

        } catch (ClassNotFoundException e) {
            System.out.println("连接数据库出错");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}

class Student1 {
    private int id;
    private String name;
    private String gender;
    private float score;
    private boolean position;
    private int classId;

    public Student1(int id, String name, String gender, float score, boolean position, int classId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.score = score;
        this.position = position;
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", position=" + position +
                ", classId=" + classId +
                '}';
    }
}
