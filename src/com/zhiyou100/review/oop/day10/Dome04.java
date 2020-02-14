package com.zhiyou100.review.oop.day10;

/**
 * @packageName: javase_26
 * @className: Dome04
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/14 8:57 下午
 */
public class Dome04 {
    public static void main(String[] args) {
        Son01 son01=new Son01();
        // son01 引用 对应的是子类对象 Son01
        Father01 father01=son01;
        // father01 引用对应的是多态对象
        System.out.println(son01.a+" >> "+son01.b);
        System.out.println(father01.a);
        father01.sayHi();
        /**
         * 一个对象有两个名字
         *  使用 son01 表现的是子类对象
         *  使用 father01 表现的是父类对象
         */
    }
}
class Father01{
    int a=11;
    void sayHi(){
        System.out.println("Father say hello");
    }
}
class Son01 extends Father01{
    int a=13;
    int b=2;

    @Override
    void sayHi() {
        System.out.println("Son say hi");
    }
    void ok(){
        System.out.println("Son say ok");
    }
}
