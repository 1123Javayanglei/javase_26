package com.zhiyou100.oop.day11;



/**
 * @packageName: javase_26
 * @className: Pdf07OfDemo03
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/15 10:23 上午
 */
public class Pdf07OfDemo03 {
    public static void main(String[] args) {
        MyClass06 myclass06 = new MyClass06();
        MyClass06 myclass01 = new MyClass06();
        MyClass06 myclass02 = new MyClass06();
        MyClass06 myclass03 = new MyClass06();
        System.out.println(MyClass06.cont);

    }
}

class MyClass06 {
    static int cont = 0;

    MyClass06() {
        cont++;
    }
}