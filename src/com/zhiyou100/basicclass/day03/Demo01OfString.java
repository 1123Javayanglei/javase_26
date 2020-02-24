package com.zhiyou100.basicclass.day03;

/**
 * @packageName: javase_26
 * @className: Demo01OfString
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/22 10:58 上午
 */
public class Demo01OfString {
    public static void main(String[] args) {
        /**
         * Sting
         *  创建字符串对象的方法
         *      构造方法
         *
         */
        String string00="fads";
        String string = new String(string00);
        // 创建一个参数字符串的副本对象

        string=new String(new char[]{'a','b','c'});
        // 通过字符数组创建一个字符串
        string=new String(new byte[]{97,43,5,34,56,34,23,});
        // 通过byte数组创建一个字符串
        string=new String(new int[]{97,43,5,34,56,34,23,},0,3);
        // 通过int数组创建一个字符串,(起始位置,结束位置)
        string=new String();
        // 无参数的构造方法，等同与 ""
        string="";

        string="12sa";
        string+=1;
        // out 12sa1,"12sa"没有更改，只是生成了一个新的字符串对象"12sa1"
        string=1+1+"ab"+1+"a";
        // 4个
        System.out.println(string);

        string=new String("1b1");
        // 先通过""创建了字符串"1b1"，再通过new String()创建一个"1b1"相同字符串的字符串对象 共2个





    }
}
