package com.zhiyou100.basicclass.day24;

/**
 * @packageName: javase_26
 * @className: TheadDemo3
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/24 4:09 下午
 */
public class TheadDemo3 {
    public static void main(String[] args) {
        System.out.println("main start.....");
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("thread run......");
                System.out.println("thread end...");
            }
        };
        thread.start();
        System.out.println("main end...");
    }
}
