package com.zhiyou100.oop.day08;

/**
 * @packageName: javase_26
 * @className: DomePolymorphism08
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/13 1:14 下午
 */
public class DomePolymorphism08 {
    public static void main(String[] args) {
        AbstractGraphTest1[] abstractGraphTest1=new   AbstractGraphTest1[6];
        abstractGraphTest1[1]=new SquareAbstract1();
        abstractGraphTest1[2]=new SquareAbstract1();
        abstractGraphTest1[3]=new RectangleAbstract1();
        abstractGraphTest1[4]=new RectangleAbstract1();
        abstractGraphTest1[5]=new CircularAbstract1();
        abstractGraphTest1[0]=new CircularAbstract1();
        for (AbstractGraphTest1 abstractGraphTest11 : abstractGraphTest1) {
            abstractGraphTest11.show();
        }
    }

}
 class AbstractGraphTest1 {
    /**
     * 图形类
     */
    public AbstractGraphTest1() {
        show();
    }


     public void show(){};
}

class SquareAbstract1 extends AbstractGraphTest1 {
    /**
     * 长方形类
     */

    public SquareAbstract1() {

    }

    @Override
    public void show() {
        System.out.println("我是一个正方形");
    }
}

class CircularAbstract1 extends AbstractGraphTest1 {
    /**
     * 圆形类
     */

    public CircularAbstract1() {
        super();

    }

    @Override
    public void show() {
        System.out.println("我是一个圆形");
    }
}

class RectangleAbstract1 extends AbstractGraphTest1 {
    /**
     * 长方形列
     */
    public RectangleAbstract1() {
    }

    @Override
    public void show() {
        System.out.println("我是一个长方形");
    }
}
