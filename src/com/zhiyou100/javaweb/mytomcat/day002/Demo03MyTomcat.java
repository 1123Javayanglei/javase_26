package com.zhiyou100.javaweb.mytomcat.day002;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @packageName: javase_26
 * @className: Demo03MyTomcat
 * @Description: TODO 模拟 tomcat，服务器
 * @author: yang
 * @date: 2020/5/20
 */
public class Demo03MyTomcat {
    public static void main(String[] args) throws IOException {
        // 1 创建servletSocket
        ServerSocket serverSocket = new ServerSocket(1043);
        // 2 等待请求socket
        Socket accept = serverSocket.accept();

        // 3 获取输入流，接受客户端的请求的数据
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[2 * 1024];
        int read = inputStream.read(bytes);

        // 打印
        System.out.println(new String(bytes,0,read));
        // 关闭
        inputStream.close();

    }
}
