package com.zhiyou100.basicclass.day22;

import com.zhiyou100.basicclass.day17.HashDemo1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @packageName: javase_26
 * @className: FileReadAndWriteDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/20 11:18 上午
 */
public class FileReadAndWriteDemo1 {
    public static void main(String[] args) throws IOException {
        /**
         *
         * 注意： 字符流只能操作文本文件
         * FileReader 字符输入流
         *  构造方法：
         *      FileReader(File file) 在给定从中读取数据的 File 的情况下创建一个新 FileReader。
         *      FileReader(String fileName) 在给定从中读取数据的文件名的情况下创建一个新 FileReader。
         *
         *  读方法：
         *      int read() 一次读一个字符 到达文件末尾，返回-1
         *      int[] read(char[] cbuf,int offset,int length) 读取最多length个字符，装入cbuf数组中
         *      偏移量是offset，返回值为有效的字符数
         *
         *  关闭流
         *    void close() 关闭流，释放资源
         *
         *    使用方法
         *      1、创建字符输出流和源文件关联
         *      2、选择读写方式：逐个字符或逐个字符数组
         *      3、关闭流
         *
         *
         * FileWriter 字符输出流
         *  构造方法
         *      FileWriter(File file) 根据给定的 File 对象构造一个 FileWriter 对象。
         *      FileWriter(File file,boolean append) 根据给定的 File 对象构造一个 FileWriter 对象
         *      FileWriter(String fileName) 根据给定的文件名构造一个 FileWriter 对象。
         *      FileWriter(String name,boolean append) 根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象。
         *
         *   写方法
         *      void write(int c) 写入单个字符。
         *      void write(String str) 写入字符串
         *      void write(char[] cbuf,int off,int len) 写入字符数组的某一部分。
         *
         *   刷新
         *       void	flush() 刷新该流的缓冲。
         *
         *    关闭
         *     void close() 关闭流
         *
         *
         *     使用方法
         *      1、创建输出流与目的文件关联
         *      2、选择写入方式
         *      3、关闭流
         *
         */
        fileReaderChar();
        HashDemo1.printCutOffRule();
        fileReaderCharArray();

        FileWriter fileWriter = new FileWriter("/Users/yanglei/javaText1/h.txt");
        fileWriter.write('A');
        fileWriter.write("hello world");
        char[] arr="1234abc".toCharArray();
        fileWriter.write(arr,1,4);
        fileWriter.flush();
        // 把缓冲区的数据刷新到目的文件中：一般写一次，刷新一次
        // 字节流没有缓冲区
//         关闭流 输出流在关闭之前会自动刷新一下
        fileWriter.close();
        /**
         * 注意
         *  当使用 FileOutputStream 时，不关闭流，字节写到目的文件中
         *  当使用 FileWriter 时，不关闭流，字节写到目的文件中
         */

//        byte[] bytes="杨".getBytes();
//        for (byte c:bytes){
//            System.out.print(c+" ");
//        }
//

    }
    private static void fileReaderCharArray() throws IOException {
        FileReader fileReader = new FileReader("/Users/yanglei/javaText1/a.txt");
        while (true){
            char[] chars=new char[1024];
            int n=fileReader.read(chars,0,1024);
            if (n==-1){
                break;
            }
            String mes=new String(chars,0,n);
            System.out.print(mes);
        }
    }

    private static void fileReaderChar() throws IOException {
        FileReader fileReader = new FileReader("/Users/yanglei/javaText1/a.txt");
        while (true){
            int n=fileReader.read();
            if (n==-1){
                break;
            }
            System.out.print((char)n);
        }
    }
}
