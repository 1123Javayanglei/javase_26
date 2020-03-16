package com.zhiyou100.basicclass.day17.homework;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;
import com.zhiyou100.basicclass.day15.collectionDemo.CollectionDemo01;
import com.zhiyou100.basicclass.day16.ArrayListDemo1;
import com.zhiyou100.basicclass.day17.HashDemo1;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;

import java.net.CookieHandler;
import java.util.HashSet;
import java.util.Objects;

/**
 * @packageName: javase_26
 * @className: HomeWorkForHashSet2
 * @Description: TODO 写一个worker类，创建Hashset,装10个Worker,保证如果名字相同，工资不差不能小于100
 * @author: YangLei
 * @date: 2020/3/14 5:21 下午
 */
public class HomeWorkForHashSet2 {
    public static void main(String[] args) {
        HashSet<Worker> workers = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Worker worker=new Worker("杨磊"+i%3,HomeWorkOfMath.randomOfMinToMax(0,150)+1000);
            // 随机
            System.out.println(worker);
            workers.add(worker);
        }
        HashDemo1.printCutOffRule();
        // 分隔符
        CollectionDemo01.printCollection1(workers);
        // 打印
        StdOut.println();
    }

}
class Worker{
    private String name;
    private double salary;

    @Override
    public int hashCode() {
        // hashCode 固定为1
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        // equals 返回true失败，返回false成功
        if (!(obj instanceof Worker)){
            // 判断类型
            return true;
            // 如果不是Worker类型，无法添加
        }
        Worker worker=(Worker)obj;
        if (!(this.name.equals(worker.name))){
            // 如果名字不相等成功
            return false;
        }else {
            if (Math.abs(this.salary-worker.salary)>=100){
                // 名字相同，工资差大于等于100
                return false;
            }else {
                return true;
            }
        }

    }

    @Override
    public String toString() {
        return this.name+" "+this.salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Worker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}