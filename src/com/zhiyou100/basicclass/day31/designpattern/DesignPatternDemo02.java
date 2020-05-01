package com.zhiyou100.basicclass.day31.designpattern;

/**
 * @packageName: javase_26
 * @className: DesignPatternDemo02
 * @Description: TODO 单例模式 类只能创建一个对象
 * @author: YangLei
 * @date: 2020/4/13 4:06 下午
 */
public class DesignPatternDemo02 {
    public static void main(String[] args) {

        Single single=Single.newObject();
        System.out.println(single);
        System.out.println(single.hashCode());
        // com.zhiyou100.basicclass.day31.designpattern.Single@72ea2f77
        // 1927950199

        Single single1=Single.newObject();
        System.out.println(single1);
        System.out.println(single1.hashCode());
        // com.zhiyou100.basicclass.day31.designpattern.Single@72ea2f77
        // 1927950199

        Single single2=Single.newObject();
        System.out.println(single2);
        System.out.println(single2.hashCode());
        // com.zhiyou100.basicclass.day31.designpattern.Single@72ea2f77
        // 1927950199



    }
}

class Single {
    /**
     * 饿汉模式
     * <p>
     * 构造方法私有化
     */
    private Single() {

    }

    /**
     * 定义一个私有的静态成员变量，记录唯一的对象
     */
    private static Single single = new Single();

    /**
     * 提供一个静态方法返回此单例对象
     */
    public static Single newObject() {
        return single;
    }

}

class Single1 {
    /**
     * 懒汉模式
     * <p>
     * 构造方法私有化
     */
    private Single1() {

    }

    /**
     * 定义一个私有的静态成员变量，记录唯一的对象
     */
    private static Single1 single;

    /**
     * 提供一个静态方法返回此单例对象
     */
    public static Single1 newObject() {
        if (single == null) {
            single = new Single1();
        }
        return single;
    }

}

