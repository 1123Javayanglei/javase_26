package com.zhiyou100.review.oop.day06.homework1;

/**
 * @packageName: javase_26
 * @className: Home3
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/10 6:35 下午
 */
public class Home3 {
    public static void main(String[] args) {
        ClassA1 ca=new ClassA1();
        changeValue(ca);
        System.out.println(ca.value);

        changeRef(ca);
        System.out.println(ca.value);

    }
    public static void changeValue(ClassA1 ca){
        ca.value=100;
    }
    public  static void changeRef(ClassA1 ca){
        ca=new ClassA1();
        ca.value=200;
    }
}
class ClassA1{
    int value;
}
