package com.zhiyou100.basicclass.day07.preview;

/**
 * @packageName: javase_26
 * @className: PreviewRegularExpressions02
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/28 5:48 下午
 */
public class PreviewRegularExpressions02 {
    public static void main(String[] args) {
        /*
        匹配规则
         */
        String re1="abc";
        System.out.println("abc".matches(re1));
        // true 正则 abc ,只能匹配 abc ，不能 Abc||abcd
        System.out.println("Abc".matches(re1));
        // false
        System.out.println("abcd".matches(re1));
        // false

        System.out.println("===================");

        String re2="a\\&c";
        System.out.println("a&c".matches(re2));
        // a\\&c \&是用来匹配特殊字符的，能匹配到 a&c,不能 a-c || a&&c
        System.out.println("a-c".matches(re2));
        System.out.println("a&&c".matches(re2));

        System.out.println("============");

        /*
         * 匹配任意字符
         *  A 匹配指定字符
         *  \u548c 匹配指定的Unicode字符
         *  . 匹配一个字符
         *  \d 匹配一个数字(0~9)
         *  \w 匹配一个字母、数字或下划线, ⚠️：不能匹配#、空等字符
         *  \s 匹配一个空格(不但包括" ",还包括\t)
         *  \D 非数字
         *  \W 非\w
         *  \S 非\s
         */
        String re3="java\\d";
        // 对应 java\d
        System.out.println("java9".matches(re3));
        System.out.println("java0".matches(re3));
        System.out.println("javac".matches(re3));
        System.out.println("=================");
        String re4="java\\D";
        // 对应 java\D
        System.out.println("javax".matches(re4));
        System.out.println("java#".matches(re4));
        System.out.println("java0".matches(re4));
        System.out.println("=================");
        /**
         * 重复匹配：
         *  * 匹配任意个字符，包括0
         *  + 匹配至少一个字符
         *  ? 匹配0或一个字符
         *  {n} 匹配n个字符
         *  {n,m} 匹配n~m个字符
         *  {n,} 匹配至少n个字符，没有上限
         */
        System.out.println(determineIfItIsTheAreaCode("0101-1234567"));
        System.out.println(determineIfItIsTheAreaCode("010-12345678"));
        System.out.println(determineIfItIsTheAreaCode("020-9999999"));
        System.out.println(determineIfItIsTheAreaCode("0755-7654321"));
        System.out.println(determineIfItIsTheAreaCode("010 12345678"));
        System.out.println(determineIfItIsTheAreaCode("A20-9999999"));
        System.out.println(determineIfItIsTheAreaCode("0755-7654.321"));

    }
    public static boolean determineIfItIsTheAreaCode(String s){
        /**
         * @name: determineIfItIsTheAreaCode
         * @param: String s
         * @date: 2020/2/28 6:17 下午
         * @return: boolean
         * @description: TODO 判断是不是区号 3~4位数字 - 7~8位电话
         */
        String re1="\\d{3,4}\\-\\d{7,8}";
        // 规则 ： \d{3,4} \- \d{7,8}
        return s.matches(re1);
    }
}
