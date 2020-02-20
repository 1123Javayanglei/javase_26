package com.zhiyou100.oop.day04;

/**
 * @author yanglei
 * 作业一：
 * 设计一个形状类Shape,方法:求周长和求面积
 * 形状类的子类:Rect(矩形),Circle(圆形)，Square(正方形)
 * 不同的子类会有不同的计算周长和面积的方法
 */
public class ExtendsTest00 {
    public static void main(String[] args) {
        Rect rect = new Rect();
        Circle circle = new Circle();
        Square square = new Square();
        rect.length=20;
        rect.wide=10;
        System.out.println("矩形的周长::"+rect.girth()+" 面积:"+rect.area());
        circle.radius=10;

    }
}

class Shape {
    /**
     * 设计一个形状类 shape，方法：求周长和面积
     * girth 周长
     * area 面积
     *
     * 此类存在的意义不是为了创建对象，而是为了定义规范：
     *  如果你是我的子类，你必须有求周长和面积的方法
     */
    public double girth() {
        return 0;
    }

    public double area() {
        return 0;
    }
    private int birMon;

    public int getBirMon() {
        return birMon;
    }

    public void setBirMon(int birMon) {
        this.birMon = birMon;
    }
}

class Rect extends Shape {
    /**
     * 创建一个 rect矩形类，继承shape类
     * 重写周长和面积方法
     */
    double length;
    double wide;

    @Override
    public double girth() {
        return 2 * (length + wide);
    }

    @Override
    public double area() {
        return length * wide;
    }
}

class Circle extends Shape {
    /**
     * 定义Circle 圆形 子类，继承Shape
     * 定义半径 radius
     * 重写方法
     */
    double radius;

    @Override
    public double girth() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }
}

class Square extends Shape {
    /**
     * 定义Square 正方形子类，继承Shape
     * 定义 edge 边长
     * 重写方法
     */
    double edge;

    @Override
    public double girth() {
        return edge * 4;
    }

    @Override
    public double area() {
        return edge * edge;
    }
}