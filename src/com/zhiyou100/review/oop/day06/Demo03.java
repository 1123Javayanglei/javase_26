package com.zhiyou100.review.oop.day06;

/**
 * @packageName: javase_26
 * @className: Demo03
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/10 3:45 下午
 */
public class Demo03 {
    public static void main(String[] args) {
        Demo04 demo04 = new Demo04();


    }
}

abstract class AbstractDemo01 {
    abstract void sayHi();

    abstract void sayHello();

    void sayOk(){};

    AbstractDemo01(){

    }
    // 抽象类的构造方法 不是为了创建本类对象 而是用于子类对象
    // 把父类中定义的成员，加载进子类对象内存中


}
class Demo04 extends AbstractDemo01{

    @Override
    void sayHi() {

    }

    @Override
    void sayHello() {

    }

    Demo04(){
        super();
    }
}
