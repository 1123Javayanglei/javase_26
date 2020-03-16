package com.zhiyou100.basicclass.day17.homework;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;
import com.zhiyou100.basicclass.day15.collectionDemo.CollectionDemo01;
import com.zhiyou100.basicclass.day17.HashDemo1;
import edu.princeton.cs.algs4.StdOut;

import java.util.TreeSet;

/**
 * @packageName: javase_26
 * @className: HomeWorkForHash3
 * @Description: TODO 使用TreeSet装10个学生信息，先按分数从大到小排序，如果分数一样按照班级编号从小到大排，如果编号相同，再按照名字生序排序
 * @author: YangLei
 * @date: 2020/3/14 6:37 下午
 */
public class HomeWorkForHash3 {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        // 创建Student的泛型TreeSet
        for (int i = 0; i < 20; i++) {
            Student student = new Student("杨磊" + (int) (Math.pow(2, i)), HomeWorkOfMath.randomOfMinToMax(0, 100), (int) (HomeWorkOfMath.randomOfMinToMax(1, 10)));
//            Student student = new Student("杨磊", HomeWorkOfMath.randomOfMinToMax(0,100)); 测试分数不一样
//            Student student = new Student("杨磊",100,HomeWorkOfMath.randomOfMinToMax(1,5)); 测试分数一样
//            Student student = new Student("杨磊"+Math.pow(2,i),100,1); 测试名字升序排列
            students.add(student);
            //添加
        }
        HashDemo1.printCutOffRule();
        // 打印分隔符
        CollectionDemo01.printCollection1(students);
        // 打印students

    }
}

class Student implements Comparable<Student> {
    // 实现Comparable接口
    private String name;
    private double grade;
    private int classNumber;

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public Student(String name, double grade, int classNumber) {
        this.name = name;
        this.grade = grade;
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        // 重写toString方法
        return this.name + " " + this.grade + " " + classNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        /**
         * @name: compareTo
         * @param: Student o
         * @date: 2020/3/14 8:25 下午
         * @return: int
         * @description: TODO 实现comparTo方法， 先按分数从大到小排序，如果分数一样按照班级编号从小到大排，如果编号相同，再按照名字升序排序
         */
        if (o.grade != this.grade) {
            // 如果分数不一样
            return this.grade > o.grade ? -1 : 1;
            // 按照分数从大到小
        } else {
            //如果分数一样
            if (o.classNumber != this.classNumber) {
                // 如果班级编号不一样
                return this.classNumber > o.classNumber ? 1 : -1;
                // 按照班级名字 从小到大
            } else {
                // 如果班级编号一样 按照姓名从小到大
                return this.name.compareTo(o.name);
                // 若调用==参数 R0, 调用<参数 R-1, 若调用>参数 R1
            }
        }
    }
}
