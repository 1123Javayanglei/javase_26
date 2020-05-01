package com.zhiyou100.basicclass.day29.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @packageName: javase_26
 * @className: Demo04UserDatagramProtocol
 * @Description: TODO 使用UPD实现互相发送消息，先收后发
 * @author: YangLei
 * @date: 2020/4/10 11:25 上午
 */
public class Demo04UserDatagramProtocol {
    private static final int SEND_PORT = 10010;
    private static final int ACCEPT_PORT = 10086;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(SEND_PORT);
            // 创建DatagramSocket，指定10010端口

            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
            // 定义一个空数据包，用来接收对方的数据

            datagramSocket.receive(datagramPacket);
            // 接收，receive是阻塞方法

            String otherIpAndPort = datagramPacket.getAddress().getHostAddress() + ":" + datagramPacket.getPort();
            String localIpAndPort = datagramSocket.getLocalAddress().getHostAddress() + ":" + datagramSocket.getLocalPort();
            System.out.println("10010::本地的ip和端口是 "+localIpAndPort);
            System.out.println("10086: 对方的ip和端口是 "+otherIpAndPort);

            String s = new String(bytes, 0, datagramPacket.getLength());
            System.out.println("10010接收的数据是："+s);
            // 分析数据

            byte[] bytes1 = "亲爱的10086移动！".getBytes();
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length, InetAddress.getByName(IP), ACCEPT_PORT);
            // 数据封装成数据包

            datagramSocket.send(datagramPacket1);
            // 发送给对方

            datagramSocket.close();
            // 关闭
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
