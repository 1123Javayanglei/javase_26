package com.zhiyou100.basicclass.day09;

import java.util.Date;

/**
 * @packageName: javase_26
 * @className: DateToSting
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/4 5:40 下午
 */
public class DateToSting {
    public static void main(String[] args) {
        /**
         * String toLocaleString()
         *  获取当前操作系统的本地时间格式
         */
        Date date = new Date(0);
        System.out.println(date.toString());
        // Thu Jan 01 08:00:00 CST 1970
        System.out.println(date.toLocaleString());
        // 1970年1月1日 上午8:00:00
    }
}
