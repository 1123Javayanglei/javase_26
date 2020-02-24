package com.zhiyou100.basicclass.day03;

import java.io.UnsupportedEncodingException;

/**
 * @packageName: javase_26
 * @className: Demo02OfString
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/22 11:31 上午
 */
public class Demo02OfString {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s="123abcd";
        String ss=new String("123Abcd");
        /**
         * 字符串方法
         *  1、判断相关的方法
         *       boolean contains(String s)  判断参数字符串是不是当前字符串的子串
         *       boolean equals（String s) 判断参数字符串和当前字符串，序列是否相同
         *       boolean equalsIgnoreCase(String s) 不区分大小写
         *       boolean endWith(String s) 判断当前字符串对象是否是参数字符串结尾
         *       boolean StartWith(String s) 判断当前字符串对象是否是参数字符串开头
         *       boolean isEmpty() 判断当前字符串是否为空，字符长度为0
         *        int	compareToIgnoreCase(String str) 按字典顺序比较两个字符串，不考虑大小写。
         *
         *  2、获取相关的方法
         *      int length() 获取当前字符串的字符个数
         *      char charAt(int index) 获取参数索引处对应的字符
         *      byte getBytes() 使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
         *      byte getBytes(Charset charset) 使用给定的 charset 将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。
         *      char[]	toCharArray() 将此字符串转换为一个新的字符数组。
         *
         */

        byte[] arrBytes = "adb杨磊".getBytes("GBK");
        // Unhandled exception: java.io.UnsupportedEncodingException 解决方法，抛出异常
        for (byte arrByte : arrBytes) {
            System.out.println(arrByte);
            // gbk 一个汉字对应两个字节
            // utf-8 一个汉字对应三个字节
        }
        char[] arrBytes01 = "sdfa".toCharArray();
        for (int i = 0; i < arrBytes01.length; i++) {
            System.out.println(arrBytes01[i]);
        }
        System.out.println();
        System.out.println("234324".length());
        System.out.println(s.contains("12"));
        // true
        System.out.println(s.contains("1a"));
        // false

        System.out.println(s.equals(ss));
        System.out.println(s.equalsIgnoreCase(ss));

        System.out.println(s.endsWith("cd"));
        System.out.println(s.startsWith("1"));

        System.out.println(s.isEmpty());

    }
}
