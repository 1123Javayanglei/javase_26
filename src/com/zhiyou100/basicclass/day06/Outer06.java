package com.zhiyou100.basicclass.day06;

/**
 * @packageName: javase_26
 * @className: Outer06
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/28 11:21 上午
 */
public class Outer06 {
    public static void main(String[] args) {
        // 匿名
        new Outer05() {

            @Override
            public void method01() {
                System.out.println("没有名字 A");
            }

            @Override
            public void method02() {
                System.out.println("没有名字 B");
            }
        }.method01();
        new  Outer05() {

            @Override
            public void method01() {
                System.out.println("没有名字 A");
            }

            @Override
            public void method02() {
                System.out.println("没有名字 B");
            }
        }.method02();
        System.out.println("================");
        // 有名字
        Outer05 outer05 = new Outer05(){

            @Override
            public void method01() {
                System.out.println("有名字 A");
            }

            @Override
            public void method02() {
                System.out.println("有名字 B");
            }
        };
        outer05.method01();
        outer05.method02();


    }
}
class Outer05Implements implements Outer05{

    @Override
    public void method01() {

    }

    @Override
    public void method02() {

    }
}
