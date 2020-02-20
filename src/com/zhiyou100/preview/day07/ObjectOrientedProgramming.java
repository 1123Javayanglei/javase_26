package com.zhiyou100.preview.day07;
/**
 * @author yanglei
 */
public class ObjectOrientedProgramming {
    public static void main(String[] args) {
        /*
         * 2. 根据Person类型创建一个模型（对象）
         * 对象创建必须先起个名字，关键字new，必须在main中创建
         * 格式：对象类型 对象名 = new 对象();
         * Person 类有什么方法，此对象就有什么功能
         * Person 类有什么变量，此对象就有什么数据
         *
         * 3.给psrSonOne赋值XXX的数据
         * 4.调用对象的功能（方法）
         */
        Person perSonOne=new Person();
        perSonOne.name="XXX";
        perSonOne.age=60;
        perSonOne.sex='男';
        perSonOne.height=1.8;
        perSonOne.job="🇨🇳国家主席";
        perSonOne.show();
    }
}

class Person{
    /**
     * 1.创建一个类：描述人这个类型
     */
    int age;
    char sex;
    String name;
    double height;
    String job;
    /**
     * 变量名表示表面的数据
     * 方法表示动态的功能
     * 在oop中，方法修饰符号不再加static
     */
    public void eat(String foodName){
        System.out.println(name+"正在吃"+foodName);
    }
    public void show(){
        System.out.println("我叫"+name+" 身高"+height+" 性别"+sex+" 职位是 "+job);
    }
    public void run(){
        System.out.println(name+"正在跑步");
    }

}
