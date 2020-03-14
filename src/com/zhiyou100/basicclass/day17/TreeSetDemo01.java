package com.zhiyou100.basicclass.day17;

import com.zhiyou100.basicclass.day15.collectionDemo.CollectionDemo01;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @packageName: javase_26
 * @className: TreeSetDemo01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/14 11:37 上午
 */
public class TreeSetDemo01 {
    public static void main(String[] args) {
        TreeSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            integers.add((int)(Math.random()*100));
        }
        CollectionDemo01.printCollection1(integers);
        HashDemo1.printCutOffRule();
        TreeSet<Teacher> integers1 = new TreeSet<>();
        for (int i = 0; i < 20; i++) {
            Teacher teacher = new Teacher((int) Math.random()*3+20,"老师"+i%2,(int)Math.random()*10+3000);
            integers1.add(teacher);
        }
        CollectionDemo01.printCollection1(integers1);
        HashDemo1.printCutOffRule();
        TreeSet<Teacher1> integers2 = new TreeSet<>(new Teacher1());
        for (int i = 0; i < 20; i++) {
            Teacher1 teacher = new Teacher1((int) (Math.random()*3+20),"老师"+i%2,(int)Math.random()*10+3000);
            integers2.add(teacher);
        }
        CollectionDemo01.printCollection1(integers2);
    }
}
/**
 * 有序：元素之间要进行大小比较
 * TreeSet 要求对象必须具有可比较性
 * 让类有可比较性方案：
 *      类实现Comparable接口,compareTo方法
 *      为此类提供一个Comparator比较器类,compare方法
 */
class Teacher implements Comparable<Teacher> {
    int age;
    String name;
    double salary;

    public Teacher(int age, String name, double salary) {
        this.age = age;
        this.name = name;
        this.salary=salary;
    }

    @Override
    public int compareTo(Teacher o) {
        // 先比较年龄，年龄大的对象大，再比较工资，工资高的大，再比较名字，名字大的
        if (o.age!=this.age){
            return this.age-o.age;
        }
        if (this.salary!=o.salary){
            return this.salary>o.salary?1:-1;
        }
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
class Teacher1 implements Comparator<Teacher1>{
    int age;
    String name;
    double salary;

    public Teacher1() {
    }

    public Teacher1(int age, String name, double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compare(Teacher1 o1, Teacher1 o2) {
        if (o1.age!=o2.age){
            // 比较年龄
            return o1.age-o2.age;
        }
        if (o1.salary!=o2.salary){
            // 比较工资
            return o1.salary>o2.salary?1:-1;
        }
        return o1.name.compareTo(o2.name);
        // 比较名字
    }
}
