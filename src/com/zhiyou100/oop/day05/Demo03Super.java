package com.zhiyou100.oop.day05;

/**
 * @author yanglei
 * @date 2020/2/7 3:35 下午
 */
public class Demo03Super {
    public static void main(String[] args) {
        Son01 son01 = new Son01();
        // 创建子类对象时 会调用父类的无参数的构造方法
        son01.show();
    }
}
class Father01{
    int a=1;
    int b=2;
    Father01(int a){
        this.a=a;
    }
    Father01(){
        System.out.println("无参数的构造方法");
    }
}
class Son01 extends Father01{

    // There is no default constructor available in 'com.zhiyou100.oop.day05.Father01'
    void show(){

        System.out.println(a+"::"+b);
    }
    Son01(){
        super();
        // 所有的子类构造方法，第一个语句都是 super() 来调用父类的无参数的构造方法
    }
}