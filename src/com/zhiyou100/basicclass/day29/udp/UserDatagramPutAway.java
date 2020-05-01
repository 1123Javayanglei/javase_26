package com.zhiyou100.basicclass.day29.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @packageName: javase_26
 * @className: UserDatagramPutAway
 * @Description: TODO 接收的线程
 * @author: YangLei
 * @date: 2020/4/10 8:28 下午
 */
class UserDatagramPutAway extends Thread {
    /**
     * 接受的线程
     */
    DatagramSocket datagramSocket;

    public UserDatagramPutAway(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                byte[] bytes = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, 1024);
                // 创建一个datagramPacket 用来接收数据

                datagramSocket.receive(datagramPacket);
                // 接收数据

                String ipAndPort = datagramPacket.getAddress().getHostAddress() + ":" + datagramPacket.getPort();
                // 对方的ip和端口

                String localhostIpAndPort = datagramSocket.getLocalAddress().getHostName() + ":" + datagramSocket.getLocalPort();
                // 本地的ip和端口

                String s = new String(bytes, 0,datagramPacket.getLength());
                System.out.println(localhostIpAndPort + "接收到 " + ipAndPort + " 的消息:: " + s);
                // 处理数据

                if (s.endsWith("END")) {
                    // 如果包含END结束
                    datagramSocket.close();
                    return;
                }

            } catch (IOException e) {
                System.out.println("通信结束！");
                return;
            }
        }
    }
}
