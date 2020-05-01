package com.zhiyou100.basicclass.day13.execptionDemo;

/**
 * @packageName: javase_26
 * @className: Exception01Demo
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/9 4:32 下午
 */
public class Exception01Demo {
    public static void main(String[] args) {
        String s=null;
        System.out.println(s.length());
        // 调用了指向null的引用的属性和方法
        // java.lang.NullPointerException
    }
}
