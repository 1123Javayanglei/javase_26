package com.zhiyou100.oop.day06;

/**
 * @packageName: javase_26
 * @className: Demo01
 * @Description: TODO 继承内存图
 * @author: YangLei
 * @date: 2020/2/10 1:49 下午
 */
public class Demo01 {
    public static void main(String[] args) {
        Son son = new Son(6, 7, 8);
        System.out.println(son.i);
//        不应该通过类实例访问静态成员 com.zhiyou100.oop.day06.Son.i
        System.out.println(Son.i);

    }
}
class Father{
    int a=1;
    int b=2;
    void sayHi(){
        System.out.println(1);
    }
    void sayHello(){
        System.out.println(2);
    }
    public Father(int a,int b){
        this.a=a;
        this.b=b;
    }
    static int i=1;
}
class Son extends Father{
    int a=11;
    int c=13;
    @Override
    void sayHi(){
        System.out.println(1);
    }

    @Override
    void sayHello() {
        System.out.println(2);
    }
    public Son(int a, int b, int c){
        super(a,b);
        this.c=c;
    }
    static  int j=2;
}
