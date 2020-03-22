package com.zhiyou100.basicclass.day23.bufferedemohomework;

import java.io.*;

/**
 * @packageName: javase_26
 * @className: BufferedHomeWorkDemo2
 * @Description: TODO 使用转换流实现文件的复制
 * @author: YangLei
 * @date: 2020/3/22 11:06 下午
 */
public class BufferedHomeWorkDemo2 {
    public static void main(String[] args) throws IOException {
        System.out.println(inputStreamCopy("/Users/yanglei/javaText1/a.txt", "/Users/yanglei/javaText3"));
    }
    public static boolean inputStreamCopy(String old, String now) throws IOException {
        /*
         * @name: bufferedCopyFile
         * @date: 2020/3/22 10:17 下午
         * @return: boolean
         * @description: TODO 使用高速流实现文件的复制，把old文件的内容，复制到now目录下
         */
        File file = new File(old);
        // 原始文件
        File file1 = new File(now);
        // 目标文件
        if (file.isDirectory() || !file.exists()) {
            // 如果file 是个文件夹，或者不存在
            System.out.println(file.getName() + "不存在或是一个目录");
            return false;
        }
        if (!file1.exists()) {
            // 如果file1文件不存在则创建它的父目录
            if (file1.mkdirs()) {
                // 创建目录成功,创建同名文件
                String nowName=file.getName();
                // 提取文件名
                File file2 = new File(file1, nowName);
                // 当前文件
                if (file2.createNewFile()){
                    // 创建成功文件成功
                    copyFile1ToFile2(file, file2);
                    return true;
                }else {
                    // 创建不成功
                    return false;
                }
            } else {
                // 创建目录不成功
                return false;
            }
        } else {
            // file1文件夹存在
            File file2 = new File(file1, file.getName());
            // 创建文件
            copyFile1ToFile2(file,file2);
            return true;
        }
    }
    private static void copyFile1ToFile2(File file, File file2) throws IOException {
        /**
         * @name: copyFile1ToFile2
         * @param: File file,File file2
         * @date: 2020/3/22 11:03 下午
         * @return: void
         * @description: TODO 通过高效流把file文件复制file2
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        // 创建高效读入流,字节流 -> 转换流 -> 高效读入流
        BufferedWriter bufferedReader1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
        // 创建高效写入流, 字节流 -> 转换流 -> 高效读入流
        while (true){
            String line=bufferedReader.readLine();
            if (line==null){
                break;
            }
            bufferedReader1.write(line);
            // 一次读入一行
            bufferedReader1.newLine();
            // 写入一个换行符号
            bufferedReader1.flush();
            // 推送
        }
        // 关闭流
        bufferedReader.close();
        bufferedReader1.close();
    }
}
