package com.zhiyou100.basicclass.day29.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @packageName: javase_26
 * @className: UserDatagramSend
 * @Description: TODO 发送的线程
 * @author: YangLei
 * @date: 2020/4/10 8:29 下午
 */
class UserDatagramSend extends Thread {
    /**
     * 发送的线程
     */
    DatagramSocket datagramSocket;
    String ip;
    int port;

    public UserDatagramSend(DatagramSocket datagramSocket, String ip, int port) {
        this.datagramSocket = datagramSocket;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        while (true) {
            // 边读，边通过socket发送
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // 获取键盘输入流
            try {
                String line = bufferedReader.readLine();
                // 获取键盘数据
                byte[] bytes=line.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(ip), port);
                // 封装

                datagramSocket.send(datagramPacket);
                // 发送
                if (line.endsWith("END")) {
                    datagramSocket.close();
                    // 然后末尾包含END结束
                    return;
                }
            } catch (IOException e) {
                System.out.println("通信结束");
                return;
            }
        }

    }
}
