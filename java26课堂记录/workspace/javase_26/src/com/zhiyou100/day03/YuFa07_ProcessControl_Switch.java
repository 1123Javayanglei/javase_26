package com.zhiyou100.day03;

public class YuFa07_ProcessControl_Switch {

	public static void main(String[] args) {
		//通过switch 根据月份判断季节
		//定义变量记录月份
		int month=3;
		switch(month) {
		      case 1:
		    	   System.out.println("month="+month+",是冬季2!");
		    	   break;
		      case 2:
		    	   System.out.println("month="+month+",是冬季3!");
		    	   break;
		      case 3:
		    	   System.out.println("month="+month+",是春季1!");
		    	   break;
		      case 4:
		    	   System.out.println("month="+month+",是春季2!");
		    	   break;
		      case 5:
		    	   System.out.println("month="+month+",是春季3!");
		    	   break;
		      case 6:
		    	   System.out.println("month="+month+",是夏季1!");
		    	   break;
		      case 7:
		    	   System.out.println("month="+month+",是夏季2!");
		    	   break;
		      case 8:
		    	   System.out.println("month="+month+",是夏季3!");
		    	   break;
		      case 9:
		    	   System.out.println("month="+month+",是秋季1!");
		    	   break;
		      case 10:
		    	   System.out.println("month="+month+",是秋季2!");
		    	   break;
		      case 11:
		    	   System.out.println("month="+month+",是秋季3!");
		    	   break;
		      case 12:
		    	   System.out.println("month="+month+",是冬季1!");
		    	   break;
		      default:
		    	   System.out.println("month="+month+",月份不合法!");
		    	   break;
		}
		//简化写法
		//Cannot switch on a value of type double. Only convertible int values, strings or enum variables are permitted
		switch(month) {//switch后面表达式的值 仅限于int String enum
	      case 12:
	      case 1:
	      case 2:
	    	   System.out.println("month="+month+",是冬季3!");
	    	   break;
	      case 3:
	      case 4:
	      case 5:
	    	   System.out.println("month="+month+",是春季3!");
	    	   break;
	      case 6:
	      case 7:
	      case 8:
	    	   System.out.println("month="+month+",是夏季3!");
	    	   break;
	      case 9:
	      case 10:
	      case 11:
	    	   System.out.println("month="+month+",是秋季3!");
	    	   break;
	      default:
	    	   System.out.println("month="+month+",月份不合法!");
	    	   break;
	    }
		
		//switch在开发时很少使用：1 switch格式复杂  2 switch只能适用于穷举法 不能表示范围
	}
}
