package com.zhiyou100.basicclass.day09;

import java.util.Date;

/**
 * @packageName: javase_26
 * @className: DataClass
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/4 3:45 下午
 */
public class DataClass {
    public static void main(String[] args) {
        /**
         * 1.构造方法
         *      Date()
         *      Date(long date)
         *      Date(int year,int
         */
        Date date = new Date();
        System.out.println(date);
        // Wed Mar 04 15:49:53 CST 2020 当前时间
        Date date1 = new Date(1000000000);
        System.out.println(date1);
        // Mon Jan 12 21:46:40 CST 1970 从标准基准时间（称为“历元（epoch）”，即 1970 年 1 月 1 日 00:00:00 GMT）以来的指定毫秒数。
        Date date2 = new Date(0);
        System.out.println(date2);
        // Thu Jan 01 08:00:00 CST 1970 原因：东八区
        Date date3 = new Date(2020, 3, 4);
        System.out.println(date3);
        // Sun Apr 04 00:00:00 CST 3920
        Date date4= new Date(2020-1900, 3-1, 4);
        System.out.println(date4);
        // Wed Mar 04 00:00:00 CST 2020 使用时，年-1900，月份-1


    }
}
