package com.zhiyou100.basicclass.day04;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName: javase_26
 * @className: Demo03OfTest
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/26 11:30 上午
 */
public class Demo03OfTest {
    public static void main(String[] args) {


    }

    public static String upToLowAndLowToUpAndDelNumber(String s) {
        /**
         * @name: upToLowAndLowToUpAndDelNumber
         * @param: String s
         * @description: TODO 大写转小写，小写转大写，删除数字
         * @date: 2020/2/26 1:12 下午
         * @return:
         */
        String newString = "";
        // 创建一个新的String，放操作后的字符
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            // 提取处字符
            if (Character.isUpperCase(tmp)) {
                // 如果是大写，转为小写
                newString += Character.toLowerCase(tmp);
            } else if (Character.isLowerCase(tmp)) {
                // 如果是小写，转为大写
                newString += Character.toUpperCase(tmp);
            } else if (Character.isDigit(tmp)) {
                //如果是数字，不操作
            } else {
                // 其他情况不操作
                newString += tmp;
            }
        }
        return newString;
    }

    public static int[] intoOneStringOutOneIntArray(String s) {
        /**
         * @name: intoOneStringOutOneIntArray
         * @param: String s
         * @description: TODO 由参数字符串获取一个int数组（所有相连接的数字字符）"123mbk98--7m66uyt120"---[123,98,7,66,120]
         * @date: 2020/2/26 1:20 下午
         * @return: return int[]
         */
        String s1 = "";
        // 创建一个字符串放每个 数字子串
        Pattern p = Pattern.compile("\\d+");
        // 正则匹配 所有数字
        Matcher m = p.matcher(s);
        while (m.find()) {
            // 查找
            s1 += m.group() + " ";
            // 加上一个空格（方便切割），赋给s1 字符串
        }
        String[] strings = (s1).split(" ");
        // 用" "，切割，组成新的字符串数组
        int[] arr = new int[strings.length];
        //生成int数组，放处理完成的数字串
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i].trim());
            // 字符串去掉空格后赋值
        }
        return arr;
    }

    public static int myParseInt(String s) {
        boolean loadTag = true;
        for (int i = 0; i < s.length(); i++) {
            char tem = s.charAt(i);
            boolean numberTag = Character.isDigit(tem);
            // 判断是不是全是数字
            if (!numberTag) {
                //若有一个不是数字
                loadTag = false;
                break;
            }
        }
        if (!loadTag) {
            System.err.println("必须全部是数字");
            System.exit(0);
        }
        s = s.trim();
        // 去掉空白
        char[] charArray = s.toCharArray();
        // 用s创建一个字符数组
        int intFinal = 0;
        for (int i = charArray.length - 1, ten = 1; i >= 0; i--, ten *= 10) {
            // 从个位开始遍历
            int tem = (((int) (charArray[i]) - '0'));
            intFinal += tem * ten;
        }
        return intFinal;
    }

    public static double myParseDouble(String s) {
        /**
         * @name: myParseDouble
         * @param: String s
         * @description: TODO  参数字符转为double
         * @date: 2020/2/26 6:41 下午
         * @return: double
         */
        s = s.trim();
        // 先去空格
        boolean isDecimalPoint = s.contentEquals(".");
        // 判断有没有小数点
        if (!isDecimalPoint) {
            // 有小数点的,分为小数点前面的和小数点后面的
            String s1=s.substring(0,s.indexOf("."));
            String s2=s.substring(s.indexOf(".")+1,s.length());
            double positiveNumber=myParseInt(s1);
            double minus=intToDouble(s2);
            return positiveNumber+minus;
        } else {
            // 没有小数点的
            return (double) (myParseInt(s));
        }
    }
    public static double intToDouble(String s){
        /**
         * @name: intToDouble
         * @param:        String s
         * @description: TODO  把一个int转换为对应的double
         * @date: 2020/2/26 7:11 下午
         * @return: double
        */
        int original=myParseInt(s);
        // 转为int
        int tmp=0;
        int temp=original;
        while (original>0){
            // 判断位数
            original/=10;
            tmp++;
        }
        return (temp*Math.pow(10,-tmp));
        // 12345*(10^(-5)) = 0.12345
    }
}
