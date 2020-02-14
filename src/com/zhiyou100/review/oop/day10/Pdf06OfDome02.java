package com.zhiyou100.review.oop.day10;

/**
 * @packageName: javase_26
 * @className: Pdf06OfDome02
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/14 6:39 下午
 */
public class Pdf06OfDome02 {
    public static void main(String[] args) {
        Shape[] shape=new Shape[3];
        shape[0]=new Circle(20);
        shape[1]=new Rect(23,34);
        shape[2]=new Square(23);
        for (Shape value : shape) {
            System.out.println("面积:"+value.getArea()+" 周长："+value.getLength());
        }
    }
    public static Shape getShape(int i){
        if (i==0){
            return new Circle(1);
        }
        if (i==1){
        return new Rect(3,2);
        }
        if (i==2){
            return new Square(2);
        }
        return null;
    }
}

abstract class Shape {
    abstract double getLength();
    abstract double getArea();

}

class Circle extends Shape {
    /**
     * 圆形 属性 半径
     * 方法 求周长和面积
     */
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getLength() {
        return 2*Math.PI*radius;
    }

    @Override
    double getArea() {
        return Math.PI*radius*radius;
    }
}

class Rect extends Shape {
    public Rect() {
    }

    public Rect(double rectOfLong, double rectOfWide) {
        this.rectOfLong = rectOfLong;
        this.rectOfWide = rectOfWide;
    }

    /**
     * 矩形 属性 长、宽
     * 方法 求周长，面积
     *
     */
    double rectOfLong;
    double rectOfWide;
    @Override
    double getLength() {
        return (rectOfLong+rectOfWide)*2;
    }

    @Override
    double getArea() {
        return rectOfLong*rectOfWide;
    }
}

class Square extends Rect {
    public Square(double squareOfLong) {
        this.squareOfLong = squareOfLong;
    }
    private Square(){

    }

    /**
 * 正方形类 属性 边长
 * 方法 面积、周长
 *
 */
    double squareOfLong;

    @Override
    double getArea() {
        return squareOfLong*squareOfLong;
    }

    @Override
    double getLength() {
        return squareOfLong*4;
    }
}
