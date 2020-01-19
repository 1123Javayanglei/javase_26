package com.zhiyou100.day03;

public class YuFa08_ProcessControl_While {

	public static void main(String[] args)throws Exception {
		//while循环
		int a=4;
		if(a>0) {
			System.out.println("if 判断a>0:::a="+a);
		}
		a=4;
		while(a>0) {
			System.out.println("while 判断a>0:::a="+a);
			Thread.sleep(300);
			a--;
		}
		
		/*
		 * while(条件表达式){
		 *      循环执行的代码块
		 *      迭代语句 ：按指定的算法来更改变量的值  从而影响条件表达式的值
		 * }
		 * 写while循环时 先确定：
		 *   1 循环的条件
		 *   2 循环执行的代码
		 *   3 迭代语句
		 * */
		//1 求1到100的和
		//System.out.println(1+2+3+4+5+...100);
		//可以通过循环实现求和：循环的把一个数n加入和sum中   
		//循环条件：n<=100
		//循环代码：sum=sum+n;
		//迭代语句：n++;
		//定义变量记录n 让n从1跑到100  定义变量sum记录和
		int n=1;int sum=0;
		while(n<=100) {//条件表达式
			sum+=n;//循环执行的代码
			n++;//迭代语句
		}
		System.out.println("sum="+sum);//5050
		System.out.println("n="+n);//101
		
		//2 求1到200内所有可以被3整除或者7整除的数的平均值(和除以个数)
		//通俗的理解：当需要让一个变量从n跑到m时  只能通过循环来实现
		//题的目的：获取满足条件的n的个数及其和
		//循环条件：n<=200
		//循环执行的代码：判断n是否可以被3/7整除 如果被整除就geShu++;sum+=n
		//迭代语句：n++;
		//定义变量记录n 让其从1跑到200    定义变量geShu记录满足条件的n的个数  定义变量sum记录名字条件的n的和
		n=1;int geShu=0;sum=0;
		while(n<=200) {
			if(n%3==0||n%7==0) {
				geShu++;
				sum+=n;
			}
			n++;
		}
		//平均值是double类型：：需要让sum*1.0转换为double
		System.out.println("求1到200内所有可以被3整除或者7整除的数的平均值="+sum*1.0/geShu);
		
		//3 判断一个数是不是水仙花数：只能是三位数  各个位数上的值的三次方之和等于此数
		//如153就是：1*1*1+5*5*5+3*3*3=1+125+27=153
		n=153;
		//先判断是否是三位数
		if(n<100||n>=1000) {
			System.out.println("n="+n+",不是三位数 肯定不是水仙花数!");
		}else {//是三位数
			//获取各个位数的值：定义三个变量记录各个位数的值
			int a1,a2,a3;
			//给三个变量赋值
			a1=n%10;//取个位数
			a2=n/10%10;//取十位数
			a3=n/100;//取百位数
			//求和
			sum=a1*a1*a1+a2*a2*a2+a3*a3*a3;
			//判断sum是否等于n
			if(sum==n){
				System.out.println("n="+n+",是水仙花数!");
			}else {
				System.out.println("n="+n+",不是水仙花数!");
			}
		}
		
		//4 打印输出所有水仙花数
		//定义变量让其从100跑到999
		n=100;
		while(n<1000) {
				//获取各个位数的值：定义三个变量记录各个位数的值
				int a1,a2,a3;
				//给三个变量赋值
				a1=n%10;//取个位数
				a2=n/10%10;//取十位数
				a3=n/100;//取百位数
				//求和
				sum=a1*a1*a1+a2*a2*a2+a3*a3*a3;
				//判断sum是否等于n
				if(sum==n){
					System.out.println("n="+n+",是水仙花数!");
				}
				//迭代语句
				n++;
		}
	}
}
