package com.zhiyou100.review.oop.day05;

/**
 * @author yanglei
 * @date 2020/2/7 1:54 下午
 */
public class Demo01Static {
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1(1, 2);
        Demo1 demo2 = new Demo1(5);
        demo1.a = 9;
        demo1.b = 3;
        demo1.sayHi();
        Demo1.sayHi();
    }
}

class Demo1 {
    int a = 11;
    static int b = 12;

    Demo1(int a) {
        this.a = a;
    }

    Demo1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    static void sayHi() {

    }


}
