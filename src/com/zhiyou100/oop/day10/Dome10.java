package com.zhiyou100.oop.day10;

/**
 * @packageName: javase_26
 * @className: Dome10
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/14 2:20 下午
 */
public class Dome10 {
    public static void main(String[] args) {
        Father father=new Son(4,5,6);
    }
}
abstract class Father{
    static int i=10;
    int a=1;
    int b=2;
    void sayHi(){}
    void ok(){}
    abstract void sayHello();
    public Father(int a,int b){
        this.a=a;
        this.b=b;
    }
}
class Son extends Father{
    public Son(int a,int b,int c){
        super(a,b);
        this.c=c;
    }
    static int j=100;
    int a=11;
    // 重写定义父类成员的成员本类a
    int c=13;
    // 子类特有的成员变量

    @Override
    void sayHello() {
        // 实现父类的抽象方法
    }

    @Override
    void sayHi() {
        // 重写父类的方法
    }
    void heHe(){
        // 子类特有的方法
    }
}
