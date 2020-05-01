package com.zhiyou100.basicclass.day29.udp;

import java.io.IOException;
import java.net.DatagramSocket;

/**
 * @packageName: javase_26
 * @className: Demo06UserDatagramProtocol
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/4/10 8:29 下午
 */
public class Demo06UserDatagramProtocol {
    private static final int SEND_PORT = 10086;
    private static final int ACCEPT_PORT = 10010;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) {
        // 发送线程
        try {
            DatagramSocket datagramSocket = new DatagramSocket(SEND_PORT);
            // 指定发送端口

            new UserDatagramSend(datagramSocket, IP, ACCEPT_PORT).start();
            new UserDatagramPutAway(datagramSocket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
