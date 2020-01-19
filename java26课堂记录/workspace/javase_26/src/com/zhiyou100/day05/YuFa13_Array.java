package com.zhiyou100.day05;

public class YuFa13_Array {

	public static void main(String[] args) {
		int[] intArr=new int[10];//定义一个数组名arr 让其指向一个装10个int元素的数组对象
		//1 创建一个数组名intArr                :::::::int[] arr
		//2 创建一个装10个int类型元素的数组对象          :::::::new int[10];
		//3  让左边的数组名intArr 指向右边创建的数组对象::::::: =
		
		//数组的使用注意事项1: 数组中的元素有默认值：值取决于元素的类型
		// byte short int  long float double数组元素 默认值是对应类型的0
		// char 数组元素默认值是0整数在编码表中对应的字符 ' '
		// boolean 数组元素默认值是false
		
		System.out.print("int数组：：：");
		for (int i = 0; i < intArr.length; i++) {
			System.out.print(intArr[i]+(i==intArr.length-1?"\n":","));
		}
		byte[] byteArr=new byte[10];
		System.out.print("byte数组：：：");
		for (int i = 0; i < byteArr.length; i++) {
			System.out.print(byteArr[i]+(i==byteArr.length-1?"\n":","));
		}
		short[] shortArr=new short[10];
		System.out.print("short数组：：：");
		for (int i = 0; i < shortArr.length; i++) {
			System.out.print(shortArr[i]+(i==shortArr.length-1?"\n":","));
		}
		long[] longArr=new long[10];
		System.out.print("long数组：：：");
		for (int i = 0; i < longArr.length; i++) {
			System.out.print(longArr[i]+(i==longArr.length-1?"\n":","));
		}
		float[] floatArr=new float[10];
		System.out.print("float数组：：：");
		for (int i = 0; i < floatArr.length; i++) {
			System.out.print(floatArr[i]+(i==floatArr.length-1?"\n":","));
		}
		double[] doubleArr=new double[10];
		System.out.print("double数组：：：");
		for (int i = 0; i < doubleArr.length; i++) {
			System.out.print(doubleArr[i]+(i==doubleArr.length-1?"\n":","));
		}
		boolean[] booleanArr=new boolean[10];
		System.out.print("boolean数组：：：");
		for (int i = 0; i < booleanArr.length; i++) {
			System.out.print(booleanArr[i]+(i==booleanArr.length-1?"\n":","));
		}
		char[] charArr=new char[10];
		System.out.print("char数组：：：");
		for (int i = 0; i < charArr.length; i++) {
			System.out.print(charArr[i]+(i==charArr.length-1?"\n":","));
		}
		System.out.println((int)(charArr[0]));//0
		
		
		//注意事项2： 元素下标取值范围：0到length-1：
		intArr=new int[10];
		//System.out.println(intArr[11]);
		
		//注意事项3：一个new就是一个新的数组对象
		int[] arr=new int[11];//定义一个数组名arr 并指向一个装11个int元素的数组对象
		arr[0]=11;
		arr=new int[11];//让数组名arr 指向一个新的数组对象
		int[] arr1;//创建一个数组名
		arr1=arr;//让arr1指向arr指向的数组对象   等价于给66行的数组对象起了两个名字
		arr1[0]=19;
		System.out.println(arr[0]);//19

	}
}
