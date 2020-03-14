package com.zhiyou100.basicclass.day17;

import java.util.Objects;

/**
 * @packageName: javase_26
 * @className: HashDemo3Student
 * @Description: TODO 把十个学生装进set，名字不能相同且分数至少相差10分，如果名字相同，分数至少相差10分
 * @author: YangLei
 * @date: 2020/3/14 11:12 上午
 */
public class HashDemo3Student {
    private String name;
    private int grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public HashDemo3Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public HashDemo3Student() {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "HashDemo3Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
       if (o==null||!(o instanceof HashDemo3Student)){
           return false;
       }
       HashDemo3Student student=(HashDemo3Student)o;
       if (student.name.equals(this.name)){
           return true;
       }
       return false;

    }

    @Override
    public int hashCode() {
        return 1;
    }
}
