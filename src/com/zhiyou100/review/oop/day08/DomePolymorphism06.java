package com.zhiyou100.review.oop.day08;

/**
 * @packageName: javase_26
 * @className: DomePolymorphism06
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/12 3:52 下午
 */
public class DomePolymorphism06 {


    public static void main(String[] args) {
        returnNumber(0);
        returnNumber(-34);
        returnNumber(2);

    }

    public static AbstractGraphTest returnNumber(int n) {
        if (n > 0) {
            return new SquareAbstract();
        } else if (n == 0) {
            return new CircularAbstract();
        } else {
            return new RectangleAbstract();
        }
    }
}

abstract class AbstractGraphTest {
    /**
     * 图形类
     */
    public AbstractGraphTest() {
        show();
    }


    abstract void show();
}

class SquareAbstract extends AbstractGraphTest {
    /**
     * 长方形类
     */

    public SquareAbstract() {

    }

    @Override
    void show() {
        System.out.println("我是一个正方形");
    }
}

class CircularAbstract extends AbstractGraphTest {
    /**
     * 圆形类
     */

    public CircularAbstract() {
        super();

    }

    @Override
    void show() {
        System.out.println("我是一个圆形");
    }
}

class RectangleAbstract extends AbstractGraphTest {
    /**
     * 长方形列
     */
    public RectangleAbstract() {
    }

    @Override
    void show() {
        System.out.println("我是一个长方形");
    }
}