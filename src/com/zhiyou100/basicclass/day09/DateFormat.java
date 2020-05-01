package com.zhiyou100.basicclass.day09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @packageName: javase_26
 * @className: DateFormat
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/4 6:00 下午
 */
public class DateFormat {
    public static void main(String[] args) throws ParseException {
        /**
         * SimpleDateFormat 类
         *  作用 ：格式化日期为指定字符串
         *  使用：1、设定格式
         *       2、实现日期与指定格式的字符串之间的转换
         */
        Date date = new Date(0);
        String pattern="yyyy-MM-dd E HH:mm:ss";
        // 定义格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        // 创建simpleDateFormat对象
        System.out.println(simpleDateFormat.format(date));
        // 格式化日期
        // 1970-01-01 周四 08:00:00
        String dateDone="1970-01-01 周四 08:00:00";
        date=simpleDateFormat.parse(dateDone);
        // 把参数字符解析为日期对象，需要抛出 ParseException异常
        System.out.println(date.toLocaleString());
        // 1970年1月1日 上午8:00:00

    }
}
