package com.zhiyou100.basicclass.day29.wechat;

import java.io.*;
import java.net.Socket;

/**
 * @packageName: javase_26
 * @className: WeChatDemo1TcpClient
 * @Description: TODO 客户端
 * @author: YangLei
 * @date: 2020/4/9 2:40 下午
 */
public class WeChatDemo1TcpClient {
    private static final int PORT = 10086;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(IP, PORT);
            // 创建socket，指定服务器端的ip和端口

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // 获取系统输入流

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream out = socket.getOutputStream();
            // 获取socket的输出流和输入流

            String ipAndPort = "IP::"+socket.getInetAddress().getHostAddress()+" PORT:"+socket.getPort();
            // 获取服务器的ip和端口

            while (true) {
                String line = bufferedReader.readLine();
                // 从控制台读取一行信息
                out.write((line + "\r\n").getBytes());
                // 通过输出流发送给服务器
                if (line.endsWith("END")) {
                    // 如果末尾包含 END，结束
                    break;
                }
                line = in.readLine();
                // 获取服务器端读取的信息
                System.out.println("收到服务器:" + ipAndPort + " 的消息:::" + line);
                // 打印服务器端的信息

            }
            // 一边从控制台读取信息，把读取的信息发送到服务器端

            socket.close();
            // 关闭socket

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
