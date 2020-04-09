package com.zhiyou100.basicclass.day29.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @packageName: javase_26
 * @className: Demo02TcpServer
 * @Description: TODO 把客户端的一个文本文件上传到服务器，并且对文件内容进行更改：大小写转换，删除数字
 * @author: YangLei
 * @date: 2020/4/9 10:36 上午
 */
public class Demo02TcpServer {
    private static final int PORT = 10086;
    private static final String IP = "127.0.0.1";
    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(PORT);
            // 创建ServerSocket指定要开启的端口

            Socket socket=serverSocket.accept();
            // 等待连接，获取socket对象



            InputStream inputStream=socket.getInputStream();
            // 获取socket的字节输入流，并接收

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            // 使用转换流把 字节输入流 -》 转换成 -》字符输出流

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 用字符流输入流 创建一个 高效输入流

            // 总结：通过socket的输入流获取客户端上传的文件，把字节输入流转为字符输入流，再转为高效流

            System.out.println("本地ip："+socket.getLocalAddress().getHostAddress()+" 本地端口："+socket.getLocalPort());
            System.out.println("对方ip "+socket.getInetAddress().getHostAddress()+" 对方端口："+socket.getPort());
            // 输出端口信息

            String fileName=bufferedReader.readLine();
            // 先读一行信息：是文件名字

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/yanglei/javatext/text"+fileName));
            // 创建一个高效字符输出流，创建一个文件用来接收更改后的文件

            while (true){
                String line=bufferedReader.readLine();
                if (line==null){
                    // 判断是不是上传文件
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static String changeString(String s){
        /**
         * @name: changeString
         * @param: void
         * @date: 2020/4/9 10:42 上午
         * @return: String
         * @description: TODO 大写转小写，小写转大写,数字删除
         */
        StringBuilder stringBuffer = new StringBuilder(s);
        for (int i = 0; i < stringBuffer.length(); i++) {
            char temp=stringBuffer.charAt(i);
            if (Character.isUpperCase(temp)){
                stringBuffer.setCharAt(i,Character.toLowerCase(temp));
            }else if (Character.isLowerCase(temp)){
                stringBuffer.setCharAt(i,Character.toUpperCase(temp));
            }else if (Character.isDigit(temp)){
                stringBuffer.deleteCharAt(i);
            }
        }
        return String.valueOf(stringBuffer);
    }

}
