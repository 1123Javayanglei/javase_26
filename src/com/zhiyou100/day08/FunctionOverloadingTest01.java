package com.zhiyou100.day08;

/**
 * @author yanglei
 */
public class FunctionOverloadingTest01 {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1.add(1, 1));
        System.out.println(s1.add(1, 1.2));
        System.out.println(s1.add(1));
        System.out.println(1 + 1 + 1);
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
    }
}
class Student{
    /**
     *  方法的重载:
     * 	同一个类中，方法名相同，参数列表不同的现象
     *
     */
    public int add(int a,int b,int c){
        return a+b+c;
    }
    public int add(int a,int b){
        System.out.println("两个int参数");
        return a+b;

    }
    public double add(int a, double b){
        return a+b;
    }
    public double add(double a, int b){
        return a+b;
    }
    public int add(int a){
        return a+1;
    }

}
