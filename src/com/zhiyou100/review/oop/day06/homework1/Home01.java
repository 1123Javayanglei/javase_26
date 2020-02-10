package com.zhiyou100.review.oop.day06.homework1;

/**
 * @packageName: javase_26
 * @className: Home01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/10 5:19 下午
 */
public class Home01 {
    public static void main(String[] args) {
        int value = 10;
        changeInt(value);
        System.out.println(value);
        ClassA ca = new ClassA();
        ca.value = 10;
        changeObject(ca);
        System.out.println(ca.value);
    }
    public static void changeInt(int value){
        value++;
    }
    public static void changeObject(ClassA ca){
        ca.value++;
    }

}
class ClassA{
    int value;
}
class Student{
    public void Student(){}
    void init(){
        age = 10;
        name = "limy";
    }
    public Student(String name){
        this.init();
        this.name = name;
    }
    public Student(String name, int age){
        this(name);
        this.init();
        this.age = age;
    }
    int age;
    String name;
}