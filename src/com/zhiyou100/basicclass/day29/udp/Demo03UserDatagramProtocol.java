package com.zhiyou100.basicclass.day29.udp;

import java.io.IOException;
import java.net.*;

/**
 * @packageName: javase_26
 * @className: Demo03UserDatagramProtocol
 * @Description: TODO UDP实现互发信息，先发后收
 * @author: YangLei
 * @date: 2020/4/10 11:07 上午
 */
public class Demo03UserDatagramProtocol {
    private static final int SEND_PORT = 10086;
    private static final int ACCEPT_PORT = 10010;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(SEND_PORT);
            // 创建DatagramSocket 指定10086端口

            byte[] bytes = "联通你好吗？".getBytes();

            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName(IP), ACCEPT_PORT);
            // 封装成数据包，指定10010端口

            String localIpAndPort = datagramSocket.getLocalAddress().getHostAddress() + ":" + datagramSocket.getLocalPort();
            datagramSocket.send(datagramPacket);
            System.out.println("10086本地的ip和端口 " + localIpAndPort);
            // 发送给对方

            byte[] bytes1 = new byte[1024];
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length);
            // 指定一个空的数据包，用来接受对方发送的数据


            datagramSocket.receive(datagramPacket1);
            String otherIpAndPort = datagramPacket1.getAddress().getHostAddress() + ":" + datagramPacket1.getPort();
            System.out.println("10086对方的ip和端口" + otherIpAndPort);
            // 接收数据

            String s = new String(bytes1, 0, datagramPacket1.getLength());
            System.out.println("10086接收的数据是 " + s);
            // 分析数据

            datagramSocket.close();
            // 关闭socket


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
