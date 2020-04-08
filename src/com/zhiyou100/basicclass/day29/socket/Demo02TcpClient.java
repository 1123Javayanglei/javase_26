package com.zhiyou100.basicclass.day29.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static com.zhiyou100.basicclass.day29.socket.Demo01TcpServer.IP;
import static com.zhiyou100.basicclass.day29.socket.Demo01TcpServer.PORT;

/**
 * @packageName: javase_26
 * @className: Demo02TcpClient
 * @Description: TODO TCP 客户端
 * @author: YangLei
 * @date: 2020/4/8 8:09 下午
 */
public class Demo02TcpClient {


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(IP, PORT);
        // 创建socket 指定服务器的ip和端口

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务器你好，我来访问你了".getBytes());
        // 获取socket的输出流，给服务器发送消息

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int n = inputStream.read(bytes, 0, 1014);
        System.out.println(new String(bytes, 0, n));
        // 获取socket的输入流 接收服务器的反馈消息

        socket.close();
        // 关闭socket
    }
}
