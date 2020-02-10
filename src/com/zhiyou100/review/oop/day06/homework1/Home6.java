package com.zhiyou100.review.oop.day06.homework1;

/**
 * @packageName: javase_26
 * @className: Home6
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/10 7:58 下午
 */
public class Home6 {
    public static void main(String[] args) {
        Sub00 s = new Sub00();
        s.method(10);
        s.method();
        s.method("hello");
    }
}
class Super00{
    public void method(){
    }
    public void method(int i){
    }
}
class Sub00 extends Super00{
    @Override
    public void method(){
    }
    public void method(String str){
    }
}