package com.zhiyou100.basicclass.day29.wechat;

import java.io.IOException;
import java.net.Socket;

/**
 * @packageName: javase_26
 * @className: WeChatDemo02TcpClient
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/4/9 3:35 下午
 */
public class WeChatDemo02TcpClient {
    private static final int PORT = 10086;
    private static final String IP = "127.0.0.1";
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(IP, PORT);
            SocketServerThread socketServerThread = new SocketServerThread(socket);
            SocketThread socketThread = new SocketThread(socket);
            // 为获取的socket创建输入流对应的线程对象和输出流对应的线程对象
            socketServerThread.start();
            socketThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建socket，指定服务器端的ip和端口
    }
}
