package com.zhiyou100.oop.day06.homework2.number13;

/**
 * @packageName: javase_26
 * @className: TestSuperSub
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/11 6:23 下午
 */
public class TestSuperSub {
    public static void main(String[] args) {
        Super super01=new Sub();
        super01.m();
    }
}
class Super{
    public void m(){
        foo();
    }
    public void foo(){
        System.out.println("foo() in Super");
    }
}
class Sub extends Super{
    @Override
    public void foo() {
        System.out.println("foo() in Sub");
    }
}
