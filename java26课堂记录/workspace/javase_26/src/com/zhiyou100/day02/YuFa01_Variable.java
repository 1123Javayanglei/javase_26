package com.zhiyou100.day02;

public class YuFa01_Variable {

	public static void main(String[] args) {
		 
		 //定义变量记录性别:  定义变量语句格式：数据类型  变量名;
		 char woDeXingBie;
		 //给变量赋值:    
		 woDeXingBie='男';//给变量赋值字符男
		 woDeXingBie='女';//把变量的值更改为字符女
		 
		 //赋值时  值的类型必须和变量的类型一致
		 //woDeXingBie=1.1;//Type mismatch: cannot convert from double to char
		 
		 //使用变量：打印数据、进行数学运算
		 System.out.println(woDeXingBie);//打印变量 打印的是变量的值
		 System.out.println(woDeXingBie);//打印变量 打印的是变量的值
		 
		 //定义变量并赋值的语句：数据类型 变量名=值;
		 float height=1.75f;//完全等价于 float height;height=1.75f;

	}

}
