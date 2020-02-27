package com.zhiyou100.basicclass.day05;

import edu.princeton.cs.algs4.In;

/**
 * @packageName: javase_26
 * @className: Outer01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/27 11:59 下午
 */
public class Outer01 {
    public void methodOuter01() {
        class Inner01 {
            // 局部内部类
            int num = 10;

            public void methodInner01() {
                System.out.println(num);
                // 10
            }
        }
        Inner01 inner01=new Inner01();
        inner01.methodInner01();
    }

}
