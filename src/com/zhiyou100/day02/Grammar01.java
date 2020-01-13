package com.zhiyou100.day02;

/**
 * @author yanglei
 */
public class Grammar01 {
    public static void main(String[] args) {
        float f1=11;
        /*
         *自动类型转换1：把低精度数据转换为高精度数据
         *格式：高精度变量 = 低精度数据;
         *  在内存中划分一块区域：区域类型float 大小4个字节 区域名字f1
         *  把int类型的4个字节的11 自动转化为float类型的4个字节的11.0f
         *  把float类型的11.0f赋值给float类型的变量f1
         */
        long l1=11;


        System.out.println(f1);
        System.out.println(l1);

        int i=(int)11.1;
        /*
         *强制类型转化：把高精度数据转化为低精度数据
         *格式：低精度变量=(低精度变量类型)高精度数据;
         *
         */
        System.out.println(i);

        byte b1=127;
        short s2=31111;

        /*
         *自动类型转化2 ： 只适用于byte short char
         * 给byte short char类型的变量赋值int类型的常量值
         * 编译器自动检查 放的下就放，放不下就⚠️
         */

        char c1=(97-32);
        /*
         *编码表:数字于字符之间转换的对应关系
         * 常见的编码表：ASCII iso-8859-1 utf-8 gbk gbk18030  gb2312
         * 记忆：a=97,A=65,0=48
         * 计算机只识别二进制：01 二进制和十进制可以互相转化
         */
        System.out.println(c1);

    }
}
