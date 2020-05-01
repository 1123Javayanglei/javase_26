package com.zhiyou100.basicclass.day07.learn;

import java.util.regex.Pattern;

/**
 * @packageName: javase_26
 * @className: RegularExpressionLearn01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/29 4:33 下午
 */
public class RegularExpressionLearn01 {
    public static void main(String[] args) {
        System.out.println(illegitimate("15238159262"));
        System.out.println(isUserName("F4fa624"));
        System.out.println(isMailbox("yanglei20011123@163.com"));
    }
    public static boolean illegitimate(String s){
        /**
         * @name: illegitimate
         * @param: String s
         * @date: 2020/2/29 4:35 下午
         * @return: boolean
         * @description: TODO 判断是不是手机号码 1、11位数字 2、13|14|15|16|17|18|19开头
         */
        String regex="^1[3-9]\\d{9}$";
        // 定义规则
        return s.matches(regex);
        // 使用string类的matches方法判断
    }
    public static boolean isUserName(String s){
        /**
         * @name: isUserName
         * @param: String s
         * @date: 2020/2/29 4:35 下午
         * @return: boolean
         * @description: TODO 判断是不是用户名 规则：6～8位，由数字、字母组成，必须第一个是字母
         */
        String regex="^[A-Z[a-z]][a-z[A-Z][0-9]]{5,7}$";
        // 定义规则
        return s.matches(regex);
        // 使用string类的matches方法判断
    }
    public static boolean isMailbox(String s){
        /**
         * @name: isItAMailbox
         * @param: String s
         * @date: 2020/2/29 4:35 下午
         * @return: boolean
         * @description: TODO 判断是不是邮箱 规则：多个任意字符@公司域名.com/.cn/.eq.com.cn
         */
        String regex="^\\w+@\\w+\\.(com|cn|eq|com.cn|qq)$";
        // 定义规则
        return s.matches(regex);
        // 使用string类的matches方法判断
    }
}
