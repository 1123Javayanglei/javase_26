package com.zhiyou100.basicclass.day29.wechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @packageName: javase_26
 * @className: WeChatDemo01TcpServer
 * @Description: TODO 服务器端
 * @author: YangLei
 * @date: 2020/4/9 2:55 下午
 */
public class WeChatDemo01TcpServer {
    private static final int PORT = 10086;
    private static final String IP = "127.0.0.1";
    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(PORT);
            // 开启服务，指定端口

            Socket socket=serverSocket.accept();
            // 获取请求，等待连接

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream outputStream=socket.getOutputStream();
            // 获取socket的输入和输出流

            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
            // 获取键盘输入

            String ipAndPort="IP::"+socket.getInetAddress().getHostAddress()+" PORT:"+socket.getPort();
            // 获取客户端的ip和端口

            while (true){
                String line=bufferedReader.readLine();
                // 接收客户端的一行信息

                System.out.println("收到客户端："+ipAndPort+" 的信息::: "+line);

                if (line.endsWith("END")){
                    // 如果信息以END结尾，接受聊天
                    break;
                }

                line=bufferedReader1.readLine();
                // 从键盘获取一行信息

                outputStream.write((line+"\r\n").getBytes());
                // 写入信息
            }

            socket.close();
            // 关闭服务

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
