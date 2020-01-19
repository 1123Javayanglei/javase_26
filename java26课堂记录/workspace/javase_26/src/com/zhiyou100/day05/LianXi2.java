package com.zhiyou100.day05;

public class LianXi2 {

	public static void main(String[] args) {
	

		
		int[] arr1=new int[]{1,3,5,7,8,9,0,4,5,6};
		int[] arr2;
		//arr2={1,3,5,7,8,9,0,4,5,6};//方式三要求 定义数组名和创建数组对象不能分开写
		
//      5 把一个10个int元素的数组 拆分为2个数组  一个装奇数 一个装偶数		
		int[] arr= {1,3,5,7,8,9,0,4,5,6};
		//创建数组对象必须先明确元素类型和元素个数
		//获取偶数个数
		int os=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2==0) {os++;}
		}
		//创建两个数组对象
		int[] arrOS=new int[os];
		int[] arrJS=new int[arr.length-os];
		//给元素赋值
		for (int i = 0,j=0,k=0; i < arr.length; i++) {//j作为偶数数组的下标  k作为奇数数组的下标
			 if(arr[i]%2==0) {
				 arrOS[j]=arr[i];
				 j++;
			 }else {
				 arrJS[k]=arr[i];
				 k++;
			 }
		}
		//遍历打印数组
		for (int i = 0; i < arrJS.length; i++) {
			System.out.print(arrJS[i]+(i==arrJS.length-1?"\n":","));
		}
		for (int i = 0; i < arrOS.length; i++) {
			System.out.print(arrOS[i]+(i==arrOS.length-1?"\n":","));
		}
		
		
		//6 把一个10个int元素的数组arr  创建一个新数组中的元素要求arr中元素顺序颠倒
		// 1 2 3 4 0 ---- 0 4 3 2 1
		//定义一个新数组  元素个数和当前元素个数一致
		int[] arrNew=new int[arr.length];
		//把arr中的元素倒着装入arrNew中
		for (int i = arr.length-1,j=0; i >=0; i--,j++) {
			arrNew[j]=arr[i];
		}
		//0-----》arr.length-1
		//1----->arr.length-2
		//2----->arr.length-3
		for (int i = 0; i <arr.length; i++) {
			arrNew[arr.length-i-1]=arr[i];
		}
		
		//遍历两个数组的元素
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+(i==arr.length-1?"\n":","));
		}
		for (int i = 0; i < arrNew.length; i++) {
			System.out.print(arrNew[i]+(i==arrNew.length-1?"\n":","));
		}
		
		//数组其实很简单  就是为其中的所有元素提供一个统一的访问方式：数组名+索引
		
		//1 定义一个装10个int元素的数组  获取次大值
		//2定义一个装10个double元素的数组  把所有的所有保留最多1位数小数
		//{1.2234,1.456,1.678}  ---{1.2,1.4,1.6}
		
		
	}

}
