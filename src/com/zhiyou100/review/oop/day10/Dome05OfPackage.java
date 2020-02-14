package com.zhiyou100.review.oop.day10;
import java.lang.*;
/**
 * @packageName: javase_26
 * @className: Dome05OfPackage
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/14 9:57 下午
 */
public class Dome05OfPackage {
    public static void main(String[] args) {
        /**
         * 包 ：类似于文件夹
         *  作用 ：对源文件进行分类管理
         *
         *  package ：必须是当前源文件的第一个语句
         *
         *
         * import :引入
         *  用于声明引入其他包的类
         *
         *  使用其他包中的类 两种方式：
         *   1 通过类的全称呼
         *   2 在当前包中调用时，包名是可以省略的
         */
        Dome dome01=new Dome();
        com.zhiyou100.review.oop.day10.Dome dome02=new com.zhiyou100.review.oop.day10.Dome();

        Father01 father01=new Father01();
        // 通过 import关键字来引入其他包中的类，直接使用包名

    }
}
class Dome{
    /**
     * 此类不叫 Dome 而是 package com.zhiyou100.review.oop.day10.Dome
     *
     * 在当前包中调用时，包名是可以省略的
     */
}