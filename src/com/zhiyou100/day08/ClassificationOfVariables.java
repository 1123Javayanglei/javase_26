package com.zhiyou100.day08;

import java.security.ProtectionDomain;

/**
 * @author yanglei
 */
public class ClassificationOfVariables {
    public static void main(String[] args) {

    }
}
class Dome1{
    /**
     * 成员变量 —— 定义在类中的变量
     * 局部变量 —— 定义在方法中的变量
     */
    int a=10;
    int b=12;
    int e;
    /**
     * 成员 a,b
     * 局部 c,d,i
     */
    public void test1(int c){
        int d=12;
        for (int i = 0; i < 5; i++) {

            System.out.println(e);
            System.out.println(c);
            // 调用方法时 必须给c赋值
            System.out.println(i);
            //错误:(29, 17) java: 已在方法 test1(int)中定义了变量 i

            //在成员方法中可以调用所有的成员变量
            System.out.println(a+" "+b);

            //在成员方法中可以调用所有成员方法
            hello();
        }
    }
    public void hello(){
        System.out.println("hello");
    }
}
