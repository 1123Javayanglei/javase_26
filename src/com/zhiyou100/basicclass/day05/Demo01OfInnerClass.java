package com.zhiyou100.basicclass.day05;

/**
 * @packageName: javase_26
 * @className: Demo01OfInnerClass
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/27 11:22 上午
 */
public class Demo01OfInnerClass {
    public static void main(String[] args) {
        Demo01 demo01=new Demo01();
        // 静态代码块 -》 构造代码块 ——》构造方法

    }
}
class Demo01{
    int i=11;
    static int n;
    //成员
    public Demo01(){
        System.out.println("构造方法");
    }
    // 构造方法
    void show(){
        System.out.println("show");
    }
    //普通方法
    {
        System.out.println("构造代码块");
    }
    // 构造代码块：创建一个对象，构造方法执行一次
    // 作用 ： 一般是给实例变量赋值
    static {
        System.out.println("静态代码块");
    }
    // 静态代码块：只有在类加载时，执行一次
    // 作用：给类变量赋值

}
