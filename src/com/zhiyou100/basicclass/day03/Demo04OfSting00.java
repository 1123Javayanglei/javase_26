package com.zhiyou100.basicclass.day03;

import java.util.Arrays;

/**
 * @packageName: javase_26
 * @className: Demo04OfSting00
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/24 10:38 上午
 */
public class Demo04OfSting00 {
    public static void main(String[] args) {
        /**
         * 获取
         * Sting[]  split(Sting s) :使用参数字符串切割当前字符串，形成一个字符串数组
         *  String	substring(int beginIndex)  返回一个新的字符串，它是此字符串的一个子字符串。 [beginIndex,maxIndex]
         *  String	substring(int beginIndex, int endIndex) 返回一个新字符串，它是此字符串的一个子字符串。 [beginIndex,endIndex)
         */
        String s= " afsdfdsasdfsdfdsafsdfdsasdfdsafdasdfdsfdsasdfdsfsdadfdsfdasdfsfdsaaaa";
        String[] strings = s.split("a");
        System.out.println(Arrays.toString(strings));
        System.out.println("abcfdsf".substring(3));
        // fdsf
        System.out.println("abcfdsf".substring(3,6));
        // fds
    }
}
