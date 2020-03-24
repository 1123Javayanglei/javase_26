package com.zhiyou100.basicclass.day24.threadhomework;

/**
 * @packageName: javase_26
 * @className: TheadHomeWork03
 * @Description: TODO 作业3：使用多线程 模拟五个同学同时给一个老师交每人交3本作业
 * @author: YangLei
 * @date: 2020/3/24 4:36 下午
 */
public class TheadHomeWork03 {
    public static void main(String[] args) {
        Student student1 = new Student("张三");
        Student student2 = new Student("赵四");
        Student student3 = new Student("王舞");
        Student student4 = new Student("王路");
        Student student5 = new Student("王绮");
        student1.start();
        student2.start();
        student3.start();
        student4.start();
        student5.start();
    }
}

class Student extends Thread {
    String name;
    public Student(String name) {
        super(name);
        this.name=name;
    }
    @Override
    public void run() {
        Homeworker.chineseLanguageAndLiterature(name);
        Homeworker.mathematics(name);
        Homeworker.english(name);
    }
}

class Homeworker{
    /**
     * 作业类，提供3个方法，数学，语文和英语
     * @param name
     */
    static void mathematics(String name){
        System.out.println(name+" 交"+"数学作业");
    }
    static void chineseLanguageAndLiterature(String name){
        System.out.println(name+" 交"+"语文作业");
    }
    static void english(String name){
        System.out.println(name+" 交"+"英语作业");
    }
}