package com.zhiyou100.oop.day11;

/**
 * @packageName: javase_26
 * @className: Pdf07OfDemo04
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/15 11:02 上午
 */
public class Pdf07OfDemo04 {
    public static void main(String[] args) {

        MyClass mc1 = new MyClass();

        MyClass mc2 = new MyClass();

        System.out.println(mc1.cc == mc2.cc);
// 两个对象的，不一样
        System.out.println(mc1.ca == mc2.ca);
        // 都是静态的，一样

    }
}

class ClassA {

    static {

        System.out.println("In ClassA Static");
        // 1 加载
    }

    public ClassA() {

        System.out.println("ClassA()");
        // 2 普通方法

    }

}

class ClassB {

    static {

        System.out.println("In ClassB Static");
        // 4 加载static

    }

    public ClassB() {

        System.out.println("ClassB()");
        // 6 执行

        // 9 执行

    }

}

class ClassC extends ClassB {

    static {

        System.out.println("In ClassC Static");
        // 5 加载静态

    }

    public ClassC() {

        System.out.println("ClassC()");
        // 7 执行
        // 10 执行
    }

}

class MyClass {

    static ClassA ca = new ClassA();
    // 第一步 加载static，static随着类加载，不需要创建对象
    ClassC cc = new ClassC();
    // 第二步  赋默认初始值
    static {

        System.out.println("In MyClass Static");
        // 3  加载 static
    }

    public MyClass() {

        System.out.println("MyClass()");
        // 第三步 执行构造方法  8  执行
        // 11 执行

    }

}
