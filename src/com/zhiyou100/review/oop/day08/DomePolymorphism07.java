package com.zhiyou100.review.oop.day08;

import edu.princeton.cs.algs4.Graph;

/**
 * @packageName: javase_26
 * @className: DomePolymorphism07
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/12 4:56 下午
 */
public class DomePolymorphism07 {
    /**
     * 设计一个台灯类Lamp其中台灯有灯泡这个属性，还有开灯(on)这个方法，
     * 设计灯泡类 其中有红灯泡(RedBuble)  和绿灯泡(GreenBuble) 他们都有一个发亮的方法，
     * 请设计出一段代码可以使台灯开启灯泡发亮，
     * 并且保证替换不同种类的灯泡台灯类代码不被修改。
     */
    public static void main(String[] args) {
        RedAbstractBulb redAbstractBulb =new RedAbstractBulb("红灯");
        GreenAbstractBulb greenAbstractBulb =new GreenAbstractBulb("绿灯");
        Lamp lamp=new Lamp(redAbstractBulb);
        lamp.on();

    }
}
abstract class AbstractBulb {
    /**
     * 灯泡都有发亮属性，但信息不具体，无法实现方法体(不知道发什么光）
     * 灯泡都有名字
     */
    String name;

    public AbstractBulb(String name) {
        this.name = name;
    }

    abstract void showLight();
}
class RedAbstractBulb extends AbstractBulb {
    public RedAbstractBulb(String name) {
        super(name);
    }

    @Override
    void showLight() {
        System.out.println("红💡 发亮");
    }
}
class GreenAbstractBulb extends AbstractBulb {
    public GreenAbstractBulb(String name) {
        super(name);
    }

    @Override
    void showLight() {
        System.out.println("绿 💡 发亮");
    }
}
class Lamp{
    /**
     * @name: Lamp
     * @description: TODO 创建台灯类，定义成员变量时，定义为父类类型，这样就可以赋值任意类型
     * @param null
     * @return:
     * @date: 2020/2/12 5:17 下午
     * @author: YangLei
    */
   AbstractBulb abstractBulb;

    public Lamp(AbstractBulb abstractBulb) {
        this.abstractBulb = abstractBulb;
    }

    void on(){
        abstractBulb.showLight();
    }
}

