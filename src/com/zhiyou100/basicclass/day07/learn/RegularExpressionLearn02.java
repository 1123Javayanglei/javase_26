package com.zhiyou100.basicclass.day07.learn;

/**
 * @packageName: javase_26
 * @className: RegularExpressionLearn02
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/29 5:31 下午
 */
public class RegularExpressionLearn02 {
    public static void main(String[] args) {
        String text="我是一个汉字1234abc";
        System.out.println(delAllChineseCharacters(text));
        System.out.println(delAllNumber(text));
    }
    public static String delAllNumber(String s){
        /**
         * 删除所有的数字
         */
        String regex="[0-9]+";
        return s.replaceAll(regex,"");
    }
    public static String delAllChineseCharacters(String s){
        // 替换所有汉字
        String regex="[\u4e08-\u9fa5]+";
        return s.replaceAll(regex,"-");
    }
}
