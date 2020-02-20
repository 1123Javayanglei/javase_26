package com.zhiyou100.preview.day11;

/**
 * @author yanglei
 * 继承可以继承除private私有属性外的一切方法
 * object 是Java中的顶级父类
 */
public class Demo11 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.age);
        System.out.println(dog.color);
        System.out.println(dog.name);
//        System.out.println(dog.privateStr);
        dog.eat();
        dog.m2();
        dog.m3();
//        dog.m1();
//        dog.getClass();

    }
}

class Person{
    /**
     * 方法重载：方法名相同，参数的个数或者类型不同
     * 构成方法重载：在一个类中
     * 方法覆盖在继承关系中
     */
    String name;
    int age;
    public Person(){

    }
    public Person(String name){
        this.name=name;
    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void eat(){
        System.out.println("eat...");
    }
    public void eat(String food){
        System.out.println("eat "+food);
    }
}
class Animal{
    private String privateStr= "privateStr";
    String name="huahua";
    protected  int age=4;
    public String color="黑色";

    public void eat(){
        System.out.println("eat...");
    }
    private void m1(){
        System.out.println("m1");
    }
    protected void m2(){
        System.out.println("m2");
    }
    void m3(){
        System.out.println("m3");
    }
}

class Dog extends Animal{
    @Override
    public void eat() {
        /*
         * 子类覆盖父类同名方法
         * super 父类的引用
         * this 当前对象
         */
        super.eat();
        System.out.println("子承父业");
    }
}
