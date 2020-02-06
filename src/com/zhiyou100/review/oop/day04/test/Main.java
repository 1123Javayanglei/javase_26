package com.zhiyou100.review.oop.day04.test;


/**
 * @author yanglei
 */
public class Main {
    public static void main(String[] args) {
        Student s = new Student("Xiao Ming", 12, 89);
    }
}

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


}

class Student extends Person {
    protected int score;

    public   Student(String name, int age, int score) {
        super(name,age);
        this.score = score;
    }
}

