package com.zhiyou100.basicclass.day06;

/**
 * @packageName: javase_26
 * @className: Outer03
 * @Description: TODO 局部内部类
 * @author: YangLei
 * @date: 20202/28 10:57 上午
 */
public class Outer03 {

}

class Outer04 {
    String name = "外部类的name";
    int age = 10;

    void show() {
        String name="外部类的局部变量name";
        String name1=name;
        class Inner3 {

            String name = "局部内部类";

            void sayHi() {
                System.out.println(name);
                // 省略了 this.name
                System.out.println(Outer04.this.name);
                //外部类成员
                System.out.println(age);
                System.out.println(name1);
            }
        }
        new Inner3().sayHi();
        // 只能在这个show方法中创建对象
        // 出了这个方法，就无法创建对象，无法访问
    }
}
