package com.zhiyou100.review.oop.day08;

/**
 * @packageName: javase_26
 * @className: DomePolymorphism05
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/12 3:36 下午
 */
public class DomePolymorphism05 {
    public static void main(String[] args) {
        test02(new Cat01("滚"));
        test02(new Dog01("撒手没"));
    }

    public static void test02(Animal animal) {
        animal.eat();
        animal.sport();
    }
}

abstract class Animal {
    /**
     * @name: Animal
     * @description: TODO 把cat类和dog类提取出animal类
     * @param Animal
     * @return:
     * @date: 2020/2/12 3:41 下午
     * @author: YangLei
     */
    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void eat();

    abstract void sport();
}

class Cat01 extends Animal {

    Cat01(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println(name+" 🐱 吃🐟");
    }

    @Override
    void sport() {
        System.out.println(name+" 晒 🌞");
    }
}

class Dog01 extends Animal {

    Dog01(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println(name+" 🐶 吃 🦴");
    }

    @Override
    void sport() {
        System.out.println(name+" 拿 🐭");
    }
}