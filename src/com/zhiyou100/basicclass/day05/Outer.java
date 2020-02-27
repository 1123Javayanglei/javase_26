package com.zhiyou100.basicclass.day05;

/**
 * @packageName: javase_26
 * @className: Outer
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/27 11:46 下午
 */

/**
 * 如果出现了重名的现象，格式是：外部类名称.this.外部类成员变量
 * @author yanglei
 */
public class Outer {
    int num=10;
    // 外部类的成员变量
    public class Inner{
        int num=20;
        // 成员内部类的成员变量
        public void methodInner(){
            int num=30;
            // 内部类方法的局部变量
            System.out.println(num);
            // out 30 局部变量，就近原则
            System.out.println(this.num);
            // out 20 内部类的成员变量
            System.out.println(Outer.this.num);
            // out 10 外部类的成员变量
        }
    }
}
