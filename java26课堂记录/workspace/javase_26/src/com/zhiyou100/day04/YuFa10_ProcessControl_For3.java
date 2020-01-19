package com.zhiyou100.day04;

public class YuFa10_ProcessControl_For3 {

	public static void main(String[] args) throws Exception{
		//for循环中变量的作用范围
		int a=1;            //变量a::for循环外面的变量    作用是整个main方法
		for(int b=1;a<10;) {//变量b::for循环初始化语句中定义的变量 作用域是整个for循环
			int c=1;        //变量c::for循环体中定义的变量     作用域是本次循环
			//Thread.sleep(200);
			System.out.println("a:b:c="+a+":"+b+":"+c);
			a++;b++;c++;
		}
		System.out.println("a:"+a);//变量a循环完后可以访问到  变量bc 在for循环外面访问不到
		//Unreachable code
		
		
		for(int i=0;i<=5;i++) {
			for(int j=0;j<=5;j++) {
				System.out.println("i="+i+",j="+j);
			}
		}
		
		System.out.println("-----------");
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
				if(i*j<10) {
					System.out.print(i+"*"+j+"="+i*j+"   ");
				}else {
					System.out.print(i+"*"+j+"="+i*j+"  ");
				}
			}
			System.out.println();//打印一个换行
		}
		System.out.println("-----------");
		
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(i+"*"+j+"="+i*j+"\t");
			}
			System.out.println();//
		}
		
		
//		char c='1';
//		c='t';//t字符
//		c='\t';// \t是制表符  
//		c='\n';// \n是制表符  
//		System.out.println(c);
//		System.out.println(111);
		
		/*
		 * 1 打印4个方向的九九乘法表
		 * 2什么是质数：素数   判断一个数是不是质数
		 *    正整数：除了1和其本身 不能被其他数整除的数  称之为质数
		 *         6 = 1 6  2 3 不是质数
		 *         7 = 1 7    是质数
		 *         注意：1 不是质数
		 * */
	}
}
