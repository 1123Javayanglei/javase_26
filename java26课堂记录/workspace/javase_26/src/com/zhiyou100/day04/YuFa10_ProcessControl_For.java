package com.zhiyou100.day04;

public class YuFa10_ProcessControl_For {

	public static void main(String[] args) throws Exception{
		 int a=1;
//	     for(System.out.println("初始化语句 a="+a);  a<4   ;System.out.println("迭代语句  a="+a)) {
//	    	 System.out.println("循环体：：：：a="+a);
//	    	 a++;
//	     }
	     //1 先执行初始化语句
	     //2 判断条件表达式是否成立
	     //3 如果成立就执行循环体
	     //4 执行迭代语句
	     //继续执行 步骤 2 3 4 直到2不成立
		 
//		 for(;;) {//条件表达式不写 默认是true
//			 System.out.println("循环体");
//		 }
		 
		 //通过while循环求1到10的和
		 int n1=1;int sum1=0;
		 while(n1<=10) {
			 sum1+=n1;
			 n1++;
		 }
		 System.out.println("n1="+n1+",sum1="+sum1);
		 
		 //1 通过for循环求1到10的和
		 int sum2=0;//循环完后 还需要获取sum2的值  所以把定义sum2写在for循环外面
		 for(int n2=1;n2<=10;n2++) {//循环完后不再关心变量n2 把定义变量n2 写在for的初始化语句中 
			 sum2+=n2;
		 }
		 System.out.println("sum2="+sum2);
		 
		 //2 求1到100内所有偶数并且可以被3整除的数据的和
		 int sum3=0;
		 for(int n3=1;n3<=100;n3++) {
			 if(n3%2==0&&n3%3==0) {
				 sum3+=n3;
			 }
		 }
		 System.out.println("1到100内所有偶数并且可以被3整除的数据的和="+sum3);
	     
	     //3 百钱买百鸡：一百文钱买一百只鸡：鸡有三种：公鸡每只3文钱 母鸡每只2文钱  3只小鸡1文钱
		 //把所有可能的情况打印出来
		 //定义变量记录公鸡母鸡小鸡的只数
		 int gj,mj,xj;
		 //把所有可能都跑一遍  判断是否符合百钱百鸡
		 for(gj=0;gj<=33;gj++) {//公鸡的取值范围[0,33]
			 for(mj=0;mj<=50;mj++) {//母鸡的取值范围[0,50]
                  for(xj=0;xj<=100;xj++) {//小鸡范围[0,100]
                	    if(gj+mj+xj==100&&gj*3+mj*2+xj/3==100&&xj%3==0) {
                	    	 System.out.println("公鸡：母鸡：小鸡="+gj+":"+mj+":"+xj);
                	    }
                  }				 
			 }
		 }
		 
	}
}
