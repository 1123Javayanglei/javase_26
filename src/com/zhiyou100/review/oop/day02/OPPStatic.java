package com.zhiyou100.review.oop.day02;

/**
 * @author yanglei
 */
public class OPPStatic {
    public static void main(String[] args) {
        Demo1 d1 = new Demo1();
        System.out.println(d1.name + "::" + d1.staticName);
        /*
         *  特点1：
         * //不应该通过实例来访问静态成员
         * //可以通过类名.静态成员，不需要创建对象
         */

        System.out.println(Demo1.staticName);


        Demo1 d2 = new Demo1();
        d1.name = "呵呵";
        System.out.println("d1.name=" + d1.name);
        // out 呵呵
        System.out.println("d2.name=" + d2.name);
        // out nameValue

        /*
         * 特点2： 类变量是共享数据，所有对象的类变量共用一个值
         * 一个对象更改static变量的值 其他对象的此变量的值也被更改了
         */
        d1.staticName = "1111";
        System.out.println("d1.staticName=" + d1.staticName + " d2.staticName=" + d2.staticName);
        // out 1111 1111
        System.out.println("Demo1.staticName=" + Demo1.staticName);
        // out 1111

        d1.sayHi();
        d1.sayHey();
        // 不应该通过类实例访问静态成员

        Demo1.sayHey();
        // 可以通过类名调用
    }
}

class Demo1 {
    String name = "nameValue";
    /**
     * 实例变量
     */
    static String staticName = "staticNameValue";

    /**
     * 类变量
     */
    void sayHi() {
        System.out.println("say Hi!"+name+staticName);
        test00();
        test01();
        /*
         *  实例成员可以调用被静态方法修饰的，也可以调用不被静态方法修饰的
         */
    }

    static void sayHey() {
//        this;
        // 'com.zhiyou100.review.oop.day02.Demo1.this' cannot be referenced from a static context 在静态方法中不能使用this
//        System.out.println("say Hey!"+name);
        // Non-static 字段 'name' cannot be referenced from a static context 在静态方法中无法调用非静态变量
        System.out.println("say Hey!"+staticName);
//        test00();
        // Non-static 方法 'test00()' cannot be referenced from a static context 在静态方法中无法调用非静态方法和变量
        test01();
    }

    void test00() {
    }

    static void test01() {
    }
}

class Student {
    String name;
    String id;
    double score;
    char gender;
    static String className;
    static String teacherName;
    static String classId;

}
