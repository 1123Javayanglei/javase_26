package com.zhiyou100.javaweb.myservlet.day002;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * @packageName: javase_26
 * @className: ${NAME}
 * @Description: TODO 获取所有的学生
 * @author: yang
 * @date: 2020/5/24
 */
@WebServlet(name = "Day002StudentGetAllServlet",urlPatterns = "/day002/student")
public class Day002StudentGetAllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取 request域对象中的teacher属性--记录老师
        Teacher teacher = (Teacher) request.getAttribute("teacher");

        if (teacher==null){
            // 如果老师为空，退出方法
            return;
        }

        // 获取所有的request域属性的名字
        Enumeration<String> names = request.getAttributeNames();
        while (names.hasMoreElements()){
            String s = names.nextElement();
            Object value = request.getAttribute(s);
            System.out.println("request域属性：：："+s+" = "+value);
        }

        // 获取所有的学生的信息
        StudentDao studentDao = new StudentDao();
        ArrayList<Student> all = studentDao.getAll();

        // 获取response的输出流
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        // 拼凑页面
        StringBuilder massage= new StringBuilder();
        massage.append("<html><heard><title>所有学生的信息</title>");
        massage.append("</hear><body><table>");
        massage.append("<h1>当前老师:").append(teacher.getTeacherName()).append("</h1>");
        for (Student student : all) {
            massage.append("<tr><td>").append(student.toString()).append("</td><tr>");
        }
        // 写入页面
        writer.write(massage.toString());
        // 关闭
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
