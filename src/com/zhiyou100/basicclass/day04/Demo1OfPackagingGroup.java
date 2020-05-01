package com.zhiyou100.basicclass.day04;

/**
 * @packageName: javase_26
 * @className: Demo1OfPackagingGroup
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/26 10:26 上午
 */
public class Demo1OfPackagingGroup {
    public static void main(String[] args) {
        // 属性
        System.out.println(Integer.MAX_VALUE);
        // 最大值
        System.out.println(Integer.MIN_VALUE);
        // 最小值
        System.out.println(Integer.BYTES);
        // 对应的字节数
        System.out.println(Integer.SIZE);
        // 对应的比特位
        System.out.println(Integer.TYPE);
        // 对应的基本数据类型
        System.out.println();
        System.out.println();

        //
        /**
         * 方法 字符串+常量值+包装类对象之间的相互转换
         *  1. 基本数据 -》 包装类对象
         *      1.1 构造方法 ： Integer(int)
         */
        int test1=123;
        Integer integer=new Integer(test1);
        System.out.println(integer);
        /**
         *      1.2 静态方法 static Integer valueOf(int)
         */
        integer=Integer.valueOf(18);
        System.out.println(integer);
        /**
         *      1.3 自动装箱：包装类引用 = 基本数据类型
         */
        integer=1234;
        System.out.println(integer);
        // 把int类型的常量值17 自动封装为Integer类型的对象
        /**
         *  2. 包装类对象 -》 基本数据类型
         *      2.1 int intValue();
         */
        test1=integer.intValue();
        System.out.println(test1);
        /**
         *      2.2 自动分箱
         *          基本数据变量 = 包装类对象
         */
        test1=integer;

        /**
         *  3.字符串 ——》 包装对象
         *      3.1 构造方法 Integer(String s)
         */
        integer=new Integer("126");
        // 字符串必须是数字字符串 ：否则异常 NumberFormatException
        System.out.println(integer);
        /**
         *      3.2 静态方法
         *          valueOf(String s)
         *          valueOf(String s,int radix) // radix 进制
         */
        integer=Integer.parseInt("123");
        System.out.println(integer);
        integer=Integer.valueOf("456");
        System.out.println(integer);
        integer=Integer.valueOf("110",8);
        // 获取8进制110对应的10进制数据
        System.out.println(integer);

        /**
         *  4. 包装类对象 -》 字符串
         *      4.1   String toString();
         *      4.2     +，字符串拼接
         */
        String s=integer.toString();
        System.out.println(s);
        s+=integer;
        System.out.println(s);
        /**
         *  5. 字符串 -》 基本数据类型
         *      5.1 static int	parseInt(String s)
         */
        test1=Integer.parseInt("201");
        System.out.println(test1);

        /**
         *  6. 基本数据 -》 字符串
         *      6.1 连接符 ：连接空字符串""
         *      6.2 静态方法：
         *          static String	toBinaryString(int i) 以二进制（基数 2）无符号整数形式返回一个整数参数的字符串表示形式。
         *          static String	toHexString(int i) 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式。
         *          static String	toOctalString(int i)以八进制（基数 8）无符号整数形式返回一个整数参数的字符串表示形式。
         *          static String	toString(int i) 返回一个表示指定整数的 String 对象。
         *          static String	toString(int i, int radix) 返回用第二个参数指定基数表示的第一个参数的字符串表示形式。
         *
         */
        System.out.println(Integer.toBinaryString(20));
        System.out.println(Integer.toHexString(20));
        System.out.println(Integer.toOctalString(20));

        System.out.println(Integer.toString(11));
        System.out.println(Integer.toString(11,2));



    }
}
