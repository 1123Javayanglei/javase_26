package com.zhiyou100.oop.day06.homework1;

/**
 * @packageName: javase_26
 * @className: Home8
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/10 11:26 下午
 */
public class Home8 {
    public static void main(String[] args) {

    }
    public static Animal getAnimal(){
//        return null; 通过
//        return new Animal(); 通过
//        return new Dog(); 通过
        return new Cat();
        //通过
    }
}
class Animal{

}
class Dog extends Animal{}
class Cat extends Animal{}
