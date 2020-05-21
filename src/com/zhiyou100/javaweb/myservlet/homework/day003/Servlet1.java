package com.zhiyou100.javaweb.myservlet.homework.day003;

import com.zhiyou100.javaweb.jdbc.learn.JavaDataBaseConnectivityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * @packageName: javase_26
 * @className: ${NAME}
 * @Description: TODO  判断是否登陆成功
 * @author: yang
 * @date: 2020/5/21
 */
@WebServlet(name = "Servlet1",urlPatterns = "/day003/homework/s1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    /**
     * @Description: TODO 判断是否登陆成功
     * @param: []
     * @return: boolean
     * @date: 2020/5/21 8:52 下午
     * @auther: yang
     */

    public boolean isLogin(){
        Connection connection = JavaDataBaseConnectivityUtil.getConnection();
        String sql="";
        return false;
    }
    

}
