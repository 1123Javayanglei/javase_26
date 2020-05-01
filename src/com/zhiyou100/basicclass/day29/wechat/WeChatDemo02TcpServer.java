package com.zhiyou100.basicclass.day29.wechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @packageName: javase_26
 * @className: WeChatDemo02TcpServer
 * @Description: TODO 改进
 * @author: YangLei
 * @date: 2020/4/9 3:22 下午
 */
public class WeChatDemo02TcpServer {
    private static final int PORT = 10086;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(PORT);
            // 开启服务，指定端口

            Socket socket = serverSocket.accept();
            // 获取请求，等待连接


            SocketServerThread socketServerThread = new SocketServerThread(socket);
            SocketThread socketThread = new SocketThread(socket);
            // 为获取的socket创建输入流对应的线程对象和输出流对应的线程对象
            socketServerThread.start();
            socketThread.start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketServerThread extends Thread {
    /**
     * 服务器端
     */
    Socket socket;

    public SocketServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String ipAndPort = socket.getPort() + " " + socket.getInetAddress().getHostAddress();
        // 获取对方的的ip和port

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                // 接收对方的一行信息
                System.out.println("接收到 " + ipAndPort + " 的信息 ：： " + line);
                if (line.endsWith("END")) {
                    // 包含END饿几首
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取socket的输入流
    }
}

class SocketThread extends Thread {
    /**
     * 客户端
     */
    Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String ipAndPort = socket.getPort() + " " + socket.getInetAddress().getHostAddress();
        // 获取对方的的ip和port

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            OutputStream outputStream = socket.getOutputStream();
            while (true) {
                String line = bufferedReader.readLine();
                // 接收对方的一行信息
                outputStream.write((line + "\r\n").getBytes());
                if (line.endsWith("END")) {
                    // 包含END饿几首
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取socket的输入流
    }
}