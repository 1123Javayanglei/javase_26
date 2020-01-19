package com.zhiyou100.day05;

public class LianXi1 {

	public static void main(String[] args) {




		
//		   1 定义一个装10个int元素的数组：求元素的和		
		//创建数组对象 起个名字叫arr 并给元素赋值
		int[] arr=new int[] {1,5,9,-10,9,7,6,4,3,-10};
		//定义变量记录和
		int sum=0;
		//遍历数组   :写个for  alt+/ 选择第二个即可
		for (int i = 0; i < arr.length; i++) {
			  sum+=arr[i];
		}
		System.out.println("一个装10个int元素的数组：求元素的和="+sum);
		
		
//      2定义一个装10个int元素的数组：求平均数
		double pjz=sum*1.0/arr.length;
		System.out.println("定义一个装10个int元素的数组：求平均数="+pjz);
		
//      3定义一个装10个int元素的数组：获取最大值
		//定义变量max记录最大值  赋初始值为arr[0]
		int max=arr[0];
		//拿max和数组中的元素一一比较 
		for (int i = 1; i < arr.length; i++) {
			//拿max和当前元素arr[i]做比较：  如果当前元素大于max 就让max记录当前元素的值
			max=(max<arr[i]?arr[i]:max);
		}
		System.out.println("定义一个装10个int元素的数组：获取最大值="+max);
		
//      4定义一个装10个int元素的数组： 获取最大值元素的下标	
		//先获取最大值：：：已经获取了max
		//再遍历数组  拿当前元素和max做比较  如果等于max 就打印当前元素的下标
		for (int i = 0; i < arr.length; i++) {
			if(max==arr[i]) {
				System.out.println("最大值是:"+max+"  元素下标是:"+i);
			}
		}
		
//      5 把一个10个int元素的数组 拆分为2个数组  一个装奇数 一个装偶数
		

	}

}
