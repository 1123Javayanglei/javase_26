package com.zhiyou100.day04;

public class ZuoYe2 {

	public static void main(String[] args)throws Exception {
		
		//	4  扩展题1：
		//	          使用swicth 根据分数判断等级
		//			  及格[60,70)   良好[70,80)   优秀[80,100]   不及格[0,60)
		//			  switch是通过穷举法来进行判断  
		//			  提示可以考虑：(int)(score/10)
		//定义变量记录分数
		double score=5.5;
		//通过switch判断(int)(score/10)
		if(score<0||score>100) {
			 System.out.println("score="+score+",分数不合法!");
		}else {
			 switch((int)(score/10)) {
			      case 6:
			    	  System.out.println("score="+score+",等级是及格!");break;
			      case 7:
			    	  System.out.println("score="+score+",等级是良好!"); break;
			      case 8:
			      case 9:
			      case 10:
			    	  System.out.println("score="+score+",等级是优秀!");break;
			      default:
			    	  System.out.println("score="+score+",等级是不及格!"); break;
		      }
		}
		
		//	5  扩展题2：使用while来实现
		//	          **计算圆周率:中国古代数学家研究出了计算圆周率最简单的办法:
		//				PI=4/1-4/3+4/5-4/7+4/9-4/11+4/13-4/15+4/17....这个算式的结果会无限接近于圆周率的值,
		//				我国古代数学家祖冲之计算出,圆周率在3.1415926 和3.1415927 之间,请编程计算,要想得到这样的结果,他要经过多少次加减法运算?
		//				注意：此题需要研究 循环的条件和每次加减的数的规律
		/*定义每次加入pi中的数为num
		 *num的特点：  1:   奇数次为正  偶数次为负 2:分子固定是4  3 :分母从1开始每次加2
		 *结束循环的条件：       pi>3.1415927||pi<3.1415926
		 *求次数
	    */
		 //定义变量记录圆周率 每次加的数 次数
		 int ciShu=1;
		 double PI=0;
		 double num=0;
		 while(PI>3.1415927||PI<3.1415926) {
			   if(ciShu%2==0) {
				   num=-4.0/(2*ciShu-1);
			   }else {
				   num=4.0/(2*ciShu-1); 
			   }
			   PI+=num;   ciShu++;
		 }
		 System.out.println("num="+num+",ciShu="+(ciShu-1)+",pi="+PI);
		
		//	6  留下你的宝贵意见	

	}

}
