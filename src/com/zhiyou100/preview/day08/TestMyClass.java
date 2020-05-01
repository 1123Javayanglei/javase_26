package com.zhiyou100.preview.day08;

class MyClass {
    int value;

    public MyClass(int i) {

    }

    public MyClass() {

    }
}

/**
 * @author yanglei
 */
public class TestMyClass {
    public static void main(String[] args) {
        MyClass mc1 = new MyClass();
        //创建一个无参数的构造方法
        MyClass mc2 = new MyClass(10);
        //创建一个有参数的构造方法
        System.out.println(mc1.value);
        System.out.println(mc2.value);
    }
}