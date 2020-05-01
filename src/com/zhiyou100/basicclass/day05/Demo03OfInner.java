package com.zhiyou100.basicclass.day05;

/**
 * @packageName: javase_26
 * @className: Demo03OfInner
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/27 11:50 下午
 */
    public class Demo03OfInner {
    public static void main(String[] args) {
        Outer.Inner inner01=new Outer().new Inner();
        inner01.methodInner();
    }
}
