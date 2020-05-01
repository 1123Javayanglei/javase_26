package com.zhiyou100.basicclass.day13.tryAndCatchDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @packageName: javase_26
 * @className: CaptureDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/10 4:50 下午
 */
public class CaptureDemo1 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        try {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("1234-3-4"));
//            System.out.println("我执行了");
            FileInputStream fileInputStream = new FileInputStream("/Users/yanglei/Desktop/a.txt");
        } catch (Exception e) {
            // 所有异常
            e.printStackTrace();
        }finally {
            System.out.println("我一定会被执行");
        }

    }
}
