package com.zhiyou100.oop.day08;

/**
 * @packageName: javase_26
 * @className: DomePolymorphism03
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/12 12:35 下午
 */
public class DomePolymorphism03 {
    public static void main(String[] args) {
        Person p=new Student();
        p.run();
        // 无法确定运行时究竟调用哪个run()方法
        // out Student.run

    }
    public static void runTwice(Person person){
        /*
         * 传入了参数类型也是Person，我们不知道传入的参数类型究竟是Person还是Student，还是其他Person的其他子类，
         * 因此，也无法确定调用的是不是Person类的run()方法。
         */
        person.run();
        person.run();
    }
}
class Person{
public void run(){
    System.out.println("Person.run");
}
}
class Student extends Person{
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}