package com.zhiyou100.basicclass.day07;

/**
 * @packageName: javase_26
 * @className: PreviewRegularExpressions01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/28 5:33 下午
 */
public class PreviewRegularExpressions01 {
    public static void main(String[] args) {
        System.out.println(isValidMobileNumber( "17638733475"));
        System.out.println(isItTheRightYear("2001"));
    }
    public static boolean isItTheRightYear(String s){
        /*
         * @name: isItTheRightYear
         * @param: String s
         * @date: 2020/2/28 5:42 下午
         * @return: boolean
         * @description: TODO 判断输入的年份是不是 20##
         */
        /*
          20## 一共有4个字符 ： 2、0、0～9、0～9
          对应的正则表达式规则：20\d\d, "\d"表示一个数字
          注意：Java中用 "\\" 表示"\"
          转换成Java的正则就是 20\\d\\d
         */
        String regex="20\\d\\d";
        return s.matches(regex);
    }
    public static boolean isValidMobileNumber(String s){
        /**
         * @name: isValidMobileNumber
         * @param:        String s
         * @description: TODO  判断一个字符串是不是一个11位的手机号
         * @date: 2020/2/28 5:35 下午
         * @return: boolean
        */
        return s.matches("\\d{11}");
    }
}
