package com.zhiyou100.preview.day12;

/**
 * @packageName: javase_26
 * @className: Demo14
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/3 1:07 上午
 */
public class Demo14 {
    public static void main(String[] args) {
        Super14 sub14 = new Sub14();
        sub14.method1();
        sub14.method2();
        Sub14 sub1411=(Sub14)sub14;
        sub1411.method1();
        sub1411.method2();
    }
}

class Super14 {
    public static void method1(){
        System.out.println("m1 in Super");
    }
    public  void method2(){
        System.out.println("m2 in Super");
    }
}
class Sub14 extends Super14{
    public static void method1(){
        System.out.println("m1 in Sub");
    }
    public void method2(){
        System.out.println("m2 in Sub");
    }
}
