package com.zhiyou100.basicclass.day03;

/**
 * @packageName: javase_26
 * @className: Demo04OfString
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/24 10:44 上午
 */
public class Demo04OfString {
    public static void main(String[] args) {
        /**
         * 转换相关的方法：：：（字符串对象是常量：字符串对象一旦创建 字符序列不能更改）
         *  String	concat(String str) 将指定字符串连接到此字符串的结尾。
         *   String	replace(char oldChar, char newChar) 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
         * String	toLowerCase() 使用默认语言环境的规则将此 String 中的所有字符都转换为小写。
         *  String	toLowerCase(Locale locale) 使用给定 Locale 的规则将此 String 中的所有字符都转换为小写。
         *  String	toUpperCase() 使用默认语言环境的规则将此 String 中的所有字符都转换为大写。
         *  String	toUpperCase(Locale locale) 使用给定 Locale 的规则将此 String 中的所有字符都转换为大写。
         * String	trim() 返回字符串的副本，忽略前导空白和尾部空白。
         */
        System.out.println("123".concat("abd"));
        // 等价于 +
        System.out.println("abcfsaabcabcdfaabc".replace('a','-'));
        System.out.println("abcfsaabcabcdfaabc".replace("abc","🚶"));
        System.out.println("fdsaf".toUpperCase());
        System.out.println("ADFDS".toLowerCase());
        System.out.println("  adfadsf  ".trim());


    }
}
