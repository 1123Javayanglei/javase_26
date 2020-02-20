package com.zhiyou100.preview.day08;

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
        Worker w1 = new Worker("张三", 25, 2500);

        w1.addr = new Address("北京市海淀区清华园1号", "100084");

        Complex complex1 = new Complex(1, 2);
        Complex complex2 = new Complex(1, 3);
        Complex complex3 = new Complex(1, 2);
        complex3 = complex3.add(complex1, complex2);
        System.out.println("add : " + complex3.real + " " + complex3.im);
        complex3 = complex3.sub(complex1, complex2);
        System.out.println("sub : " + complex3.real + " " + complex3.im);
        complex3 = complex3.mul(complex1, complex2);
        System.out.println("mul: " + complex3.real + " " + complex3.im);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        ComplexOne complexOne1 = new ComplexOne(1, 2);
        ComplexOne complexOne2 = new ComplexOne(1, 3);
        ComplexOne complexOne3 = complexOne1.add(complexOne2);
        //ComplexOne c = complexOne2;

        // complesOne3 放结果

        System.out.println("1 2 + 1 3 = " + complexOne3.real + " " + complex3.im + "i");
        complexOne3 = complexOne1.sub(complexOne2);
        System.out.println("1 2 - 1 3 = " + complexOne3.real + " " + complex3.im + "i");
        complexOne3 = complexOne1.mul(complexOne2);
        System.out.println("1 2 * 1 3 = " + complexOne3.real + " " + complex3.im + "i");


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
        this.name = name;
        this.salary = salary;
    }

    public void work() {

    }

    public void work(int hour) {

    }
}

class Address {
    String address;
    String zipCode;

    public Address() {

    }

    public Address(String address, String zipCode) {
        this.address = address;
        this.zipCode = zipCode;
    }
}

class Complex {
    double real;
    double im;

    Complex(double real, double im) {
        this.real = real;
        this.im = im;
    }

    public Complex add(Complex complex1, Complex complex2) {
        double real = complex1.real + complex2.real;
        double im = complex1.im + complex2.im;
        return new Complex(real, im);
    }

    public Complex sub(Complex complex1, Complex complex2) {
        double real = complex1.real - complex2.real;
        double im = complex1.im - complex2.im;
        return new Complex(real, im);
    }

    public Complex mul(Complex complex1, Complex complex2) {
        double real = (complex1.real * complex2.real - complex1.im * complex2.im);
        double im = (complex1.real * complex2.im + complex1.im * complex2.real);
        return new Complex(real, im);
    }


}

class ComplexOne {
    double real;
    double im;

    ComplexOne(double real, double im) {
        this.real = real;
        this.im = im;
    }

    ComplexOne add(ComplexOne c) {
        double real = this.real + c.real;
        double im = this.im + c.im;
        return new ComplexOne(real, im);
    }

    ComplexOne sub(ComplexOne c) {
        double real = this.real - c.real;
        double im = this.im - c.im;
        return new ComplexOne(real, im);

    }

    ComplexOne mul(ComplexOne c) {
        double real = this.real * c.real - this.im * c.im;
        double im = this.real * c.im + this.im * c.real;
        return new ComplexOne(real, im);

    }
}
