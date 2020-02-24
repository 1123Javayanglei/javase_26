package com.zhiyou100.basicclass.day03;

/**
 * @packageName: javase_26
 * @className: Demo03OfString
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/24 10:18 上午
 */
public class Demo03OfString {
    public static void main(String[] args) {
        /**
         * 获取
         * int indexOf(char c): 获取当前字符串中参数字符第一此出现的位置
         * int
         * int indexOf(String s): 获取当前字符串中参数字串 S 第一此出现的位置
         * int indexOf(String  s，int formIndex): 从forIndex处开始，获取当前字符串中 字串S 第一此出现的位置
         * int lastIndexOf(char c): 倒着检索，获取当前字符串中参数字符第一此出现的位置
         * int lastIndexOf(char c,int formIndex):
         * int LastIndexOf(String s):
         * int LastIndexOf(String s,int formIndex):
         * ⚠️：当查找不到参数字符时，返回-1
         */
        String a="abcdefghijkkKKKKKKKK";
        System.out.println(a.indexOf('a'));
        // 0
        System.out.println(a.indexOf('c',1));
        // 2
        System.out.println(a.indexOf("cde"));
        // 2
        System.out.println(a.lastIndexOf('a'));
        // 0
        System.out.println(a.lastIndexOf('a',6));
        // 0
        System.out.println(a.lastIndexOf("ab"));
        // 0
        System.out.println(a.lastIndexOf("ab",6));
        // 0
        printIndex(a,'k');

    }
    public static void printIndex(String s,char c){
        /**
         * 把参数字符串中 参数字符出现的所有位置打印出来 Mark
         */
        int index=s.indexOf(s,c);
        for (int i=index; i <s.length() ; i+=index) {

        }
    }
}
