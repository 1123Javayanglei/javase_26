package com.zhiyou100.review.oop.day03;


import java.util.Arrays;


class Student   {
    private int age;
    private String name;
    private char gender;
    private double grade;

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        final double minGrade = 0.0;
        final double maxGrade = 100.0;
        if (grade >= minGrade && grade <= maxGrade) {
            this.grade = grade;
        } else {
            System.out.println("成绩不合法");
        }

    }

    /**
     * 私有化步骤：1、属性加private 2、提供get和set方法
     * <p>
     * <p>
     * get语法:
     * public 返回值类型 gat属性名(){
     * return 属性名;
     * }
     * <p>
     * set语法:
     * public void set属性名(数据类型 属性名){
     * this.属性名=属性名;
     * }
     * <p>
     * 偷懒 cmd+n 选择 get & set
     */
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        final int maxAge = 200;
        if (age > 0 && age <= maxAge) {
            this.age = age;
        } else {
            System.out.println("⚠️ 年龄不合法");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        final char genderMan = '男';
        final char genderWoman = '男';
        if (gender == genderMan || gender == genderWoman) {
            this.gender = gender;
        } else {
            System.out.println("性别不合法");
        }
    }

    void show() {
        System.out.println(age + "::" + name);
    }
}

