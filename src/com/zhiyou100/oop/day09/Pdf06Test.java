package com.zhiyou100.oop.day09;

/**
 * @author yanglei
 */
public class Pdf06Test {
    public static void main(String[] args) {
        Son son = new Son();
        son.method();
    }
}

class Father {
    int method() {
        return 0;
    }
}

class Son extends Father {
    /*
    第一种 ok
    @Override
    public int method(){
        return 0;
    }*/
    /*
    第二种： No
    void method(){
        System.out.println("hhleo");
    }*/
    /*
    第三种： OK
    void method(int n){

    }*/
}
