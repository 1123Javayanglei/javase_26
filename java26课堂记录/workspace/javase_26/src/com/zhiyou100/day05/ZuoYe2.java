package com.zhiyou100.day05;

public class ZuoYe2 {

	public static void main(String[] args) {

//		扩展题2：打印输出1到100内所有质数
		//使用循环让变量n从1跑到100
		for (int n = 1; n<=100; n++) {
			//判断当前n是不是质数
			int b=0;//定义作为标签  记录n是否被除尽过
			//使用循环让变量m从2跑到n的开平方
			for(int m=2;m<=Math.sqrt(n);m++) {
				if(n%m==0) {b++;}
			}
			//循环完后 通过判断b的值是否更改了 来判断n是否被除尽过  进而来判断n是不是质数
			if(n!=1&&b==0) {
				System.out.println("n="+n+"是质数");
			}
		}
		
//		扩展题3：求1到100内所有质数的平均值
		//获取平均值  先获取和和个数
		double sum=0;
		int geShu=0;
		//通过循环 让一个变量从1跑到100
		for (int n = 1; n <=100; n++) {
			//判断当前n是不是质数
			int b=0;//定义变量作为标签
			//使用循环 让m从2跑到n的开方
			for (int m = 2; m <=Math.sqrt(n); m++) {
				  if(n%m==0) {b++;break;}
			}
			//通过判断标签的值是否更改了 来判断n是不是质数
			if(n!=1&&b==0) {
				sum+=n;
				geShu++;
			}
		}
		//所有的n判断完后  获取平均值
		System.out.println("平均值是："+sum/geShu);
	}

}
