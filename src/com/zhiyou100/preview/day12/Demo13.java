package com.zhiyou100.preview.day12;

/**
 * @packageName: javase_26
 * @className: Demo13
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/3 1:02 上午
 */
public class Demo13 {
    public static void main(String[] args) {
        Demo13 demo13 = new Demo13();
        demo13.method1();
    }
    public void method1(){
        System.out.println("普通方法");
        method2();
    }
    public static void method2(){
        System.out.println("静态方法");
//        method1();
    }
}
