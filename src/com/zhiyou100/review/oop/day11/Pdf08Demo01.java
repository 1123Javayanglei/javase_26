package com.zhiyou100.review.oop.day11;

import com.zhiyou100.review.oop.day06.homework2.number6.Myclass06;

/**
 * @packageName: javase_26
 * @className: Pdf08Demo01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/16 7:56 下午
 */
public class Pdf08Demo01 {
}
interface IA{
    void m1();
    int a=100;
}
class MyClass07 implements IA{
    @Override
    public void m1() {

    }
}
class TestInterface01{
    public static void main(String[] args) {
        IA ia= new MyClass07();
        ia.m1();
        System.out.println(IA.a);
    }
}
interface IA01{
    void m1();
    void m2();
}
class MyClass08 implements IA01{
    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }
}
class MyClass09 extends MyClass08{
    @Override
    public void m1() {
        super.m1();
    }

    @Override
    public void m2() {
        super.m2();
    }
}

interface IA03{
    void ma();
}
interface IB00 extends IA03{
    void mb();
}
interface IC00{
    void mc();
}
interface ID00 extends IB00,IC00{
    void md();
}
class MyClass10 implements ID00{
    @Override
    public void ma() {

    }

    @Override
    public void mb() {

    }

    @Override
    public void mc() {

    }

    @Override
    public void md() {

    }
}
class  TestClass10{
    public static void main(String[] args) {
        IC00 ic00=new MyClass10();
    /*    MyClass10 myClass10=(MyClass10)ic00;
        myClass10.ma();
        myClass10.mb();
        myClass10.mc();
        myClass10.md();*/
        System.out.println(ic00 instanceof IA03);
        System.out.println(ic00 instanceof IB00);
        System.out.println(ic00 instanceof IC00);
        System.out.println(ic00 instanceof ID00);
        System.out.println(ic00 instanceof MyClass10);
    }
}
class Father{

}
class Son extends Father{

}
class TestInstanceof01{
    public static void main(String[] args) {
        Father father= new Son();
        if (father instanceof  Father){
            System.out.println("父亲");
        }if (father instanceof  Son){
            System.out.println("父亲");
        }

    }
}