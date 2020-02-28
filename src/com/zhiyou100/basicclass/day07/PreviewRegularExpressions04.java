package com.zhiyou100.basicclass.day07;


import com.zhiyou100.basicclass.day02.HomeWorkOfMath;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName: javase_26
 * @className: PreviewRegularExpressions04
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/28 9:45 下午
 */
public class PreviewRegularExpressions04 {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher matcher=pattern.matcher("010-12345678");
        if (matcher.find()){
            String string1=matcher.group(1);
            String string2=matcher.group(2);
            System.out.println(string1);
            System.out.println(string2);
        }
        System.out.println(matcher);
        System.out.println("============");
        String test1="223.5.5.5\n" +
                "223.6.6.6\n" +
                "2400:3200::1\n" +
                "2400:3200:baba::1\n" +
                "119.29.29.29\n" +
                "182.254.116.116\n" +
                "202.102.224.68\n" +
                "180.76.76.76\n" +
                "2400:da00::6666\n";
        Pattern pattern1=Pattern.compile("(\\d{3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})");
        // 3.1~3.1~3.1~3 获取
        Matcher matcher1=pattern1.matcher(test1.trim());
        while (matcher1.find()){
            System.out.println(matcher1.group());
        }
        System.out.println("=======");
        /**
         * 练习 从"23:01:59"提取时、分、秒
         */
        String test3= HomeWorkOfMath.randomDate().substring(11,19);
        System.out.println("time= "+test3);
//        test3="23:01:59";
        Pattern pattern2=Pattern.compile("([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])");
        // 匹配 [0-1][0-9]|2[0-3] : [0-5][0-9] : [0-5][0-9]
        Matcher matcher2=pattern2.matcher(test3);
        while (matcher2.find()){
            System.out.println(matcher2.group());
            System.out.println("时："+matcher2.group(1));
            System.out.println("分："+matcher2.group(2));
            System.out.println("秒："+matcher2.group(3));
        }
    }
}