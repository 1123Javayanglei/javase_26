package com.zhiyou100.basicclass.day09;

/**
 * @packageName: javase_26
 * @className: Demo
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/5 10:44 上午
 */
public class Demo {
     class Father{
         void  method(){

         }
    }
    class Son extends Father{
//        @Override
        void method() {
            super.method();
        }
    }
}
