package com.zhiyou100.oop.day06.homework1;

/**
 * @packageName: javase_26
 * @className: Home5
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/10 7:41 下午
 */
public class Home5 {
    public static void main(String[] args) {
        Sub s1 = new Sub();
        Sub s2 = new Sub(10);
        Sub s3 = new Sub("hello");
    }
}
class Super{
    public Super(){
        System.out.println("Super()");
    }
    public Super(String str){
        System.out.println("Super(String)");
    }

    public void method(int i) {
    }
}
class Sub extends Super{
    public Sub(){
        System.out.println("Sub()");
    }
    public Sub(int i){
        this();
        System.out.println("Sub(int)");
    }
    public Sub(String str){
        super(str);
        System.out.println("Sub(String)");
    }
}
