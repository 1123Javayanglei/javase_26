package com.zhiyou100.javaweb.myservlet.day003;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @packageName: javase_26
 * @className: ${NAME}
 * @Description: TODO 创建的Servlet
 * @author: yang
 * @date: 2020/5/21
 */
@javax.servlet.annotation.WebServlet(name = "Day003Servlet01",urlPatterns = "/day03/s1")
public class Day003Servlet01 extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        // 设定编码集
        request.setCharacterEncoding("UTF-8");


        // 接收请求参数
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");

        // 封装成对象
        Demo01User demo01User = new Demo01User(userName, userPwd);

        // 访问数据库
        Connection connection = Demo01Util.getConnection();
        // 获取连接
        String sql="select * from tab_user where userName=? and userPassword=?;";
        // select * from tab_user where userName='h' and userPassword='242';
        // 准备sql
        Demo01User demo01User1 = null;
        ResultSet resultSet=null;
        PreparedStatement pre=null;
        //
        try {
             pre = connection.prepareStatement(sql);
            pre.setString(1,demo01User.getUserName());
            pre.setString(2,demo01User.getUserPwd());
            resultSet = pre.executeQuery();
            if (resultSet.next()){
                int userId = resultSet.getInt("userId");
                String userName1 = resultSet.getString("userName");
                String userPassword = resultSet.getString("userPassword");
                String userGender = resultSet.getString("userGender");
                int userScore = resultSet.getInt("userScore");
                //
                demo01User1=new Demo01User(userId,userName1,userPassword,userGender,userScore);
                //
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        //
        Demo01Util.close(resultSet,pre,connection);


        //
        String message=null;
        if (demo01User1!=null){
            message="登陆成功";
        }else {
            message="登陆失败";
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String finalMessage="<h1 style=\"text-align: center;color: red\">"+message+"</h1>";
        writer.write(finalMessage);
        writer.close();
    }

}
