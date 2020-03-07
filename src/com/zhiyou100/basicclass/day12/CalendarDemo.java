package com.zhiyou100.basicclass.day12;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;

import javax.sound.midi.SoundbankResource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @packageName: javase_26
 * @className: CalendarDemo
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/6 11:46 上午
 *
 * Calendar 类的方法:
 *  1 静态方法获取日历对象 static Calendar getInstance()
 *
 *  2 比较方法
 *      boolean after(object when) 判断当前Calendar对象是否在参数对象 之后
 *      boolean before(object when) 判断当前Calendar对象是否在参数对象 之前
 *      int compareTo(Calendar anotherCalendar) 当前日历对象大于参数对象，返回正数，小于返回负数，相等返回0
 *
 *  3 获取和设置方法
 *       int	get(int field)  返回给定日历字段的值。
 *        void	set(int field, int value) 将给定的日历字段设置为给定值。
 *         void	set(int year, int month, int date, int hourOfDay, int minute, int second) 设置字段 YEAR、MONTH、DAY_OF_MONTH、HOUR、MINUTE 和 SECOND 的值。
 *
 *  4 增量方法
 *      public abstract void add(int field,int amount) 根据日历的规则，为给定的日历字段添加或减去指定的时间量。
 *
 *  5 日历和日期相互转换
 *       Date	getTime() 返回一个表示此 Calendar 时间值（从历元至现在的毫秒偏移量）的 Date 对象。
 *        void	setTime(Date date) 使用给定的 Date 设置此 Calendar 的时间。
 *
 *
 */
public class CalendarDemo {
    public static void main(String[] args) throws ParseException {

//        System.out.println(calendar1);
        /*
         * Calendar 封装了与时间相关的所有参数
         * java.util.GregorianCalendar[time=1583466939471,
         * areFieldsSet=true,
         * areAllFieldsSet=true,
         * lenient=true,
         * zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",
         * offset=28800000,
         * dstSavings=0,
         * useDaylight=false,
         * transitions=29,
         * lastRule=null],
         * firstDayOfWeek=1,
         * minimalDaysInFirstWeek=1,
         * ERA=1,
         * YEAR=2020,
         * MONTH=2,
         * WEEK_OF_YEAR=10,
         * WEEK_OF_MONTH=1,
         * DAY_OF_MONTH=6,
         * DAY_OF_YEAR=66,
         * DAY_OF_WEEK=6,
         * DAY_OF_WEEK_IN_MONTH=1,
         * AM_PM=0,
         * HOUR=11,
         * HOUR_OF_DAY=11,
         * MINUTE=55,SECOND=39,
         * MILLISECOND=471,
         * ZONE_OFFSET=28800000,
         * DST_OFFSET=0]
         */
        // 获取当前时间描述的日历对象
        Calendar calendar1=Calendar.getInstance();
        // Calendar 是抽象方法，通过静态方法getInstance获取子类对象，来调用方法
        Calendar calendar2=Calendar.getInstance();
        System.out.println(calendar2.after(calendar1));
        // out true 判断calendar2是否在calendar1之后，因为calendar1先创建
        System.out.println(calendar1.before(calendar2));
        // out true 判断判断calendar1是否在calendar2之前，因为calendar1先创建
        System.out.println("=========");


        System.out.println("设置前 "+calendar1.getFirstDayOfWeek());
        // 1
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);
        // 设置一周从周一开始
        System.out.println("设置前 "+calendar1.getFirstDayOfWeek());
        // 2
        System.out.println("=============");


        int year=calendar1.get(Calendar.YEAR);
        // 获取年的字段
        System.out.println(year);
        // out 2020
        int dayOfWeek=calendar1.get(Calendar.DAY_OF_WEEK);
        // 范围(1,7) 一周从周日开始
        System.out.println(dayOfWeek);
        // 今天是周六 out 7
        System.out.println("============");

        calendar1.set(Calendar.YEAR,2023);
        // 设置年为2023年
        System.out.println(calendar1.get(Calendar.YEAR));
        // out 2023
        System.out.println(toCalendarString(calendar1));
        // out 2023-03-07 星期二 20:13:52

        calendar2.set(2001,11-1,23,12,12,0);
        // 月份要-1
        System.out.println(toCalendarString(calendar2));
        // out 2001-11-23 星期五 12:12:00

        calendar2.add(Calendar.YEAR,19);
        // 为calendar2的年字段增加19
        System.out.println(toCalendarString(calendar2));
        //out 2020-11-23 星期一 12:12:00
        System.out.println("============");

        Date date = calendar1.getTime();
        // 把calendar1转换为一个Date对象
        System.out.println(date.toLocaleString());
        // out 2023年3月7日 下午8:37:23

        Calendar calendar3=Calendar.getInstance();
        // 创建一个Calendar类型的变量 calendar3
        calendar3.setTime(date);
        // 用Date类型的date的毫秒值来设置calendar3
        System.out.println(toCalendarString(calendar3));
        //out 2023-03-07 星期二 20:42:07

        System.out.println("=========");
        System.out.println("非同一天内测试：");
        System.out.print(toCalendarString(calendar1));
        System.out.print("\t");
        System.out.println(getDays1(toCalendarString(calendar1)));
        System.out.print(toCalendarString(calendar2));
        System.out.print("\t");
        System.out.println(getDays1(toCalendarString(calendar2)));
        System.out.print(toCalendarString(calendar3));
        System.out.print("\t");
        System.out.println(getDays1(toCalendarString(calendar3)));

        System.out.println("=========");
        System.out.println("同一天内测试：");
        Calendar ca=Calendar.getInstance();
        System.out.print(toCalendarString(ca)+"\t");
        System.out.println(getDays1(toCalendarString(ca)));

    }
    public static String toCalendarString(Calendar calendar){
        /**
         * @name: toCalendarString
         * @param: Calendar calendar
         * @date: 2020/3/7 8:03 下午
         * @return: String
         * @description: TODO  写一个方法返回日历对象的字符串表示形式 xxxx-xx-xx 星期x xx:xx:xx
         */
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        // 一月是0 0,11
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK)-1;
        // 从周日开始
        int hours=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        int second=calendar.get(Calendar.SECOND);
        String week="日一二三四五六";
        String finalString=""+year+"-"+ HomeWorkOfMath.addZero(month)+"-"+HomeWorkOfMath.addZero(dayOfMonth)
                +" 星期"+week.charAt(dayOfWeek)+" "
                +HomeWorkOfMath.addZero(hours)+":"+HomeWorkOfMath.addZero(minute)+":"+HomeWorkOfMath.addZero(second);
        return finalString;
    }
    public static int getDays1(String into) throws ParseException {
        /**
         * @name: getDays
         * @param: Calendar calendar
         * @date: 2020/3/7 8:47 下午
         * @return: int
         * @description: TODO 获取参数日期和当前天数的差 xxxx-xx-xx xx:xx:xx
         */
        //1 格式化
        Date newDay=new Date();
        // 当前日期
        Date intoDate = new Date();
        String pattern="yyyy-MM-dd";
        // 定义模式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        // 创建format对象
        String newDone=simpleDateFormat.format(newDay);
        // 格式 xxxx-xx-xx
        newDay=simpleDateFormat.parse(newDone);
        // 去掉时分秒
        Date intoDay=simpleDateFormat.parse(formatString(into));
        // 把intoDay 也去零
        // 去零完成

        //2 转换为日历对象
        Calendar today=Calendar.getInstance();
        Calendar otherDay=Calendar.getInstance();
        today.setTime(newDay);
        otherDay.setTime(intoDay);
        // 转换完成

        //3 计算毫秒值
        return (int) ((Math.abs(today.getTimeInMillis()-otherDay.getTimeInMillis()))/(1000*3600*24));

    }
    public static String formatString(String string){
        /**
         * @name: formatString
         * @param: String sring
         * @date: 2020/3/7 9:07 下午
         * @return: String
         * @description: TODO 传入一个 xxxx-xx-xx xx:xx:xx 提取出 xxxx-xx-xx 不是两位的补零
         */
        int index1=string.indexOf('-');
        int index2=string.indexOf('-',index1+1);
        int index3=string.indexOf(' ',index2);
        int year= Integer.parseInt(string.substring(0,index1));
        int month= Integer.parseInt(string.substring(index1+1,index2));
        int day= Integer.parseInt(string.substring(index2+1,index3));
        return year+"-"+HomeWorkOfMath.addZero(month)+"-"+HomeWorkOfMath.addZero(day);
    }
}
abstract class MyCalendar{
    void he(){}
    void show(){}
    MyCalendar newInstance(){
        return new MkcalendarSon();
    }
}
class MkcalendarSon extends MyCalendar{
    @Override
    void he() {
        super.he();
    }

    @Override
    void show() {
        super.show();
    }

    @Override
    MyCalendar newInstance() {
        return super.newInstance();
    }
}