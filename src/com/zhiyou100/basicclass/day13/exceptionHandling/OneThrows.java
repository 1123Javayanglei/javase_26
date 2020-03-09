package com.zhiyou100.basicclass.day13.exceptionHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @packageName: javase_26
 * @className: OneThrows
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/9 5:01 下午
 */
public class OneThrows {
    public static void main(String[] args) {
//        throwsTest01();

    }
    public static void throwsTest01() throws ParseException, FileNotFoundException {
        /**
         * 作用：
         *  1、提示调用者 ：当前方法可能出现异常
         *  2、如果出现异常 当前方法不处理 调用者来处理
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse("1234/34/43");
        FileInputStream fileInputStream = new FileInputStream("d://a.txt");

    }
}
