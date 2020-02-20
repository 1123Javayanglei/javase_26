package com.zhiyou100.oop.day04.test;

/**
 * @author yanglei
 */
public class Test02 {
    /**
     * 在test02中访问test01中的属性，需要创建test1的对象
     *
     * 在同一个包中
     * 除了private不可以，其他都可以
     */
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(" "+test01.field+" "+test01.protectedField+" "+test01.publicField);

    }
}
