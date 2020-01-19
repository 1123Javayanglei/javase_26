package com.zhiyou100.day04;

public class YuFa10_ProcessControl_For2 {

	public static void main(String[] args) throws Exception{
		//1 求100到1000内可以被2或者7整除的所有数的和
		//定义变量记录和
		int sum=0;
		//使用循环 让n从100跑到1000
		for (int n=100;n<=1000;n++) {
			//判断是否可以被2或者7整除
			if(n%2==0||n%7==0) {
				System.out.println("n="+n);
				sum+=n;
			}
		}
		System.out.println("100到1000内可以被2或者7整除的所有数的和="+sum);
		
		//2 求100到999内可以被3整除 并且位数上含有1的所有数的和
		sum=0;
		//使用循环 让n从100跑到999
		for (int n=100;n<=999;n++) {
			if(n%3==0) {
				//判断位数上是否有1
				//获取各个位数的值
				int a=n%10;
				int b=n/10%10;
				int c=n/100;
				if((a-1)*(b-1)*(c-1)==0) {
					System.out.println("n="+n);
					sum+=n;
				}
			}
		}
		System.out.println("100到999内可以被3整除 并且位数上含有1的所有数的和="+sum);
		
		//3 求从1开始求和 和第一次大于1500时 加到哪个数了？
		sum=0;
		int n;
		for(n=1;sum<=1500;n++) {
			sum+=n;
		}
		System.out.println("从1开始求和 和第一次大于1500时  sum="+sum+" 加到"+(n-1));
		
		//4 求100到1000内可以被2或者7整除的所有数的个数
		//定义变量记录个数
		int geShu=0;
		//使用循环 让n从100跑到1000
		for (n=100;n<=1000;n++) {
			//判断是否可以被2或者7整除
			if(n%2==0||n%7==0) {
				geShu++;
			}
		}
		
		//5 求100到1000内可以被2和7整除的所有数的平均值
		//使用循环 让n从100跑到1000
		for (n=100,sum=0;n<=1000;n++) {
			//判断是否可以被2或者7整除
			if(n%2==0&&n%7==0) {
				geShu++;
				sum+=n;
			}
		}
		System.out.println("100到1000内可以被2和7整除的所有数的平均值"+sum*1.0/geShu);
	}
}
