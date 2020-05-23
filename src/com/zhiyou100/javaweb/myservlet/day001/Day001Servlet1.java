package com.zhiyou100.javaweb.myservlet.day001;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @packageName: javase_26
 * @className: ${NAME}
 * @Description: TODO 第一个Servlet，实现5个方法
 * @author: yang
 * @date: 2020/5/23
 */
@WebServlet(name = "Day001Servlet1",urlPatterns = "/day001/s1")
public class Day001Servlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @Description: TODO 获取 servlet的配置讯息
     * @name: getServletConfig
     * @param: []
     * @return: javax.servlet.ServletConfig
     * @date: 2020/5/23 7:54 上午
     * @auther: yang
     */


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * @Description: TODO 获取servlet类的基本信息： 作者 时间
     * @param: []
     * @return: java.lang.String
     * @date: 2020/5/22 8:16 下午
     * @auther: yang
     */

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * @Description: TODO 对象销毁前要执行的方法
     * @param: []
     * @return: void
     * @date: 2020/5/22 8:14 下午
     * @auther: yang
     */

    @Override
    public void destroy() {
        System.out.println("destroy 方法");
    }

    /**
     * @Description: TODO 初始化方法，servant对象创建后要立即执行的代码
     * @param: []
     * @return: void
     * @date: 2020/5/22 8:18 下午
     * @auther: yang
     */

    @Override
    public void init() throws ServletException {
        System.out.println("into 方法");
    }

    /**
     * @Description: TODO 接受请求，处理数据，给予响应的代码
     * @param: [req, resp]
     * @return: void
     * @date: 2020/5/22 8:19 下午
     * @auther: yang
     */

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service 方法");
    }
}


