package com.zhiyou100.review;

/**
 * @author yanglei
 */
public class OOPReview {
    public static void main(String[] args) {
        Person person=new Person();
        person.age=18;
        person.name="杨磊";
        person.job="coder";
        person.sayHi();
        person.add(1,2.0);
    }
}
class Person{
    int age;
    String name;
    String job;
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
