package com.zhiyou100.basicclass.day29.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @packageName: javase_26
 * @className: Demo01TcpServer
 * @Description: TODO TCP 服务器端
 * @author: YangLei
 * @date: 2020/4/8 8:07 下午
 */
public class Demo01TcpServer {
    private static final int PORT = 10086;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);
        // 创建ServerSocket服务，并开启指定端口

        Socket socket = serverSocket.accept();
        // 等待客户端的连接 Socket套接字，传输通道
        // accept是阻塞方法，只有客服端访问了，才会执行下一步，否则不会继续执行

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int n = inputStream.read(bytes, 0, 1024);
        System.out.println(new String(bytes, 0, n));
        // 通过socket的输入流获取客户端的消息

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("欢迎下次再来".getBytes());
        // 通过socket的输出流给客户端发送消息

        socket.close();
        // 关闭流
    }
}
