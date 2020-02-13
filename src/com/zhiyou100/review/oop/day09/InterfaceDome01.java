package com.zhiyou100.review.oop.day09;

/**
 * @packageName: javaee_26
 * @className: InterfaceDome01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/13 2:03 下午
 */
public class InterfaceDome01 {
    public static void main(String[] args) {
        Interface01 interface01=new Implements01();
        // 接口不能创建对象但是可以定义引用来接受其实现的对象，就是多态
        System.out.println(Interface01.NAME);
        interface01.boom();
        interface01.sleep();


    }
}

interface Interface01 {
    /**
     * 定义接口，接口中的属性默认有 public static final
     * 方法默认有 public abstract
     */
    public static final String NAME = "炸弹人";

    public abstract void boom();


    public abstract void sleep();

}

interface Interface02 {
    String NAME = "薇薇安";

    void poor();

    void redMoon();

}

interface Interface03 extends  Interface01,Interface02 {
    /**
     * 接口与接口之间可以实现多继承
     */
    String NAME = "豆豆";

    void eat();
}


class Implements01 implements Interface01 {
    /**
     * 类实现接口 使用implements 关键词
     * 接口没有构造方法
     */
    @Override
    public void boom() {
        System.out.println("我是一个💣人，今天又炸了");
    }

    @Override
    public void sleep() {
        System.out.println("今天又是摸鱼的一天");
    }
}

class Implements02 implements Interface02,Interface03 {
    /**
     * 一个类可以实现多个接口
     */
    @Override
    public void poor() {
        System.out.println("今天又是吃不饱饭的一天");
    }

    @Override
    public void boom() {
        System.out.println("今天去炸哪里？");
    }

    @Override
    public void sleep() {
        System.out.println("摸鱼，逗🐶");
    }

    @Override
    public void eat() {
        System.out.println("我最喜欢吃筷子了");
    }

    @Override
    public void redMoon() {
        System.out.println("最穷的哪个女伯爵");
    }
}

