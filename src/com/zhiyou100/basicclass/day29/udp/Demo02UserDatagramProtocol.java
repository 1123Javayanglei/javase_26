package com.zhiyou100.basicclass.day29.udp;

import java.io.IOException;
import java.net.*;

/**
 * @packageName: javase_26
 * @className: Demo02UserDatagramProtocol
 * @Description: TODO 接受方
 * @author: YangLei
 * @date: 2020/4/9 11:59 下午
 */
public class Demo02UserDatagramProtocol {
    public static final int PORT = 10086;

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(PORT);
            // 创建一个DatagramSocket

            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,1024);
            // 创建一个DatagramPacket 接受数据

            datagramSocket.receive(datagramPacket);
            // 接受数据

            String s = new String(bytes, 0, datagramPacket.getLength());
            System.out.println("收到消息："+s);
            // 解析数据

            datagramSocket.close();
            // 关闭DatagramSocket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
