package com.zhiyou100.day03;

public class YuFa06_ProcesControl {

	public static void main(String[] args) {
		//1顺序结构:从左到右 从上到下
		System.out.println(11);System.out.println(12);
		System.out.println(13);System.out.println(14);
		//2.1选择结构：单分支
		//如果是女生 请进
		//定义变量记录性别
		char sex='女';
		//判断是否为女  如果是女 就打印请进
		if(sex=='女') {
			System.out.println("sex="+sex+",美女请进!");
		}
		
		//2.2 选择结构：双分支
		//如果是女生 打印请进我班  如果不是女生 打印去对面班
		if(sex=='女'){
			System.out.println("sex="+sex+",美女请来我班!");
		}else{
			System.out.println("sex="+sex+",你不是女的  请去对面班!");
		}
		
		//2.3 选择结构：多分支
		//根据分数 判断打印输出不及格 60 及格 70 良好 80 优秀
		//定义变量记录分数
		float score=65.5f;
		if(score<0||score>100) {
			System.out.println("score="+score+",分数无效!");
		}else if(score<60) {//隐含的条件：score>=0&&score<=100
			System.out.println("score="+score+",不及格！！！");
		}else if(score<70) {//隐含的条件：score>=60&&score<=100
			System.out.println("score="+score+",及格！！！");
		}else if(score<80) {//隐含的条件：score>=0&&score<=100
			System.out.println("score="+score+",良好！！！");
		}else {//其他情况 都是优秀
			System.out.println("score="+score+",优秀！！！");
		}
	}

}
