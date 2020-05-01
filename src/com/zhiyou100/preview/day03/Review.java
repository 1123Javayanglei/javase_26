package com.zhiyou100.preview.day03;

/**
 * @author yanglei
 * 数据类型：
 *  整数类型
 * byte 字节型 1字节 [-128,127]
 * short 短整型 2  [-32000,32000]
 * int   整形     4 整数默认int
 *
 *  浮点
 *  float 单精度 4 F/f
 *  double 双精度 8 默认是double
 *
 *  字符类型
 *  char 字符类型 2 必须写在单引号里，有且只有一个字符
 *
 *  布尔类型
 *  boolean 1 true / false
 *
 *  数据类型转换
 *
 *自动类型转换1：把低精度数据转换为高精度数据
 *格式：高精度变量 = 低精度数据;
 *
 *强制类型转化：把高精度数据转化为低精度数据
 *格式：低精度变量=(低精度变量类型)高精度数据;
 *
 *  自动类型转化2 ： 只适用于byte short char
 * 给byte short char类型的变量赋值int类型的常量值
 * 编译器自动检查 放的下就放，放不下就⚠️
 *
 *编码表:数字于字符之间转换的对应关系
 * 常见的编码表：ASCII iso-8859-1 utf-8 gbk gbk18030  gb2312
 * 记忆：a=97,A=65,0=48
 * 计算机只识别二进制：01 二进制和十进制可以互相转化
 */
public class Review {
    public static void main(String[] args) {
        byte b1=11;
        int il=11;
        b1=(byte)133;
        System.out.println(b1);
    }
}
