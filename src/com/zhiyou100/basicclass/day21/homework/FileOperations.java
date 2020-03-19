package com.zhiyou100.basicclass.day21.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @packageName: javase_26
 * @className: FileOperations
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/19 8:07 下午
 */
public class FileOperations {
    public static void main(String[] args) {
        String old = "/Users/yanglei/javaText1/f.txt";
        String now = "/Users/yanglei/javaText1/g.txt";
        copyByByteArray(old, now);
    }

    public static void copyByByte(String old, String now) {
        /*
         * @description: Todo 把old对应的文件中的所有数据，复制到now文件中，逐个字节的读写
         * 步骤：
         *  1、把old文件读出来
         *  2、把old读出来的字节写入now
         *  3、结束
         */
        try {
            FileInputStream fileInputStream1 = new FileInputStream(old);
            // 创建输出流与目的文件关联
            FileOutputStream fileInputStream = new FileOutputStream(now);
            // 创建输入流与目的文件关联
            int n;
            // 记录输出流的值
            while (true) {
                n = fileInputStream1.read();
                // 把old文件读出来
                if (n == -1) {
                    // 如果n=-1 跳出
                    break;
                }
                fileInputStream.write(n);
                // 把读入的写入
            }
            fileInputStream.close();
            fileInputStream1.close();
            // 关闭
        } catch (Exception e) {
            // 如果文件不存在，输出
            System.out.println("文件不存在");
        }

    }
    public static void copyByByteArray(String old, String now) {
        /*
         * @description: Todo 把old对应的文件中的所有数据，复制到now文件中，逐个字节数组的读写
         * 步骤：
         *  1、把old文件读出来
         *  2、把old读出来的字节写入now
         *  3、结束
         */
        try {
            FileInputStream fileInputStream1 = new FileInputStream(old);
            // 创建输出流与目的文件关联
            FileOutputStream fileInputStream = new FileOutputStream(now);
            // 创建输入流与目的文件关联

            byte[] bytes=new byte[4];
            // 创建数组放读入
            while (true){
                // 循环遍历
                int n=fileInputStream1.read(bytes,0,bytes.length);
                // 用n记录
                if (n==-1){
                    // 如果没有了，跳出
                    break;
                }
                for (int i = 0; i < n; i++) {
                    // 遍历写入
                    fileInputStream.write(bytes[i]);
                }
            }
            fileInputStream.close();
            fileInputStream1.close();
            // 关闭
        } catch (Exception e) {
            // 如果文件不存在，输出
            System.out.println("文件不存在");
        }

    }

}
