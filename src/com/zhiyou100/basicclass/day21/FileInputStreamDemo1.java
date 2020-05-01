package com.zhiyou100.basicclass.day21;

import com.zhiyou100.basicclass.day17.HashDemo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @packageName: javase_26
 * @className: FileInputStreamDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/19 5:13 下午
 */
public class FileInputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
         * FileInputStream 字节输入流
         *
         *  构造方法
         *     FileInputStream(File file) 关联文件对象
         *     FileInputStream(String name) 关联文件对象的目录
         *
         *  读方法：当读到末尾时，返回-1
         *      int read() 一次读一个字节
         *      int read(byte[] b,int off,int lean) 一次读一个字节数组
         *
         *  关闭方法：关闭流释放资源
         *       void close()
         *
         *
         *
         * FileOutputStream 字节输出流
         *  构造方法
         *      FileOutputStream(File file)
         *      FileOutputStream(File file,boolean append)
         *      FileOutputStream(String name)
         *      FileOutputStream(String name,boolean append)
         *
         *  写入方法
         *       void	write(byte[] b) 将 b.length 个字节从指定 byte 数组写入此文件输出流中。
         *       void	write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
         *       void	write(int b) 将指定字节写入此文件输出流。
         *
         *  关闭方法
         *      void	close() 关闭此文件输出流并释放与此流有关的所有系统资源。
         *
         *  步骤
         *      1、创建输出流与目的文件关联
         *      2、选择写的方法：逐个字节的写、逐个字节数组的写
         *      3、关闭流
         *
         */
        readByByte();
        HashDemo1.printCutOffRule();
        readByByteArray();
        HashDemo1.printCutOffRule();
        theOutputStreamIsByteByByte();
        theOutputStreamIsByteByByteArray();
    }

    private static void theOutputStreamIsByteByByte() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/yanglei/javaText1/b.txt");
        // 创建输出流与目的文件的关联
        // 写入的方法：逐个字节的写
        fileOutputStream.write('H');
        fileOutputStream.write('e');
        fileOutputStream.write('l');
        fileOutputStream.write('l');
        fileOutputStream.write('o');
        // 关闭流
        fileOutputStream.close();
    }
    private static void theOutputStreamIsByteByByteArray() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/yanglei/javaText1/c.txt");
        // 创建输出流与目的文件的关联
        // 写入的方法：逐个字节数组的写
        byte[] bytes="你好，世界".getBytes();
        fileOutputStream.write(bytes,0,bytes.length);
        // 关闭流
        fileOutputStream.close();
    }

    // 一 、 逐个字节读
    private static void readByByte() throws IOException {
        // 1、创建流关联文件
        FileInputStream fileInputStream = new FileInputStream("/Users/yanglei/javaText1/a.txt");
        // 2、选择读写方式：逐个字节读
        int n;
        // 定义变量记录读取的字节数据
        while (true){
            // 使用循环一直读
            n=fileInputStream.read();
            // 读一个字节
            if (n==-1){
                // 如果n=-1，表明到达文件结尾，结束读
                break;
            }
            System.out.print((char) n);
            // 把有效信息写出去
        }
        // 3、关闭流，释放资源
        fileInputStream.close();
    }

    // 二、逐个字节数组读
    private static void readByByteArray() throws IOException {
        // 1、创建流关联文件
        FileInputStream fileInputStream = new FileInputStream("/Users/yanglei/javaText1/a.txt");
        // 2、选择读写方式：逐个字节读
        byte[] bytes=new byte[2];
        // 定义一个空的数组，装读取的字节--作为缓冲区
        while (true){
            // 使用循环一直读
           int n=fileInputStream.read(bytes,0,2);
            /**
             * bytes 为存储数据的字节数组
             * 0 偏移量，从arr数组的0下标出来存储读取的数据
             * 2 每次允许读取的最多字节数
             *
             * 返回值n 读取到bytes数组中的有效字节数 返回值为-1 表示到达文件末尾
             */
            if (n==-1){
                // 如果n=-1，表明到达文件结尾，结束读
                break;
            }
            for (int i = 0; i < n; i++) {
                System.out.print((char) bytes[i]);
            }
        }
        // 3、关闭流，释放资源
        fileInputStream.close();
    }
}
