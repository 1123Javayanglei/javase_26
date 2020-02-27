package com.zhiyou100.basicclass.day05;

/**
 * @packageName: javase_26
 * @className: Demo02OfInnerClass
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/27 10:47 下午
 */
public class Demo02OfInnerClass {
    /**
     * 使用成员内部类
     *  1、直接
     *      公式 ：外.内
     *          外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();
     *  2、间接
     *      在外部类的方法中，使用内部类，然后main只是调用外部类的方法
     *
     * @param args
     */
    public static void main(String[] args) {
        Body body = new Body();
        // 外部类的对象
        body.methodBody();
        // 通过外部类的对象，调用外部类的方法，里面直接使用内部类Heat

        Body.Heart heart = new Body().new Heart();
        // 外.内
        heart.beat();

    }
}
