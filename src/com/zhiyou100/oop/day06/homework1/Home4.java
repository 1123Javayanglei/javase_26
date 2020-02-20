package com.zhiyou100.oop.day06.homework1;

/**
 * @packageName: javase_26
 * @className: Home4
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/10 6:41 下午
 */
public class Home4 {
    public static void main(String[] args) {
        Complex complex = new Complex(1, 3);
        System.out.println(complex.toStringOne());
        Complex complex1=new Complex(3,5);
        Complex complex2=complex.add(complex1);
        System.out.println(complex2.toStringOne());
    }
}
class Complex{
    double real;
    double im;

    public Complex(double real, double im) {
        this.real=real;
        this.im=im;
    }
    public String toStringOne(){
        return real+im+"i";
    }

    Complex add(Complex complex){
        /*
         * @name: add
         * @description: TODO : this.XX  为当前对象, 加法
         * @param complex
         * @return: com.zhiyou100.oop.day06.homework1.Complex
         * @date: 2020/2/11 2:45 下午
         * @auther: YangLei
         *
        */
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
