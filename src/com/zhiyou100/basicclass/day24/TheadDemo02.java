package com.zhiyou100.basicclass.day24;

/**
 * @packageName: javase_26
 * @className: TheadDemo02
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/24 11:32 上午
 */
public class TheadDemo02 {
    public static void main(String[] args) {
        /**
         * 创建一个类基础Thread
         * 重写run方法
         * 创建子类对象
         * 启动线程
         */
        Thread thread = new Thread(()->{
            System.out.println("start new thread!");
        });

        thread.start();
        // start new thread!

    }
}