package com.zhiyou100.basicclass.day29.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @packageName: javase_26
 * @className: Demo03TcpClient
 * @Description: TODO 客户端
 * @author: YangLei
 * @date: 2020/4/9 11:04 上午
 */
public class Demo03TcpClient {
    private static final int PORT = 10086;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(IP, PORT);
            // 创建socket 指定服务器端的ip和端口169345

            int localPort = socket.getLocalPort();
            System.out.println("端口 " + localPort);

            String address = socket.getLocalAddress().getHostAddress();
            System.out.println("地址 " + address);

            int port = socket.getPort();
            System.out.println("端口 " + port);
            String hostAddress = socket.getInetAddress().getHostAddress();
            System.out.println("地址 " + hostAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
