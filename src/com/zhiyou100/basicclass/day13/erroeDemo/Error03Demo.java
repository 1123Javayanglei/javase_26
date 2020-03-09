package com.zhiyou100.basicclass.day13.erroeDemo;

/**
 * @packageName: javase_26
 * @className: Error03Demo
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/9 4:04 下午
 */
public class Error03Demo {
    public static void main(String[] args) {
        recursion();
    }
    public static void recursion(){
        recursion();
        // 递归不写出口的都是勇士
    }
}
