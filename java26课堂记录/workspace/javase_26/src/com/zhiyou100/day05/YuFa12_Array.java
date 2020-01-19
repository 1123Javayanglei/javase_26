package com.zhiyou100.day05;

public class YuFa12_Array {

	public static void main(String[] args) {
//    定义变量：数据类型 变量名; 
		int a;
//	       定义数组：元素类型[]  数组名;
		int[] arr;
		
//	       变量赋值：变量名=常量值;
		a=11;
//	        创建数组对象方式1：数组名=new 元素类型[元素个数]; 
		arr=new int[10];//创建一个数组对象 装10个int类型的元素
		
	    System.out.println(a); //打印变量名 打印的是变量的值
	    System.out.println(arr);//打印数组名 其实是打印对象  打印的是：对象类型@对象的内存地址：：：[I@70dea4e
	    //2进制：0 1  10进制：0-9  16进制：0-9 a-f
	    
//     数组创建时 会为其中的所有位置分配一个编号：：：索引/下标    从0开始    
//     给数组中的元素赋值格式：数组名[元素下标]=元素值;
	   //给arr中第三个元素赋值：第三个元素的下标是2
	   arr[2]=87;arr[0]=8;arr[3]=7;arr[7]=86;arr[8]=13;arr[9]=27;
	   
	   System.out.println("arr中第三个元素赋值="+arr[2]);
	   //arr=new int[10]; 其实就是定义了10个变量 变量名为arr[下标]

//     获取数组的元素个数：数组名.length
	   System.out.println("arr.length="+arr.length);//arr.length=10

//     遍历数组：查看获取数组中所有元素
	   //使用循环 对应数组中的所有元素  定义变量记录元素的下标  下标取值从0到9
	   for (int i = 0; i <arr.length; i++) {
		    System.out.println("arr["+i+"]="+arr[i]);
	   }
	   
	   //创建数组对象并起个名字方式1：元素类型[] 数组名=new 元素类型[元素个数];
	   int[] arr1=new int[10];
	   
	   //创建数组对象方式二：元素类型[] 数组名=new 元素类型[]{值1,值2,值3....};
	   int[] arr2=new int[] {1,3,6,8,9,0};
	   
	   //创建数组对象方式三：元素类型[] 数组名={值1,值2,值3....};
	   int[] arr3= {1,4,7,9,0,3};
	   //遍历数组
	   for (int i = 0; i <arr3.length; i++) {
		    System.out.println("arr3["+i+"]===="+arr3[i]);
	   }
	}
}
