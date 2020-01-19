package com.zhiyou100.day03;

public class LianXi01_IfElse {

	public static void main(String[] args) {
		// 1 用ifelse求三个数的大值：
		// 定义变量记录三个数
		// int a=2;int b=5;int c=-3;
		int a = 2, b = 5, c = -3;
		// 定义变量记录大值
		int max;
		// 通过if else给max赋值 max有三种情况
		if (a > b && a > c) {
			max = a;
		} else if (b > a && b > c) {// b>c
			max = b;
		} else {
			max = c;
		}
		System.out.println(a + "," + b + "," + c + " 中的最大值是:" + max);

		// 2 用ifelse 根据月份判断季节：3 4 5 春 6 7 8夏 9 10 11秋 12 1 2冬天
		// 定义变量记录月份
		int month = 5;
		// 通过ifelse的多分支判断季节
		if (month <= 0 || month > 12) {
			System.out.println("month=" + month + ",月份不合法!");
		} else if (month == 3 || month == 4 || month == 5) {
			System.out.println("month=" + month + ",春天!");
		} else if (month >= 6 && month <= 8) {
			System.out.println("month=" + month + ",夏天!");
		} else if (month >= 9 && month <= 11) {
			System.out.println("month=" + month + ",秋天!");
		} else {
			System.out.println("month=" + month + ",冬天!");
		}

		// 3 根据年判断 是不是闰年：可以被4整除但不能被100整除,可以被400整除
		// 定义变量记录年
		int year = 1000;
		// 通过ifelse判断是否为闰年
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			System.out.println("year=" + year + ",是闰年!");
		} else {
			System.out.println("year=" + year + ",不是闰年!");
		}

		if (year % 4 == 0 && year % 100 != 0) {
			System.out.println("year=" + year + ",是闰年!");
		} else if (year % 400 == 0) {
			System.out.println("year=" + year + ",是闰年!");
		} else {
			System.out.println("year=" + year + ",不是闰年!");
		}

		// 4 根据月份和年 判断此年此月有多少天：
		year = 2019;month = 6;
		// 定义变量记录天数
		int day;
		// 4种情况：31 30 28 29
		if (month <= 0 || month >= 13) {
			System.out.println("month=" + month + ",月份不合理!");
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println(year + "年" + month + "月有30天!");
		} else if ((month == 2) && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
			// 判断年是闰年 月是2月
			System.out.println(year + "年" + month + "月：是闰年的2月有29天!");
		} else if (month == 2) {
			// 判断年不是闰年 月是2月
			System.out.println(year + "年" + month + "月：不是闰年的2月有28天!");
		} else {
			System.out.println(year + "年" + month + "月有31天!");
		}

		if (month <= 0 || month >= 13) {
			System.out.println("month=" + month + ",月份不合理!");
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println(year + "年" + month + "月有30天!");
		} else if (month == 2) {
			//判断是不是闰年
			if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				System.out.println(year + "年" + month + "月：是闰年的2月有29天!");   
			}else {
				System.out.println(year + "年" + month + "月：不是闰年的2月有28天!");
			}
		} else {
			System.out.println(year + "年" + month + "月有31天!");
		}
	}
}
