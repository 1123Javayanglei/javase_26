package com.zhiyou100.basicclass.day09;

import java.util.Date;

/**
 * @packageName: javase_26
 * @className: ComparativeMethod
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/4 4:11 下午
 */
public class ComparativeMethod {
    public static void main(String[] args) {
        /**
         * 比较方法：
         *  boolean after(Date)
         *  boolean before(Date)
         *  int compareTo(Date)
         */
        Date date = new Date(2020 - 1970, 3 - 1, 3);
        // 昨天 2020-3-3
        Date date1 = new Date(2020 - 1970, 3 - 1, 4);
        // 今太 2020-3-4
        System.out.println(date.after(date1));
        // 昨天在今天之后 false
        System.out.println(date.before(date1));
        // 昨天在今天之前 true
        System.out.println(date.compareTo(date1));
        // 3-3.3-4 -> -1 昨天和今天相比 -1
        System.out.println(date1.compareTo(date));
        // 3-4.3-3 -> 1
    }
}
