package com.zhiyou100.basicclass.day28.threadwaiting;

import java.io.*;

/**
 * @packageName: javase_26
 * @className: TextThread
 * @Description: TODO 使用高效流更改a.java文件  把空行和每行开头的单行注释//去掉
 * @author: YangLei
 * @date: 2020/3/29 10:00 下午
 */
public class TextThread {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/yanglei/javatext/one.java");
            File file1 = new File("/Users/yanglei/javatext/two.java");
            FileReader fileReader = new FileReader(file);
            FileWriter fileWriter = new FileWriter(file1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // 创建高效输入流
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // 创建高效输出流
            String temp ;
            // 创建字符串，记录读入的字符串
            while ((temp=bufferedReader.readLine())!=null){
                // 若不到末尾，一直读，到末尾返回null
                if (temp.length() != 0 && !temp.contains("//")) {
                    // 如果没读到空行或者注释，读入two.java
                    bufferedWriter.write(temp);
                    bufferedWriter.newLine();
                    // 换个行
                    bufferedWriter.flush();
                    // 读一个刷新一个
                }
            }
            bufferedReader.close();
            bufferedWriter.close();
            // 关闭流
            file1.renameTo(file);
            // file1 改名为file
        }catch (Exception e){
            System.out.println("创建流失败");
        }

    }

}
