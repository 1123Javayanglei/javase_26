package com.zhiyou100.basicclass.day29.socket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @packageName: javase_26
 * @className: Demo02TcpClient
 * @Description: TODO 上传一个文件
 * @author: YangLei
 * @date: 2020/4/9 10:48 上午
 */
public class Demo02TcpClient {
    private static final int PORT = 10086;
    private static final String IP = "127.0.0.1";
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(IP, PORT);
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/yanglei/javatext/a.txt"));
            OutputStream outputStream=socket.getOutputStream();
            while (true){
                String line=bufferedReader.readLine();
                if (line==null){
                    line="END+\r+\n";
                    outputStream.write(line.getBytes());
                    break;
                }
                outputStream.write((line+"\r\n").getBytes());
            }
            socket.close();
            bufferedReader.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
