package com.zhiyou100.javaweb.myservlet.day001;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @packageName: javase_26
 * @className: MethodToCreateServlet
 * @Description: TODO 创建servlet的方法
 * @author: yang
 * @date: 2020/5/23
 */
public class MethodToCreateServlet {
}

/**
 * 实现javax.servlet.Servlet接口，并实现5个方法
 */
class Demo01Servlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

/**
 * 继承抽象类 javax.servlet.Generate 实现service方法
 */
class Demo02Servlet extends GenericServlet{

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }
}

/**
 * 继承类 javax.servlet.http.HttpServlet 重写 doGet/doPost方法
 */
class Demo03Servlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}



