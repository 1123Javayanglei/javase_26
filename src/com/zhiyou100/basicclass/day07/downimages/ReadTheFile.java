package com.zhiyou100.basicclass.day07.downimages;

import java.io.*;

/**
 * @packageName: javase_26
 * @className: ReadTheFile
 * @Description: TODO 把文件读取成一个字符串
 * @author: YangLei
 * @date: 2020/4/13 4:31 下午
 */
public class ReadTheFile {
    String filePath = "/Users/yanglei/javatext/WebDown/WebFile/index.html";

    public ReadTheFile() {
    }

    public ReadTheFile(String filePath) {
        this.filePath = filePath;
    }

    public String getString() {
        StringBuilder finalString = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            // 创建高效字符输入流
            String temp = "";
            // 记录每行
            while ((temp = bufferedReader.readLine()) != null) {
                finalString.append(temp);
                // 把读出来的每一行加入finalString中
            }
            bufferedReader.close();
            // 关闭
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalString.toString();
    }

}

