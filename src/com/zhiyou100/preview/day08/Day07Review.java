package com.zhiyou100.preview.day08;

/**
 * @author yanglei
 */
public class Day07Review {
    public static void main(String[] args) {
        PersonTest p1 = new PersonTest();
        p1.age = 19;
        p1.name = "杨磊";
        p1.height = 175;
        p1.food = "黄焖鸡";
        p1.sayHello();
        p1.eatFood(p1.food);

        PersonTest p2=p1;
        // 给p1对象创建一个别名p2

        PersonTest p3=new PersonTest();
        p1=p3;
        //用p3覆盖p1，11～16的p1失效，p1内存会被自动清理




    }
}

class PersonTest {
    /**
     * 创建一个测试人类
     * 数据 age,height,name,gender
     * 方法：自我介绍、吃饭
     */
    int age=18;
    /**
     * 在类中给变量赋值，其实是给此类创建的所有对象的此变量设置默认初始值
     */
    int height;
    char gender;
    String name;
    String food;

    public void sayHello() {
        /*
         * 方法不要使用 修饰符 static
         * 在方法内可以访问所有定义的变量
         * 打印输出语句要用字符串拼凑
         * 变量前后必须有 + ， 字符串必须用 ""
         *
         */
        System.out.println("My name is " + name + ", height: " + height + " " + age + " year old");
    }

    public void eatFood(String food) {
        System.out.println("today eat " + food);
    }
}
