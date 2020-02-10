package com.zhiyou100.review.oop.day06.homework1;

/**
 * @packageName: javase_26
 * @className: Home4
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/10 6:41 下午
 */
public class Home4 {
    public static void main(String[] args) {

    }
}
class Complex{
    double real;
    double im;

    public Complex(double real, double im) {
        this.real=real;
        this.im=im;
    }

    Complex add(Complex complex){
        double real=this.real+complex.real;
        double im=this.im+complex.im;
        return new Complex(real,im);
    }
    Complex sub(Complex complex){
        double real=this.real-complex.real;
        double im=this.im-complex.im;
        return  new Complex(real,im);
    }
    Complex mul(Complex complex){
        double real=this.real* complex.real-this.im*complex.im;
        double im=this.real*complex.im+this.im*complex.real;
        return new Complex(real,im);
    }
}
