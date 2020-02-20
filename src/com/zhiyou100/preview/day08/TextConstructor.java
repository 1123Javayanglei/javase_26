package com.zhiyou100.preview.day08;

/**
 * @author yanglei
 */
class ClassA {
    public ClassA() {
        System.out.println("ClassA()");
    }
}

class ClassB {
    public ClassB() {
        System.out.println("ClassB()");
    }
}

class ClassC {
    ClassA a = new ClassA();
    ClassB b;

    // 引用数据类型，默认值是 null
    // 基本数据类型默认初始是对应数据类型的零

    public ClassC() {
        System.out.println("ClassC()");
        b = new ClassB();
    }
}

class TestConstructor {
    public static void main(String[] args) {
        ClassC cc = new ClassC();
        /*
         *  创建一个ClassC类型的对象c
         *  对象C有属性a 给a属性赋值 要创建一个classA类型的对象，要调用classA的构造方法
         *  在指向classC构造方法时 有打印 语句 打印 classC
         *  在指向classC构造方法时 b= new ClassB();
         */
    }
}
