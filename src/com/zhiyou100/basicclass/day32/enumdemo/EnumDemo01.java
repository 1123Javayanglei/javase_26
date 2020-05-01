package com.zhiyou100.basicclass.day32.enumdemo;

/**
 * @packageName: javase_26
 * @className: EnumDemo01
 * @Description: TODO 多例类
 * @author: YangLei
 * @date: 2020/4/14 11:00 上午
 */
public class EnumDemo01 {
    public static void main(String[] args) {
        MyColor myRad = MyColor.red;
        MyEnumColor myEnumColorOfBlack = MyEnumColor.black;
        System.out.println(MyEnumColor.black.getName());
        System.out.println(myEnumColorOfBlack.name());
        // name 方法是获得 枚举名


    }
}

class MyColor {
    /**
     * 创建一个类，多例类：只有固定的几个对象
     */
    String name;
    String number;
    // 66ccff 是蓝色


    private MyColor(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public static MyColor black = new MyColor("black", "");
    public static MyColor white = new MyColor("white", "");
    public static MyColor red = new MyColor("red", "");
    public static MyColor green = new MyColor("green", "");
    public static MyColor blue = new MyColor("blue", "");
}

enum MyEnumColor {
    /**
     * 枚举类
     */
    black("black", ""),
    red("red", ""), white("white", ""),
    green("green", ""), blue("blue", "");
    String name;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getNumber() {
        return number;
    }

    void setNumber(String number) {
        this.number = number;
    }

    MyEnumColor(String name, String number) {
        this.name = name;
        this.number = number;
    }

    String number;

    public void show() {
        // 自定义方法
        System.out.println("name" + name + " number" + number);
    }

}