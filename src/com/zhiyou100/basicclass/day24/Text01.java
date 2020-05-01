package com.zhiyou100.basicclass.day24;

import java.util.ArrayList;

/**
 * @packageName: javase_26
 * @className: Text01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/24 6:03 下午
 */
public class Text01 {
}

class CESHI {
    public static void main(String[] args) {
        Student st1 = new Student("student1");
        Student st2 = new Student("student2");
        Student st3 = new Student("student3");
        Student st4 = new Student("student4");
        Student st5 = new Student("student5");
        st1.start();
        st2.start();
        st3.start();
        st4.start();
        st5.start();
        for (String aa : Student.arr) {
            System.out.println(aa + "提交作业");
        }
    }
}

class Student extends Thread {
    /**
     * 学生类的线程
     */
    static ArrayList<String> arr = new ArrayList<>();
    String name = "";
    //记录名字，是谁提交的作业

    Student(String name) {
        super(name);
        //命名
        this.name = name;
        //学生名字赋值
    }

    @Override
    public void run() {
        int max=3;
        for (int i = 0; i < max; i++) {
            //每个学生提交三次作业
            arr.add(name);
            //System.out.println(name+"提交作业");
        }
    }
}
