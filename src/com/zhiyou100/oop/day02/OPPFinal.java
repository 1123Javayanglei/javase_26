package com.zhiyou100.oop.day02;

/**
 * @author yanglei
 */
public class OPPFinal {
    public static void main(String[] args) {
        Demo00 demo00 = new Demo00();
        demo00.printPI();
        demo00.printName();
    }
}

class Demo00 {
    int a;
    //    final int b;
    final int b = 11;
    /*
     *  Variable 'b' might not have been initialized final
     * final类型的变量没有默认初始值，必须显示赋值
     * final类型的变量只能赋值一次
     */
//    b=12;
    final double PI = Math.PI;

    final String name = "哔哩哔哩🍻";

    void printPI() {
        System.out.println(PI);
    }

    void printName() {
        System.out.println(name);
    }

    void test00(final int b) {
        System.out.println(b);
    }

}
