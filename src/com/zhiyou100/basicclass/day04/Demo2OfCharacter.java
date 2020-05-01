package com.zhiyou100.basicclass.day04;

/**
 * @packageName: javase_26
 * @className: Demo2OfCharacter
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/26 11:15 上午
 */
public class Demo2OfCharacter {
    public static void main(String[] args) {
        /**
         *  character 特有的方法
         *      static boolean	isDigit(char ch)     确定指定字符是否为数字。
         *      static boolean	isLetter(char ch)   确定指定字符是否为文字。
         *      static boolean	isLetterOrDigit(char ch) 确定指定字符是否为文字或数字。
         *      static boolean	isLowerCase(char ch) 确定指定字符是否为小写字母。
         *      static boolean	isUpperCase(char ch)   确定指定字符是否为大写字母。
         *      static boolean	isSpaceChar(char ch) 确定指定字符是否为 Unicode 空白字符 ' ','\r','\n','\t'。
         *      static char	toLowerCase(char ch) 使用取自 UnicodeData 文件的大小写映射信息将字符参数转换为小写。
         *      static char	toUpperCase(char ch)  使用取自 UnicodeData 文件的大小写映射信息将字符参数转换为大写。
         *
         */
         System.out.println(Character.isDigit('8'));
        System.out.println(Character.isLetter('羊'));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.isSpaceChar(' '));
        System.out.println("\n");
    }
}
