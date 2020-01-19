package com.zhiyou100.day04;

public class YuFa10_ProcessControl_For4 {

	public static void main(String[] args) throws Exception{
		/*
		 * 1 打印4个方向的九九乘法表
		 * */
		for (int i = 1; i <=9; i++) {//外层for循环变量i   控制行数
			for (int j =1; j <= i; j++) {//内层for循环变量j 控制每行的列数
				  System.out.print(i+"*"+j+"="+i*j+(j==i?"\n":"\t"));
			}
		}
		System.out.println();
		
		for (int i = 1; i <=9; i++) {//外层for循环变量i   控制行数
			for (int j =9; j >=1; j--) {//内层for循环变量j 控制每行的列数
			     if(i<j) {
			    	 System.out.print("\t");
			     }else {
			    	 System.out.print(i+"*"+j+"="+i*j+(j==1?"\n":"\t"));
			     }
			}
		}
		System.out.println();
		for (int i =9; i >=1; i--) {
			for (int j = 1; j <=i; j++) {
					System.out.print(i+"*"+j+"="+i*j+(j==i?"\n":"\t"));
			}
		}
		
		System.out.println("---------");
		for (int i =1; i <=9; i++) {
			 for (int j = 1; j <=9; j++) {
				 if(i>j) {
					 System.out.print("\t");
				 }else {
					 System.out.print(i+"*"+j+"="+i*j+(j==9?"\n":"\t"));
				 }
			}
		}
		//外层for循环变量i 控制行数
		//内层for循环变量j 控制列数
		
		
//		 * 2什么是质数：素数   判断一个数是不是质数
//		 *    正整数：除了1和其本身 不能被其他数整除的数  称之为质数  注意：1 不是质数
//		 *         6 = 1 6  2 3 不是质数
//		 *         7 = 1 7    是质数
		  //  n%m 当m大于n时  n永远不可能被m整除
		  //   判断n是否可以被除了1和n外的其他数整除  
		  //只用考虑 比n小的所有数  是否可以整除n
		  //通过循环让m 从2跑到n-1  判断m是否可以除尽n 只要有一次除尽n就不是质数
		   int n=1;
		   boolean b=false;//定义变量作为标签 记录n是否被除尽过
		   for(int m=2;m<n;m++) { //使用循环让m把所有比n小的数跑完
			   if(n%m==0) {
				   b=true;
			   }
		   }
		   //通过判断b的值是否更改 来判断n是否被除尽过 进而来判断n是不是质数
		   if(n==1||b==true) {
			   System.out.println("n="+n+",不是质数!");
		   }else {
			   System.out.println("n="+n+",是质数!");
		   }
	}
}
