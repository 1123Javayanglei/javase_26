package com.zhiyou100.review.oop.day04.test02;

import com.zhiyou100.review.oop.day04.test.Test01;
// 当引用到其他包中的类的时候，要用 import 引入

/**
 * @author yanglei
 * 在其他包中创建一个，继承于Test01的子类 ——> Test03
 *
 * 其他包的子类可以访问到受保护的和公共的
 */
public class Test03 extends Test01 {
    public static void main(String[] args) {
        Test03 test01 = new Test03();
        System.out.println(test01.protectedField+" "+test01.publicField);

    }
}
