package com.zhiyou100.basicclass.day02;

/**
 * @packageName: javase_26
 * @className: Demo02OfSystem
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/21 10:59 上午
 */
public class Demo02OfSystem {
    public static void main(String[] args) {
        /**
         * 普通方法：
         * static long	currentTimeMillis() 返回当前时间（以毫秒为单位）。
         * (1970.01.01 0:00 --- 至今)
         */
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()/1000);
        System.out.println(System.currentTimeMillis()/1000/3600);
        System.out.println(System.currentTimeMillis()/1000/3600/24);
        System.out.println(System.currentTimeMillis()/1000/3600/24/365);

        /**
         * static void	gc() 运行垃圾回收器。
         *
         */


        /**
         * static void	exit(int status) 终止当前运行的Java虚拟机。
         * 输入 0，关闭虚拟机，非0是不正常的方式
         */
        System.exit(0);
        System.out.println(11);
        System.out.println(12);
    }
}
