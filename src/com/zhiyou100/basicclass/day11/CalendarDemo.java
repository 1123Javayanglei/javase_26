package com.zhiyou100.basicclass.day11;

import java.util.Calendar;

/**
 * @packageName: javase_26
 * @className: CalendarDemo
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/6 11:46 上午
 */
public class CalendarDemo {
    public static void main(String[] args) {
        // 获取当前时间描述的日历对象
        Calendar calendar=Calendar.getInstance();
        // Calendar 是抽象方法，通过静态方法getInstance获取子类对象，来调用方法
        System.out.println(calendar);
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