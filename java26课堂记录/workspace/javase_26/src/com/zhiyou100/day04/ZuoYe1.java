package com.zhiyou100.day04;

public class ZuoYe1 {

	public static void main(String[] args) {
		//eclipse注释：ctrl+/
		
		//		1  使用ifelse 根据性别和年龄判断称呼
		//	             女性称呼：小女孩   美女  阿姨  奶奶
		//		 男性称呼：小男孩  帅哥  叔叔   爷爷
		//		 年龄分界线：    18    35     60
		//定义变量：记录性别和年龄
		char sex;int age;
		sex='男';age=32;//工作环境下 变量的值来源于页面+数据库
		//通过ifelse多分支来判断称呼
		if((sex!='男'&&sex!='女')||(age<=0||age>=120)) {
			System.out.println("sex="+sex+",age="+age+",性别或者年龄不合法!");
		}else if(sex=='女'&&age<18) {
			System.out.println("sex="+sex+",age="+age+",称呼是小女孩!");
		}else if(sex=='女'&&age<35) {
			System.out.println("sex="+sex+",age="+age+",称呼是美女!");
		}else if(sex=='女'&&age<60) {
			System.out.println("sex="+sex+",age="+age+",称呼是阿姨!");
		}else if(sex=='女') {
			System.out.println("sex="+sex+",age="+age+",称呼是奶奶!");
		}else if(age<18) {
			System.out.println("sex="+sex+",age="+age+",称呼是小男孩!");
		}else if(age<35) {
			System.out.println("sex="+sex+",age="+age+",称呼是帅哥!");
		}else if(age<60) {
			System.out.println("sex="+sex+",age="+age+",称呼是叔叔!");
		}else{
			System.out.println("sex="+sex+",age="+age+",称呼是爷爷!");
		}
		
		//先判断性别
		if((sex!='男'&&sex!='女')||(age<=0||age>=120)) {
			System.out.println("sex="+sex+",age="+age+",性别或者年龄不合法!");
		}else if(sex=='女') {
			if(age<18) {//对年龄进行判断
				System.out.println("sex="+sex+",age="+age+",称呼是小女孩!");
			}else if(age<35) {
				System.out.println("sex="+sex+",age="+age+",称呼是美女!");
			}else if(age<60) {
				System.out.println("sex="+sex+",age="+age+",称呼是阿姨!");
			}else {
				System.out.println("sex="+sex+",age="+age+",称呼是奶奶!");
			}
		}else {//性别是男
			if(age<18) {
				System.out.println("sex="+sex+",age="+age+",称呼是小男孩!");
			}else if(age<35) {
				System.out.println("sex="+sex+",age="+age+",称呼是帅哥!");
			}else if(age<60) {
				System.out.println("sex="+sex+",age="+age+",称呼是叔叔!");
			}else {
				System.out.println("sex="+sex+",age="+age+",称呼是爷爷!");
			}
		}
		
		//	2  使用while 求1到1000内所有满足条件的数的和：
		//	      条件：必须是偶数 而且位数上含有1   如102，310
		//定义变量记录和：定义变量让其从1跑到1000
		int n1=1,sum1=0;
		//使用循环让n1从1跑到1000
		while(n1<=1000) {
			//循环判断n1是否为满足条件的数 如果满足添加就把n1加入sum中
			if(n1%2==0) {//判断是否为偶数
				//判断位数上是否有1
				int a,b,c,d;//定义四个变量记录各个位数上的值
				a=n1%10;
				b=n1/10%10;
				c=n1/100%10;//12
				d=n1/1000;
				//if(a==1||b==1||c==1||d==1) {
				if((a-1)*(b-1)*(c-1)*(d-1)==0) {//判断abcd中是否有1
					System.out.println("n1="+n1);
					sum1+=n1;
				}
			}
			n1++;//迭代语句
		}
		System.out.println("1到1000内所有满足条件的数的和="+sum1);
		
		//一个变量的作用域取决于定义此变量的大括号
		
		//	3  三个互不相等数 请打印 那个是最大值 那个是最小值 那个是中间的
		//定义变量记录三个数
		int a=3,b=5,c=9;
		//定义变量记录最大值 最小值 中间值
		int max,min,mid;
		max=(a>b&&a>c)?a:(b>c?b:c);
		min=(a<b&&a<c)?a:(b<c?b:c);
		if((a-b)*(c-b)<0) {
			mid=b;
		}else if((c-a)*(b-a)<0) {
			mid=a;
		}else {
			mid=c;
		}
		System.out.println("a="+a+",b="+b+",c="+c+",最大值是:"+max+"，最小值是:"+min+"，中间值是："+mid);
		
		if(a>b&&a>c) {
			max=a;
			if(b>c) {
				mid=b;
				min=c;
			}else {
				mid=c;
				min=b;
			}
		}else if(b>c) {
			max=b;
			if(a>c) {
				mid=a;
				min=c;
			}else {
				mid=c;
				min=a;
			}
		}else {
			max=c;
			if(b>a) {
				mid=b;
				min=a;
			}else {
				mid=a;
				min=b;
			}
		}
		
	
		
		
		
		
		
		//	4  扩展题1：
		//	          使用swicth 根据分数判断等级
		//			  及格[60,70)   良好[70,80)   优秀[80,100]   不及格[0,60)
		//			  switch是通过穷举法来进行判断  
		//			  提示可以考虑：(int)(score/10)
		
		
		//	5  扩展题2：使用while来实现
		//	          **计算圆周率
		//				中国古代数学家研究出了计算圆周率最简单的办法:
		//				PI=4/1-4/3+4/5-4/7+4/9-4/11+4/13-4/15+4/17......
		//				这个算式的结果会无限接近于圆周率的值,
		//				我国古代数学家祖冲之计算出,圆周率在3.1415926 和3.1415927 之间,
		//				请编程计算,要想得到这样的结果,他要经过多少次加减法运算?
		//				注意：此题需要研究 循环的条件和每次加减的数的规律	
		//	6  留下你的宝贵意见	
		
		
	

	}

}
