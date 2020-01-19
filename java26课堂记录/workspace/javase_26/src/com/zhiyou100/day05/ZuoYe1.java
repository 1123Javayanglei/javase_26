package com.zhiyou100.day05;

public class ZuoYe1 {

	public static void main(String[] args) {
//		for (int i = 1; i < 100; i++) {
//			System.out.println("Math.sqrt("+i+")"+Math.sqrt(i));
//		}
//		1 打印四个方向的乘法口诀
//		2 判断一个数是不是质数
		int n=19;//定义变量记录被判断的数据
		int b=0;//定义作为标签  记录n是否被除尽过
		//使用循环让变量m从2跑到n的开平方
		for(int m=2;m<=Math.sqrt(n);m++) {
			if(n%m==0) {b++;}
		}
		//循环完后 通过判断b的值是否更改了 来判断n是否被除尽过  进而来判断n是不是质数
		if(n!=1&&b==0) {
			System.out.println("n="+n+"是质数");
		}else {
			System.out.println("n="+n+"不是质数");
		}
		
//		3 使用for循环把 圆周率的题再写一遍
		//定义变量记录圆周率和次数
		double PI=0;
		int ciShu;
		for (ciShu= 1; PI<3.1415926||PI>3.1415927; ciShu++) {
			   //获取每次加入PI的数
			   double num=4.0/(ciShu*2-1);
			   PI+=(ciShu%2==0?-1*num:num);
		}
		System.out.println("PI="+PI+",ciShu="+(ciShu-1));
		
		
//		4 使用for循环 获取所有的水仙花数
		//1 三位数  2各个位数的值的三次方之和等于次数
		//通过循环把所有的可能跑完
		for (int i = 100; i < 1000; i++) {
			//判断i是不是水仙花数
			int ai=i%10,bi=i/10%10,ci=i/100;
			//获取各个位数的三次方之和
			int sum=ai*ai*ai+bi*bi*bi+ci*ci*ci;
			if(sum==i) {
				System.out.println(i+"是水仙花数！");
			}
		}
		
//		5 留下你的宝贵意见
//		扩展题1： 判断一个正整数n是几位数
		 //通过循环 让n循环除以10 直到除数是0：：：：：12345/10=1234/10=123/10=12/10=1/10=0
		n=1;
		int t=n;//定义变量记录n当前的值
		for (ciShu=0;n!=0;ciShu++) {
			n=n/10;
			System.out.println("n="+n);
		} 
		System.out.println(t+":::是"+ciShu+"位数！");
		
//		扩展题2：打印输出1到100内所有质数
	
		
//		扩展题3：求1到100内所有质数的平均值

	}

}
