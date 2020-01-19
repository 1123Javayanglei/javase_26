package com.zhiyou100.day02;

public class YuFa02_TypeChange {

	public static void main(String[] args) {
		//数据类型转换：
		//数据类型精度表：double > float >long > int(char) > short > byte
		//什么类型的变量就只能赋值什么类型的值：：：变量赋的值的类型必须和变量的类型一致
		float f1=11;
		//1 在内存中划分一块区域：区域类型float 区域大小4个字节 区域名字f1
		//2 把int类型4个字节的11  自动转换为float类型4个字节的11.0f
		//3 把float类型的11.0f 赋值给float类型的变量f1

		//自动类型转换情况一：编译器自动把低精度数据 转换为高精度数据
		//格式： 高精度变量=低精度数据;
		long l1=11;
		double d1=1.1f;
		d1=1;
		d1=f1;
		System.out.println(f1);//11.0f
		
		//强制类型转换：把高精度数据强制转换为低精度数据
		//格式：低精度变量=(低精度变量的类型)高精度数据;
		int i=(int)11.1;
		System.out.println(i);//11
		float f2=11.1f;
		f2=(float)11.1;
		
		//自动类型转换情况二：只适用于byte short char
		//给byte short char类型的变量赋值int类型的常量值  会自动检查 装的下就装 装不下就报错
		byte b1=11;//byte范围：[-128,127]
		short s2=-31111;
		char c1=30007;// 把编码表中30007对应的字符赋值给变量c1
		System.out.println(c1);
		System.out.println((int)'男');
		//计算机只识别二进制：01  二进制和十进制之间可以相互转换
		//0001  0010  0011 0100 0101 0110 0111 1000 1001 1010
		//编码表：数字与字符之间转换的对应关系
		//常见的编码表：ASCII iso-8859-1 utf-8  gbk gb18030 gb2312
		
		
		//记住常用的三个字符的整数
		System.out.println((int)'0');//48
		System.out.println((int)'a');//97
		System.out.println((int)'A');//65
		
		
		
		

	}

}
