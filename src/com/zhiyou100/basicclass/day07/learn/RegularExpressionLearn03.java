package com.zhiyou100.basicclass.day07.learn;

import java.util.Arrays;

/**
 * @packageName: javase_26
 * @className: RegularExpressionLearn03
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/29 5:36 下午
 */
public class RegularExpressionLearn03 {
    public static void main(String[] args) {
        String test = "12343214uuuuuioo432432fadsfadsf,,,,,32432fdasf范德萨";
        System.out.println(Arrays.toString(replaceContinuousDigit(test)));
    }

    public static String[] replaceContinuousDigit(String s) {
        // 获取字符串中所有的连续的数字字符，使用非数字字符切割字符串
        String regex = "[^0-9]+";
        // 规则：非连续数字
        return s.split(regex);
    }
}
