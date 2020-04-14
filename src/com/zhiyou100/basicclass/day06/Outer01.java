package com.zhiyou100.basicclass.day06;

/**
 * @packageName: javase_26
 * @className: Outer01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/28 10:27 上午
 */
public class Outer01 {
    public static void main(String[] args) {
        /**
         * 创建内部类对象格式： 局部内部类
         *  外.内
         */
        Outer02.Inner01 inner01 =  new Outer02().new Inner01();
        inner01.methodInner01();
        System.out.println("================");
        Outer02 outer03 = new Outer02();
        outer03.methodOuter02();
    }
}
class Outer02{
    String name="外部类的name";
    void methodOuter02(){
        new Inner01().methodInner01();
        // 外部类方法中调用内部类
        // 外部类名的.this.成员
        System.out.println(new Inner01().name);
    }
    class Inner01{
         String name="成员内部类的成员变量";
         public void methodInner01(){
             String name="成员内部类的成员方法中的局部变量";
             System.out.println("内部类方法");
             System.out.println(name);
             // 内部类的局部变量
             System.out.println(this.name);
             // 访问内部类的成员变量
             System.out.println(Outer02.this.name);
             // 内部类访问外部类重名的属性
         }
     }
}
