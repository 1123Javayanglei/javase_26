package com.zhiyou100.basicclass.day23.bufferedemohomework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @packageName: javase_26
 * @className: BufferedHomeWorkDemo5
 * @Description: TODO 把键盘输入的内容写到参数文件中
 * @author: YangLei
 * @date: 2020/3/23 2:24 上午
 */
public class BufferedHomeWorkDemo5 {
    public static void main(String[] args) {
        File file = new File("/Users/yanglei/javatext/b.txt");
        createFile(file);
    }
    public static void createFile(File file){
        if (!file.exists()||file.isDirectory()){
            // 如果目标文件不存在或者是一个目录，跳出
            System.out.println(file.getAbsolutePath()+" 不存在或者是一个目录");
            return;
        }
        String line=new Scanner(System.in).nextLine();
        // 用字符串接收
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            // 创建流
            bufferedWriter.write(line);
            // 读取字符串
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException e) {
            System.out.println("创建流失败");
        }
    }
}
