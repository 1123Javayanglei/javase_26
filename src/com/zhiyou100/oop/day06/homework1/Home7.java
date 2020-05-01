package com.zhiyou100.oop.day06.homework1;

/**
 * @packageName: javase_26
 * @className: Dome7
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/10 11:19 下午
 */
public class Home7 {
    public static void main(String[] args) {
        Sub03 sub= new Sub03();
        Super03 sup=new Super03();
        foo(sup);
        foo(sub);
    }
    public static void foo(Super03 s){
        s.m();
    }
}
class Super03{
    public void m(){
        System.out.println("m() in Super");
    }
}
class Sub03 extends  Super03{
    @Override
    public void m(){
        System.out.println("m() in Sub");
    }
}
