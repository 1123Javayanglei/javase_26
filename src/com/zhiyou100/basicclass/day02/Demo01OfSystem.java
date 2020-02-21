package com.zhiyou100.basicclass.day02;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @packageName: javase_26
 * @className: Demo01OfSystem
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/21 10:36 上午
 */
public class Demo01OfSystem {
    public static void main(String[] args) {
        /**
         * static PrintStream	err
         * “标准”错误输出流。
         *
         * static InputStream	in
         * “标准”输入流。
         *
         * static PrintStream	out
         * “标准”输出流。
         */
        // err 错误输出流
        System.err.println("err 输出流1");
        System.err.println("err 输出流2");
        System.err.println("err 输出流3");
        // out 标准输出流
        System.out.println("out 输出流1");
        System.out.println("out 输出流2");
        System.out.println("out 输出流3");

        InputStream is=System.in;
        // 获取系统输出流对象的监控对象scanner
        Scanner sr=new Scanner(is);
        sr=new Scanner(System.in);
        // 两种方式
        // 调取监控器对象的方法获取系统输出的内容
        System.out.println("请输入一个字符串");
        // scanner 对象的nextXXX 方法是阻塞方法，程序会直等待某个操作的执行
        String s=sr.next();
        System.out.println("s="+s);
        System.out.println("请输入一个整数");
        int n=sr.nextInt();
        System.out.println("n="+n);


    }
}

