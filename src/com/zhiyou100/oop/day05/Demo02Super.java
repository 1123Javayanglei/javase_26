package com.zhiyou100.oop.day05;

/**
 * @author yanglei
 * @date 2020/2/7 3:21 下午
 */
public class Demo02Super {
    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}

class Father {
    String a = "父类的：a";
    String b = "父类的：b";

    void sayHi() {
        System.out.println("父类的sayHi");
    }

    void sayHello() {
        System.out.println("父类的sayHello");
    }
}

class Son extends Father {
    String c = "子类特有的c";
    String a = "子类重新定的a";

    void sayHey() {
        System.out.println("子类特有的sayHey 方法");
    }

    @Override
    void sayHello() {
        /*
         * 重写父类的sayHello 方法
         */
        System.out.println("子类重写的 sayHello 方法");
    }

    void show() {
        System.out.println(c + "," + b + "," + a);
        // a 是子类重新定义的a
        System.out.println("super.a= " + super.a);
        // 调用父类的a
        sayHello();
        // 调用重写的 sayHello() 方法
        super.sayHello();
        // 调用父类的 sayHello() 方法
    }
}