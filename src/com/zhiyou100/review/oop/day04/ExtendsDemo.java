package com.zhiyou100.review.oop.day04;

import java.io.FilenameFilter;

/**
 * @author yanglei
 */
public class ExtendsDemo {
    public static void main(String[] args) {

    }
}
class Person{
    /**
     * 定义一个类，记录人这个类的基本信息
     * 年龄、姓名、性别
     * 功能：自我介绍
     */
    private int a=10;
    int age;
    char gender;
    String name="父类的名字";
    public void show(){
        System.out.println(name+"::"+age+"::"+gender);
    }
    Person(){

    }
    Person(int age){
        System.out.println("有参数的构造方法");
    }
    public void  sayHi(){
        System.out.println("a="+this.a);
    }
}
class Student extends Person{
    /**
     * 定义一个类：学生类
     * 基本信息：age、gender、score、id
     * 功能：自我介绍、算数
     *
     * 子类继承父类后，子类不需要再定义父类中已有的成员了
     */
    double score;
    String id;
    void add(int a,int b){
        System.out.println(a+"+"+b+"="+(a+b));
    }
    /**
     * 子类重新定义父类已有的成员变量，要求：变量名相同即可
     *
     * 子类可以重写父类的已经有的成员方法，要求：返回值类型，方法名和参数列表必须和父类一致
     * 重写 ：子类重信定义父类的成员方法：override
     * 重载：相同的方法名，不同的参数列表 overload
     */
    String name="子类重新定义的name";
    String age="子类重新定义的age";

    @Override
    public void show() {
        System.out.println("子类重写的父类方法");
    }
}
