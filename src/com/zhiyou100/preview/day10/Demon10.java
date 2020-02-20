package com.zhiyou100.preview.day10;

/**
 * @author yanglei
 */
public class Demon10 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
        dog.play();

        System.out.println("\n");

        Cat cat = new Cat();
        cat.eat();
        cat.sleep();
        cat.play();

        System.out.println();

        FlyFish ff = new FlyFish();
        ff.swim();
        ff.fly();

        System.out.println();

        Mobile mobile=new Mobile();
        mobile.play();
        mobile.playVideo();
    }
}

/**
 * 更好的实现程序的抽象过程
 */
interface Player {
    public void play();
}

interface VideoPlayer extends Player {
    /**
     * 接口可以继承
     * VideoPlayer 继承 Player的方法
     */
    public void playVideo();
}

class Mobile implements VideoPlayer {

    @Override
    public void play() {
        System.out.println("play...");
    }

    @Override
    public void playVideo() {
        System.out.println("play video...");
    }
}
interface Bird {
    public void fly();
}

interface Fish {
    public void swim();
}

class FlyFish implements Bird, Fish {
    /**
     * 一个类可以实现多个接口
     * FlyFish 类  实现 Bird和Fish两个接口
     */
    @Override
    public void fly() {
        System.out.println("fly ...");
    }

    @Override
    public void swim() {
        System.out.println("swim...");
    }
}

interface Animal {

    public void eat();

    public void sleep();

    public void play();
}

class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("cat eat...");
    }

    @Override
    public void sleep() {
        System.out.println("cat sleep...");
    }

    @Override
    public void play() {
        System.out.println("cat play...");
    }
}

class Dog implements Animal {

    @Override
    public void eat() {
        System.out.println("dog eat...");
    }

    @Override
    public void sleep() {
        System.out.println("dog sleep...");
    }

    @Override
    public void play() {
        System.out.println("dog play...");
    }
}