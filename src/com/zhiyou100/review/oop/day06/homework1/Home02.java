package com.zhiyou100.review.oop.day06.homework1;

/**
 * @packageName: javase_26
 * @className: Home02
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/10 6:10 下午
 */
public class Home02 {
    public static void main(String[] args) {
        Worker worker = new Worker("zhangsan",25,2500);
         worker.address = new Address("北京市海淀区清华园1号", "100084");
//        worker.address.zipCode="fads";
//        worker.address.address="fdasf";
        System.out.println(worker);
        System.out.println(worker.address);
        System.out.println(worker.address.address);
        System.out.println(worker.address.zipCode);

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
    String name;
    int age;
    double salary;
    Address address;
    Worker() {
    }

    Worker(String name, int age, double salary) {
        this.name=name;
        this.age=age;
        this.salary=salary;
    }

    void work() {

    }

    int work(int hours) {
        return hours;
    }
}
class Address{
    String address;
    String zipCode;
    Address(){

    }
    Address(String address,String zipCode){
        this.address=address;
        this.zipCode=zipCode;
    }
}
