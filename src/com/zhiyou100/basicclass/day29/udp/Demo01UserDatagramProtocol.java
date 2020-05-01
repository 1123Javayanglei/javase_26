package com.zhiyou100.basicclass.day29.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @packageName: javase_26
 * @className: Demo01UserDatagramProtocol
 * @Description: TODO 发送方
 * @author: YangLei
 * @date: 2020/4/9 11:49 下午
 */
public class Demo01UserDatagramProtocol {
    private static final int PORT = 10000;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(PORT);
            // 创建一个DatagramSocket

            byte[] bytes = "你好吗?".getBytes() ;
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName(IP), Demo02UserDatagramProtocol.PORT);
            // 把数据封装成DatagramPacket,端口是目标端口

            datagramSocket.send(datagramPacket);
            // 通过DatagramSocket的send方法把datagramPacket发送给接受方

            datagramSocket.close();
            // 关闭socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
