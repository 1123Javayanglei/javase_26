package com.zhiyou100.javaweb.myservlet.homework.day003;

import com.zhiyou100.javaweb.jdbc.learn.JavaDataBaseConnectivityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @packageName: javase_26
 * @className: ${NAME}
 * @Description: TODO  Servlet1
 * @author: yang
 * @date: 2020/5/21
 */
@WebServlet(name = "Servlet1", urlPatterns = "/day003/homework/s1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 设定编码集

        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        // 获取请求参数

        boolean login = isLogin(userName, userPwd);
        // 获取是否登陆成功的状态

        String redirectTuUr1 = login == true ? "/javase_26_war_exploded/day003/homework/s2" : "/javase_26_war_exploded/day003/error.html";
        // 判断是否登陆成功
        response.sendRedirect(redirectTuUr1);
        // 转发


    }


    /**
     * @Description: TODO 判断是否登陆成功
     * @param: [intoName, intoPwd]
     * @return: boolean
     * @date: 2020/5/22 12:04 上午
     * @auther: yang
     */

    private boolean isLogin(String intoName, String intoPwd) {
        try {
            Connection connection = JavaDataBaseConnectivityUtil.getConnection();
            String sql = "select * from teacher where teacherName=? and teacherPwd=?;";
            // select * from teacher where teacherName='王五' and teacherPwd='1024';
            PreparedStatement Statement = connection.prepareStatement(sql);
            // 获取预编译对象
            Statement.setString(1, intoName);
            Statement.setString(2, intoPwd);
            // 设定参数
            ResultSet resultSet = Statement.executeQuery();
            // 获取结果集
            boolean next = resultSet.next();
            // 获取状态
            JavaDataBaseConnectivityUtil.close(resultSet, Statement, connection);
            // 关闭连接
            if (next) {
                // 判断是否登陆成功
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
