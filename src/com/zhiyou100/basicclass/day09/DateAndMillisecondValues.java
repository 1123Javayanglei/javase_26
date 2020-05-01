package com.zhiyou100.basicclass.day09;

import java.util.Date;

/**
 * @packageName: javase_26
 * @className: DateAndMillisecondValues
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/4 5:31 下午
 */
public class DateAndMillisecondValues {
    public static void main(String[] args) {
        /**
         * 日期和毫秒值之间转换
         * long getTime() 获取当前时间对象的毫秒值（相对于历元）
         * void SetTime(long time) 设置当前时间对象的毫秒值
         */
        Date date = new Date(2020 - 1900, 3 - 1, 4);
        System.out.println(GetAndSetDataClass.dateToString(date));
        // 2020-03-04 星期三 00:00:00
        System.out.println(date.getTime());
        // 获取毫秒值(对于历元)  1583251200000
        System.out.println(date.getTime()/1000/3600/24/365.0);
        // 50.20

        date.setTime(0);
        System.out.println(GetAndSetDataClass.dateToString(date));
        // 1970-01-01 星期四 08:00:00
    }
}
