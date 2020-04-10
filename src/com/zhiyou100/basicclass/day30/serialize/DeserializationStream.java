package com.zhiyou100.basicclass.day30.serialize;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @packageName: javase_26
 * @className: DeserializationStream
 * @Description: TODO 反序列化流 把存储设备中对象的信息读取到内存中，重构成对象
 * @author: YangLei
 * @date: 2020/4/11 12:35 上午
 *
 * ObjectInputStream 反序列化
 *  作用：
 *      把存储设备中对象的信息读取到内存中，重构成对象
 *
 *   构造方法：
 *      ObjectInputStream(InputStream in) 创建从指定 InputStream 读取的 ObjectInputStream。
 *
 *   普通方法：
 *      void	close() 关闭输入流。
 *      Object	readObject() 从 ObjectInputStream 读取对象。
 */
public class DeserializationStream {
    private static final String FILE_NAME = "/Users/yanglei/javatext/object";
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            // 创建字节流和文件关联

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // 创建反序列化流和字节流关联

            String s="";
            // 定义一个字符串初始化，用来存储读出来的信息
            while (true){
                try {
                    s= (String) objectInputStream.readObject();
                    // 读出来，存储
                }catch (EOFException e){
                    // 读完会产生 EOFException
                    break;
                    // 跳出
                }
            }

            System.out.println(s);
            // 打印输出
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
