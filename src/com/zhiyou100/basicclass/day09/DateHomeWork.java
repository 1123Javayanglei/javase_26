package com.zhiyou100.basicclass.day09;


import com.zhiyou100.basicclass.day02.HomeWorkOfMath;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @packageName: javase_26
 * @className: DateHomeWork
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/4 6:19 下午
 */
public class DateHomeWork {
    public static void main(String[] args) throws ParseException {
        Date date = new Date(0);
        System.out.println(todayToDate(date));
        System.out.println();
        Date date1 = new Date(2023 - 1900, 6 - 1, 1);
        System.out.println("专升本考试 "+date1.toLocaleString());
        System.out.println(todayToDate(date1));
        System.out.println();
        Date date2 = new Date(2001 - 1900, 11 - 1, 23);
        System.out.println("出生日期 "+date2.toLocaleString());
        System.out.println(todayToDate(date2));
        System.out.println();


    }

    public static long todayToDate(Date date) throws ParseException {
        /**
         * @name: theDifferenceBetweenTheParameterDateAndTheCurrentDate
         * @param: Date date
         * @date: 2020/3/4 6:21 下午
         * @return: long
         * @description: TODO 参数日期和当前时间的天数 格式: xxxx-xx-xx xx:xx:xx
         */
        Date todayDate = new Date();
        // 当前日期
        String pattern = "yyyy-MM-dd";
        // 定义模式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        // 创建对象
        String todayDone = simpleDateFormat.format(todayDate);
        todayDate = simpleDateFormat.parse(todayDone);
        String dateDone = simpleDateFormat.format(date);
        date = simpleDateFormat.parse(dateDone);
        // 完成去掉 时、分、秒的任务
        long dateFlag = todayDate.compareTo(date);
        // 记录哪个日期大
        long today = (cntTwoYear(0, todayDate.getYear() + 1900)) + (cntMonthDay(todayDate.getYear() + 1900, todayDate.getMonth() + 1)) + (todayDate.getDate());
        // 从公元元年到今天的天数
        long dateDay = (cntTwoYear(0, date.getYear() + 1900)) + (cntMonthDay(date.getYear() + 1900, date.getMonth() + 1)) + (date.getDate());
        //从公元元年到参数日期的天数

        if (dateFlag < 0) {
            /**
             * 当前 -> 参数
             * 参数日期-当前日期
             */
            System.out.println("今天 距离 "+dateDone+" 还有 "+(dateDay-today)+" 天");
            return dateDay - today;

        } else if (dateFlag > 0) {
            /**
             *  参数 -> 当前
             *  当前-参数
             */
            System.out.println("今天 距离 "+dateDone+" 已经过去 "+(today-dateDay)+" 天了");
            return today - dateDay;
        } else {
            // 当前日期等于 参数日期
            return 0;
        }
    }

    public static long cntMonthDay(long year, long month) {
        /**
         * @name: cntMonthDay
         * @param: long year,long month
         * @date: 2020/3/4 7:23 下午
         * @return: long
         * @description: TODO 计算在本年中，从1月到(本月-1)有多少天
         */
        long sumDay = 0;
        for (long i = 1; i < month; i++) {
            // 判断在本年中本月有多少天
            sumDay += HomeWorkOfMath.judgeTheDaysOfTheMonth(year, i);
        }
        return sumDay;
    }

    public static long cntTwoYear(long start, long end) {
        /**
         * @name: cntTwoYear
         * @param: long start,long end
         * @date: 2020/3/4 7:14 下午
         * @return: long
         * @description: TODO 从start年到end-1年有多少天
         */
        long sumDay = 0;
        for (long i = start; i < end; i++) {
            if (judgeTheLeapYearOfTheYear(i)) {
                // 是闰年+=366
                sumDay += 366;
            } else {
                // 是平年+=365
                sumDay += 365;
            }
        }
        return sumDay;
    }

    public static boolean judgeTheLeapYearOfTheYear(long year) {
        /**
         * @name: judgeTheLeapYearOfTheYear
         * @param: long year
         * @date: 2020/3/4 7:15 下午
         * @return: boolean
         * @description: TODO 判断是不是闰年，是返回true，不是返回false
         */
        /**
         * 闰年 2月29 一年366
         * 平年 2月28 一年365
         * 公元年分除以4可整除但除以100不可整除，为闰年。 公元年分除以400可整除，为闰年。
         */
        boolean yearLag = (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
        // true 是闰年，false是平年
        if (yearLag) {
            return true;
        } else {
            return false;
        }
    }
}
