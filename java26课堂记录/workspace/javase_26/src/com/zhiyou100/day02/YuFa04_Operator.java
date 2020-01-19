package com.zhiyou100.day02;

public class YuFa04_Operator {

	public static void main(String[] args) {
		//+：：加法运算
		System.out.println(1+1);
		byte b1=11;
		byte b2=(byte)(b1+b1);//1： byte short char不能直接参加运算  必须先自动转换为int才能运算		
		// Type mismatch: cannot convert from into byte
		short s1=1;
		int i1=1;
		long l1=1;
		float f1=1;
		double d1=1;
		//s1=s1+i1;//short+int=int
		//s1=s1+i1+l1;//short+int+long=long
		//s1=s1+i1+l1+f1;//short+int+long+float=float
		//2：运算后结果的数据类型取决于 精度最高的数据
		
		//+：：作为正负号
		System.out.println(+1);
		
		//+：：作为字符串连接符
		//字符串：打印输出语句中带双引号的就是字符串
		System.out.println("111aahha中环");//"111aahha"就是字符串
		//任何数据和字符串连接 都形成一个新的字符串
		System.out.println("abc"+12);//"abc12"
		System.out.println("abc"+true+1);//"abctrue1"
		System.out.println(1+1+2+3+4);//计算机运算复杂的式子 永远都是从左到右逐个运算的
		System.out.println(1+2+3+"abc"+1+2);//"6abc12"
		System.out.println(2.0-1.1);//0.8999999999999999: float和double进行运算时 会出现精度丢失
		//20/10  2000000001/1000000000
		//1.1  --->(1.04,1.15)
		
		System.out.println("s1="+s1);//s1=1
		
		
		//%:::n%m= n除以m得到一个整数 除不尽的那部分
		System.out.println(1/2);//1/2=0
		System.out.println(10%3);//10/3=3 除不尽那部分是1
		System.out.println(3%5);// 3/5=0   除不尽那部分3
		System.out.println(4.5%2.1);//余数的正负取决于 分子的正负
		System.out.println(-4.5%-2.1);
		System.out.println(-4.5%2.1);
		System.out.println(4.5%-2.1);
		
		//++ 自增  -- 自减
		int a=3;
		a++;//等价于a=a+1; 等价于++a;
		System.out.println("a="+a);//a=4
		a--;//等价于a=a-1;  等价于--a;
		System.out.println("a="+a);//a=3
		
		//比较运算符
		System.out.println(1>=2);//false
		System.out.println(1==2);
		System.out.println(1==1.1);
		System.out.println(1.1==1.1f);//false
		
		//赋值运算符
		a=4;
		a+=3;//等价于a=(a的类型)(a+3);
		System.out.println("a="+a);//a=7
		a%=5;//等价于a=(a的类型)(a%5);
		System.out.println("a="+a);//a=2
		
		short s=1;
		s+=1;
		s=(short)(s+1);
		
		
		
		

	}

}
