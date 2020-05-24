package com.zhiyou100.javaweb.myservlet.day002;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @packageName: javase_26
 * @className: ${NAME}
 * @Description: TODO request的作用
 * @author: yang
 * @date: 2020/5/23
 */
@javax.servlet.annotation.WebServlet(name = "Day002Servlet1", urlPatterns = "/day002/s1")
public class Day002Servlet1 extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        /*
         * 1. 获取请求头
         * String request.getHeader(headerName) 根据请求头名获取单值
         * Enumeration request.getHeaderNames() 获取所有请求头
         */
        response.setCharacterEncoding("UTF-8");
        // 设置编码集
        response.setContentType("text/html;charset=UTF-8");
        // 设置内容类型
        StringBuilder message = new StringBuilder("<h1>请求头</h1>");
        Enumeration<String> headerNames = request.getHeaderNames();
        // 获取所有请求头
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String header = request.getHeader(name);
            // 根据名字获取请求头
            message.append("请求头: ").append(name).append(" = ").append(header).append(" <br/>");
        }

        /*
          2.获取请求参数
          request.setCharacterEncoding 设置请求体的编码集
          String request.getParameter(name) 根据参数名来获取参数单值
          String[] request.getParameterValues(name) 通过参数名，获取参数多值
          Enumeration request.getParameterNames() 获取所有参数名
          MaP<String,String[]> request.getParameterMap() 获取所有参数请求对应的map
         */
        message.append("<h1>请求参数</h1>");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            message.append(entry.getKey()).append(" = ").append(Arrays.toString(entry.getValue())).append("<br>");
        }
        /*
         * 3.请求转发/请求包含
         *  RequestDispatcher dispatcher = request.getRequestDispatcher("/day002/s2"); 获取请求转发的调渡器对象
         * request.getRequestDispatcher("/day002/s2").forward(request,response); 请求转发
         * request.getRequestDispatcher("/day002/s2").include(request,response); 请求包含
         *
         */

        /*
         * 4. 其他方法
         * getMethod() 获取请求方式
         * getContextPath() 获取项目路径
         * getSession() 获取Session对象
         * getRequestedSessionId() 获取Session对象的id
         * getServletContext() 获取ServletContext对象的数组
         * getCookies() 获取cookie数组
         * getInputStream(0 获取请求的输出流
         *
         * getLocalAddr() 获取服务器的ip
         * getLocalPort() 获取服务器的端口
         * getRemoteAddr() 获取客户端的ip
         * getRemotePort() 获取客户端的端口
         * getQueryString() 获取请求参数
         * getRequestURL() 获取请求的URL
         * getServletPath() 获取请求的资源名字
         *
         */
        PrintWriter writer = response.getWriter();
        writer.write(message.toString());
        writer.close();

    }
}
