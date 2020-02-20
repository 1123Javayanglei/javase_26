package com.zhiyou100.oop.day06.homework2;

/**
 * @packageName: javase_26
 * @className: Text01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/11 4:29 下午
 */

public class Text01 {

    public static void main(String[] args) {
        Worker w1 = new Worker("zhangsan", 25, 2500);
        //w1.addr.adderss="北京市海淀区清华园1 号";
        //w1.addr.zipCode="100084";
        Address a1 = new Address("北京市海淀区清华园1 号", "100084");
        w1.setAddr(a1);
        //System.out.println(w1.getName()+" "+w1.getAddr().getZipCode());
        w1.work(2);
    }
}

class Worker {
    //定义类
    private String name;
    //添加三个属性
    private int age;
    private double salary;
    private Address addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    public Worker() {
    }

    //公开无参构造方法
    Worker(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    //三个参数的构造方法

    public void work() {
    }

    //无参方法
    //public void work(int hours) {} //有参方法
    public void work(int hours) {
        System.out.println("我叫" + name + ",今年" + age + "，每天工作" + hours + ",工资是" + salary + ",家住" + addr.getAdders() + ",邮编是" + addr.getZipCode());
    }
}

//12题：Address类*************************************************************
class Address { //定义类
    private String adderss;//定义属性
    private String zipCode;

    public String getAdders() {
        return adderss;
    }

    public void setAdderss(String getAdders) {
        this.adderss = adderss;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    Address() {
    }  //无参构造方法

    Address(String address, String zipCode) {
    }//带参构造方法
}