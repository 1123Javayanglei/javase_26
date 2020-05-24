package com.zhiyou100.javaweb.myservlet.day002;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @packageName: javase_26
 * @className: ${NAME}
 * @Description: TODO 老师登陆 servlet
 * @author: yang
 * @date: 2020/5/24
 */
@WebServlet(name = "Day002TeacherLoginServlet",urlPatterns = "/day002/teacher")
public class Day002TeacherLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置请求参数的编码集
        request.setCharacterEncoding("UTF-8");

        // 2.获取请求参数
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        // 3.创建dao对象
        TeacherDao teacherDao = new TeacherDao();

        // 4.调用dao对象的方法，访问数据库
        Teacher teacher = teacherDao.login(name, pwd);

        // 5.判断是否登陆陈工
        if (teacher==null){
            // 登陆失败跳转到登陆失败页面
            request.getRequestDispatcher("/day003/error.html").forward(request,response);
            return;
        }

        // 6.把老师对象装入request域中，方便getAllservlet获取
        request.setAttribute("teacher",teacher);
        request.setAttribute("hello",123);
        request.setAttribute("aa","va");

        // 7.登陆成功，请求转发到StudentGetAllServlet
        request.getRequestDispatcher("/day004/").forward(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
