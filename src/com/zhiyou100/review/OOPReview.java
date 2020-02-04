package com.zhiyou100.review;

/**
 * @author yanglei
 */
public class OOPReview {
    public static void main(String[] args) {
        Person person=new Person();
        Person person2=new Person(1);
        person.age=18;
        person.name="杨磊";
        person.job="coder";
        person.sayHi();
        person.add(1,2.0);
        System.out.println("\n");

        Demo1 demo1=new Demo1();
        System.out.println(demo1);
        demo1.show();
    }
}
class Person{
    int age;
    String name;
    String job;

    /**
     * 成员变量 定义在类中的变量:
     * age,name,job
     */
    Person(){
        System.out.println("无参数的构造方法1");
        return;
    }
    Person (int a){
        // 构造方法互相调用用this(参数列表)
        this();
    }
    void test(int a){
        /*
         * 局部变量 定义在方法中的变量
         * a
         */

    }
    void sayHi(){
        System.out.println("我的名字是"+name+"\t工作是"+job+"\t今年"+age+"岁");
    }
    /**
     * 方法重载：方法名相同，参数列表不同
     */
    int add(int a,int b){
        return a+b;
    }
    double add(int a,double b){
        return a+b;
    }
    int add(int a){
        return a+1;
    }

}
class Demo1{
    void show(){
        System.out.println(this);
    }
}
