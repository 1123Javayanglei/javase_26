package com.zhiyou100.oop.day06.homework1;

/**
 * @packageName: javase_26
 * @className: Home02
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/10 6:10 下午
 */
public class Home02 {
    public static void main(String[] args) {
        Worker worker = new Worker("zhangsan", 25, 2500);
        worker.setAddress(new Address("fags","234"));
        worker.printAddress();
    }
}


class Worker {
    /**
     * @name: Worker
     * @description: TODO  工人类
     * @param null
     * @return:
     * @date: 2020/2/10 6:11 下午
     * @auther: YangLei
     */
    private String name;
    private int age;
    private double salary;
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public void printAddress(){
        /*
         * @name: printAddress
         * @description: TODO  提供一个打印方法，用来打印地址
         * @return: void
         * @date: 2020/2/11 4:51 下午
         * @auther: YangLei
         *
        */
        System.out.println(getAddress().getAddress()+" "+getAddress().getZipCode());
    }

    Worker() {
    }

    Worker(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    void work() {

    }

    int work(int hours) {
        return hours;
    }
}

class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    private String zipCode;

    Address() {

    }

    Address(String address, String zipCode) {
        this.address = address;
        this.zipCode = zipCode;
    }
}
