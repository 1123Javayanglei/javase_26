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
        this.name = name;
    }

    @Override
    public void run() {
        Homeworker.chineseLanguageAndLiterature(name);
        Homeworker.mathematics(name);
        Homeworker.english(name);
    }
}

class Homeworker {
    /**
     * 作业类，提供3个方法，数学，语文和英语
     */
    static void mathematics(String name) {
        System.out.println(name + " 交" + "数学作业");
    }

    static void chineseLanguageAndLiterature(String name) {
        System.out.println(name + " 交" + "语文作业");
    }

    static void english(String name) {
        System.out.println(name + " 交" + "英语作业");
    }
}
class Teacher{
    int number=0;
    // 使用number记录
}
class StudentThread extends Thread{
    Teacher teacher;
    public StudentThread(Teacher teacher) {
        // 通过构造方法传入teacher对象
        this.teacher = teacher;
    }

    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        // 获取读取当前线程名字
        for (int i = 1; i <=3; i++) {
            teacher.number++;
            // number++
            System.out.println(name+"的第"+i+" 本作业提交了,老师的作业总数"+teacher.number);
            // 输出
        }
    }
}
class Text2{
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        StudentThread studentThread = new StudentThread(teacher);
        StudentThread studentThread1 = new StudentThread(teacher);
        StudentThread studentThread2 = new StudentThread(teacher);
        StudentThread studentThread3 = new StudentThread(teacher);
        StudentThread studentThread4 = new StudentThread(teacher);
        studentThread.setName("张三");
        studentThread1.setName("赵四");
        studentThread2.setName("王舞");
        studentThread3.setName("王陆");
        studentThread4.setName("王二");
        studentThread.start();
        studentThread1.start();
        studentThread2.start();
        studentThread3.start();
        studentThread4.start();
    }
}