package com.zhiyou100.day08;

/**
 * @author yanglei
 * 构造方法、构造器：用于构建和创建对象的方法
 */
public class FunctionOverloadingTest02 {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        /*
         * Teacher() 构造方法
         */
        t1.age = 28;
        t1.name = "韩梅梅";
        t1.show();
        Worker w1=new Worker("张三",25,2500);
//        w1.addr.address="北京市海淀区清华园1号";
//        w1.addr.zipCode="100084";

        Complex complex1 = new Complex(1, 2);
        Complex	complex2=new Complex(1,3);
        Complex complex3=new Complex(1,2);
        complex3=complex3.add(complex1,complex2);
        System.out.println("add : "+complex3.real+" "+complex3.im);
        complex3=complex3.sub(complex1,complex2);
        System.out.println("add : "+complex3.real+" "+complex3.im);
        complex3=complex3.mul(complex1,complex2);
        System.out.println("add : "+complex3.real+" "+complex3.im);

    }
}
class Teacher {
    /**
     * 创建一个构造方法，无参数
     */
    public void Teacher() {
        //普通方法 有void
        System.out.println("hello");
    }

    public Teacher(int a) {
        //构造方法  没有返回值类型 有参数
        System.out.println("有参数" + a);
    }

    public Teacher() {
        //构造方法  没有返回值类型
        System.out.println("无参数");
    }

    int age = 23;
    String name;

    public void show() {
        System.out.println("age= " + age + ",name= " + name);
    }
}

class Worker {
    String name;
    int age;
    double salary;
    Address addr;
    public Worker() {

    }

    public Worker(String name, int age, double salary) {

    }

    public void work() {
    }

    public void work(int hour) {

    }
}

class Address{
    String address;
    String zipCode;
    public Address(){

    }
    public Address(String address,String zipCode){

    }
}

class Complex{
    double real;
    double im;
    Complex(double real,double im){
        this.real=real;
        this.im=im;
    }
    public  Complex add(Complex complex1, Complex complex2){
        double real=complex1.real+complex2.real;
        double im=complex1.im+complex2.im;
        return new Complex(real,im);
}
    public  Complex sub(Complex complex1, Complex complex2){
        double real=complex1.real-complex2.real;
        double im=complex1.im-complex2.im;
        return new Complex(real,im);
    }
    public Complex mul(Complex complex1,Complex complex2){
        double real=(complex1.real*complex2.real-complex1.im*complex2.im);
        double im=(complex1.real*complex2.real+complex1.im*complex2.im);
        return new Complex(real,im);
    }


}
