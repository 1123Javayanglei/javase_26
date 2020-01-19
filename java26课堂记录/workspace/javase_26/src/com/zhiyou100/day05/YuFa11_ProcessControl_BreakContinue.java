package com.zhiyou100.day05;

public class YuFa11_ProcessControl_BreakContinue {

	public static void main(String[] args) throws Exception{
		//跳转结构之break:使用于swicth和循环
		//break用在switch中：表示结束switch结构
		int n=11;
		switch(n%5) {
		     case 0:
		    	 System.out.println("case 0");
		    	 break;
		     case 1:
		    	 System.out.println("case 1");
		    	 break;
		     case 2:
		    	 System.out.println("case 2");
		    	 break;
		     case 3:
		    	 System.out.println("case 3");
		    	 break;
		      default:
		    	 System.out.println("default 4");
		    	 break; 
		}
		//break用在循环中：结束本层循环
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				//System.out.println("i="+i+",j="+j);
//				if(j==3) {
//					break;//结束内层for循环
//				}
			}
			if(i==3) {
				break;//结束外层for循环
			}
		}
		
		//跳转结构之 continue:使用于循环中
		for (int i = 0; i <=5; i++) {
			if(i==3) {
				continue;//结束本次循环  继续下一次循环
			}
			System.out.println("continue  i="+i);
		}
	}
}
