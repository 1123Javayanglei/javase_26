package com.zhiyou100.review.oop.day08;

/**
 * @packageName: javase_26
 * @className: DomePolymorphism04
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/12 3:25 下午
 */
public class DomePolymorphism04 {
    public static void main(String[] args) {

    }

    public static void test1(Cat cat) {
        /**
         * @name: test1
         * @description: TODO 测试猫
         * @param cat
         * @return: void
         * @date: 2020/2/12 3:31 下午
         * @author: YangLei
         *
        */
        cat.sport();
        cat.eat();
    }

    public static void test2(Dog dog) {
        /**
         * @name: test2
         * @description: TODO 测试🐶
         * @param dog
         * @return: void
         * @date: 2020/2/12 3:32 下午
         * @author: YangLei
         *
        */
        dog.sport();
        dog.eat();
    }
    // 以上的方法只能测试一种动物，有多少种类型，就要写多少次数
    // 代码复用性差
    // 代码的可扩展性差，
}

class Cat {
    String name;

    Cat(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println("🐱吃🐟");
    }

    void sport() {
        System.out.println("🐱在🌞");
    }
}

class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println("🐶吃🦴");
    }

    void sport() {
        System.out.println("🐶在抓🐭");
    }
}

