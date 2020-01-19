package com.zhiyou100.day03;

public class YuFa05_Operator {

	public static void main(String[] args) {
		System.out.println("测试&&双与---");
		System.out.println("true&&true="+(true&&true));//true
		System.out.println("true&&false="+(true&&false));//false
		System.out.println("false&&true="+(false&&true));//false
		System.out.println("false&&false="+(false&&false));//false
		System.out.println("测试&单与---");
		System.out.println("true&true="+(true&true));//true
		System.out.println("true&false="+(true&false));//false
		System.out.println("false&true="+(false&true));//false
		System.out.println("false&false="+(false&false));//false
		
		System.out.println("测试||双与---");
		System.out.println("true||true="+(true||true));//true
		System.out.println("true||false="+(true||false));//true
		System.out.println("false||true="+(false||true));//true
		System.out.println("false||false="+(false||false));//false
		System.out.println("测试|单与---");
		System.out.println("true|true="+(true|true));//true
		System.out.println("true|false="+(true|false));//true
		System.out.println("false|true="+(false|true));//true
		System.out.println("false|false="+(false|false));//false
		
		System.out.println("测试^异或---");
		System.out.println("true^true="+(true^true));//false
		System.out.println("true^false="+(true^false));//true
		System.out.println("false^true="+(false^true));//true
		System.out.println("false^false="+(false^false));//false
		System.out.println("测试!取反--");
		System.out.println("!true="+(!true));//false
		System.out.println("!false="+(!false));//true
		
		
		System.out.println("测试位运算符");
		System.out.println("19&5="+(19&5));//1
		System.out.println("19|5="+(19|5));//23
		System.out.println("19^5="+(19^5));//22
		System.out.println("9>>2="+(9>>2));//2    1001右移2位  等价于删除后两位
		System.out.println("9<<2="+(9<<2));//36   1001左移2位 等价于右边加两个零100100
		//19的二进制：
		//1234=1*1000+2*100+3*10+4*1
		//19=16+2+1=10000+10+1=10011
		//9=8+1=1001
		//5=4+1=101
		
		System.out.println("测试三元表达式：：：：");
		System.out.println(1>2?3:4);
		int i=(3<=4?6:7);
		
		int a=3;int b=5;int c=9;
		int max=a>b?a:b;//求两个数中的大值
		System.out.println("max="+max);//max=5
		//a=3,b=5,max=5
		System.out.println("a="+a+",b="+b+",max="+max);
		
		//求三个数中的大值
		//先获取a和b的大值  然后拿此大值与c作比较即可
		max=a>b?a:b;
		max=max>c?max:c;
		//a=?,b=?,c=?,最大值是?
		System.out.println("a="+a+",b="+b+",c="+c+",最大值是"+max);
		
		max=((a>b&&a>c)?a:(b>c?b:c));
		max=(a>b)?(a>c?a:c):(b>c?b:c);
		
		

	}

}
