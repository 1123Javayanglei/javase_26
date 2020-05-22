package com.zhiyou100.javaweb.myservlet.homework.day003;

import com.zhiyou100.javaweb.jdbc.learn.JavaDataBaseConnectivityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @packageName: javase_26
 * @className: ${NAME}
 * @Description: TODO Servlet2 处理是true的结果
 * @author: yang
 * @date: 2020/5/22
 */
@WebServlet(name = "Servlet2", urlPatterns = "/day003/homework/s2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        // 设定编码
        response.setContentType("text/html;charset=UTF-8");
        // 设定类型
        PrintWriter writer = response.getWriter();
        ArrayList<Day003ForStudent> all = getAll();
        String message = "";
        for (Day003ForStudent day003ForStudent : all) {
            String line = "学号:" + day003ForStudent.getStudentId() + " 姓名:" + day003ForStudent.getStudentName() + " 性别:" + day003ForStudent.getStudentGender() + " 成绩:" + day003ForStudent.getStudentScore();
            String finalLine = "<h2>" + line + "</h2><br>";
            message += finalLine;
        }
        writer.write(message);
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * @Description: TODO 获取所有的学生信息
     * @param: []
     * @return: java.util.ArrayList<com.zhiyou100.javaweb.myservlet.homework.day003.Day003ForStudent>
     * @date: 2020/5/22 10:23 上午
     * @auther: yang
     */

    public ArrayList<Day003ForStudent> getAll() {
        try {
            ArrayList<Day003ForStudent> day003ForStudents = new ArrayList<Day003ForStudent>();
            // 创建容器
            Connection connection = JavaDataBaseConnectivityUtil.getConnection();
            String sql = "select * from student";
            // select * from student;
            PreparedStatement Statement = connection.prepareStatement(sql);
            // 获取预编译对象
            ResultSet resultSet = Statement.executeQuery();
            // 获取结果集
            while (resultSet.next()) {
                // 处理结果集
                int studentId = resultSet.getInt("studentId");
                String studentName = resultSet.getString("studentName");
                String studentGender = resultSet.getString("studentGender");
                double studentScore = resultSet.getDouble("studentScore");
                Day003ForStudent day003ForStudent = new Day003ForStudent(studentId, studentName, studentGender, studentScore);
                day003ForStudents.add(day003ForStudent);
                // 添加到集合
            }
            JavaDataBaseConnectivityUtil.close(resultSet, Statement, connection);
            // 关闭连接
            return day003ForStudents;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
