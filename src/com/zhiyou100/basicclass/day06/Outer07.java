package com.zhiyou100.basicclass.day06;

/**
 * @packageName: javase_26
 * @className: Outer07
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/28 11:41 上午
 */
public class Outer07 {
    public static void main(String[] args) {
//        new OuterClass1.InnerClass1().b;
        OuterClass1.InnerClass1 out1 = new OuterClass1.InnerClass1();
        // 外.内 名= new 外.内();

    }
}

class OuterClass1 {
    static String name = "外部类name";
    int a = 11;

    static class InnerClass1 {
        int b = 12;
        String name = "内部类的name";
        static int c = 13;

        void show() {
            System.out.println(OuterClass1.name);
            // 可以调用静态成员
            OuterClass1 outerClass1 = new OuterClass1();
            System.out.println(outerClass1.a);
            // 想要调用普通成员，必须先创建对象
        }
    }

    void hai() {
        System.out.println(InnerClass1.c);
        // 静态成员 内部类.静态成员
        InnerClass1 innerClass1 = new InnerClass1();
        // 想要调用非静态成员 必须先创建对象
        System.out.println(innerClass1.b + innerClass1.name);
    }
}
