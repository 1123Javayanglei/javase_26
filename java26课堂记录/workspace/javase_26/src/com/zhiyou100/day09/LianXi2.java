package com.zhiyou100.day09;

public class LianXi2 {

	public static void main(String[] args) {
		getQinMiShu();
	}
	//如果a的因子之和等于b  b的因子之和等于a  此时a和b是亲密数  求3000以内的所有亲密数
	//n%m==0  并且m!=n 此时m是n的因子
	public static void getQinMiShu() {
		for (int a = 1; a < 3000; a++) {
			int sumA=getYinZiHe(a);//获取a的因子之和
			int  b=sumA;
			int sumB=getYinZiHe(b);//获取b的因子之和
			if(a==sumB) {
				System.out.println(a+"和"+b+"是亲密数");
			}
		}
	}
	//写一个方法求参数n的因子之和
	public static int getYinZiHe(int n) {
			int sum=0;//获取n的因子之和
			for (int m = 1; m <=n/2; m++) {//定义变量从1跑到n/2 获取n所有的因子
				if(n%m==0) {
					sum+=m;
				}
			}
			return sum;
	}

}
