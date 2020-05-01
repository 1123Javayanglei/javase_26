package com.zhiyou100.basicclass.day09;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;

import java.util.Date;

/**
 * @packageName: javase_26
 * @className: GetAndSetDataClass
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/4 4:47 下午
 */
public class GetAndSetDataClass {
    public static void main(String[] args) {
        /**
         * get and set 方法
         *  get
         */
        Date date = new Date(0);
        System.out.println(date);
        // Thu Jan 01 08:00:00 CST 1970 ---> 1970-1-1 08:00:00
        System.out.println(date.getYear());
        // 70 返回对应年份-1900
        System.out.println(date.getYear()+1900);
        // 1970
        System.out.println(date.getMonth());
        // 0 返回对应月份-1
        System.out.println(date.getMonth()+1);
        // 1
        System.out.println(date.getDate());
        // 1 返回对应月份的某一天
        System.out.println(date.getDay());
        // 4 返回对应星期的某一天 注意：从周日开始 (0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 = Saturday)
        System.out.println(date.getHours());
        // 返回小时
        System.out.println(date.getMinutes());
        // 返回分
        System.out.println(date.getSeconds());
        // 返回秒
        System.out.println("===============");
        // 通过 set方法设置时间为当前时间
        date.setYear(2020-1900);
        date.setMonth(3-1);
        date.setDate(4);
        date.setHours(17);
        date.setMinutes(07);
        date.setSeconds(03);
        System.out.println(date);
        // Wed Mar 04 17:07:03 CST 2020 -> 2020-3-4 周3 17:07:03
        System.out.println(dateToString(date));
    }
    public static String dateToString(Date date){
        /**
         * @name: dateToString
         * @param: Date date
         * @date: 2020/3/4 5:14 下午
         * @return: String
         * @description: TODO 转换日期为字符串：xxxx-xx-xx 星期x xx:xx:xx
         */
        int year=(date.getYear()+1900);
        String month=HomeWorkOfMath.addZero((date.getMonth()+1));
        String data=HomeWorkOfMath.addZero(date.getDate());
        String dayString="日一二三四五六";
        char day=dayString.charAt(date.getDay());
        String hour=HomeWorkOfMath.addZero(date.getHours());
        String minute=HomeWorkOfMath.addZero(date.getMinutes());
        String second=HomeWorkOfMath.addZero(date.getSeconds());
        return year+"-"+month+"-"+data+" 星期"+day+" "+hour+":"+minute+":"+second;
    }
}
