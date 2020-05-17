package com.zhiyou100.javaweb.jdbc.learn;


import java.sql.*;
import java.util.ArrayList;

/**
 * @author yanglei
 */
public class Demo02 {
    /*
     * 1 倒入jar包，一个项目导入一次即可
     * 2 注册驱动：一个项目加载一次即可
     *
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw  new RuntimeException("驱动jar没有导入");
        }
    }

    /**
     * 3 准备四个参数
     */
    private static final String USER_NAME = "root";
    private static final String PASS_WORD = "yanglei1123";
    private static final String URL = "jdbc:mysql://localhost:3306/homework";
    public static void main(String[] args) {
        /*
          4 获取链接
         */
        try {
            ArrayList<Student1> student1s = new ArrayList<>();
            // 创建对象放 student1
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
            Statement statement = connection.createStatement();
            String sql="select * from student1";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                //
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*
          5 获取statement 对象
         */
        /*
          6 准备sql语句
         */
        /*
          7 调用statement的execute方法 获取结果集
         */
    }

    private static <ArraryList> Student1 read() {
        return null;
    }

    /**
     * @name: getOne
     * @param: int id
     * @date: 2020/5/14 3:52 下午
     * @return: Student1
     * @description: TODO 根据参数获取一个
     */
    private static Student1 getOne(int id){
        return null;
    }
    public static void addOne(Student1 student1) {
    }

    private static void deleteOne(int id) {
    }

    private static void updateOne() {
    }
}
