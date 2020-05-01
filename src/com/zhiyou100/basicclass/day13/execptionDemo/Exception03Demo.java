package com.zhiyou100.basicclass.day13.execptionDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @packageName: javase_26
 * @className: Exception03Demo
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/9 4:37 下午
 */
public class Exception03Demo {
    public static void main(String[] args) throws ParseException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("1234-12-1"));
        // 格式转换异常
        // java.lang.ArithmeticException
    }
}
