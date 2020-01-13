package com.zhiyou100.day03;

import javax.sound.midi.SoundbankResource;

/**
 * @author yanglei
 */
public class Day03OfHomeWork {
    public static void main(String[] args) {
        genderAndAge('男',61);
        sumOfOneToThousand();
        maxAndMinAndMid(2,2,2);
        judgingTheRank(60);
        piOfZuChongZhi();

    }
    public static void piOfZuChongZhi(){
        /*
         * 特点：
         * 奇数次为正，偶数次为负
         * 分子固定为4
         * 分母，从1开始每次加2
         *
         * 结束条件：
         * PI<3.1415926 || PI>3.1415927
         *
         */
        int cnt=1;
        double PI=0;
        double sum=0;
        while (PI<3.1415926 || PI>3.1415927){
            if (cnt%2==0){
                sum=-4.0/(2*cnt-1);
            }else {
                sum=4.0/(2*cnt-1);
            }
            PI+=sum;
            cnt++;
            System.out.println("cont:"+cnt+"时 PI="+PI+" sum="+sum);
        }
        System.out.println(cnt-1);



}
    public static void judgingTheRank(double grade){
        if (grade>=0&&grade<=100) {
            int newGrade = (int) (grade / 10);
            switch (newGrade) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("你不及格");
                    break;
                case 6:
                    System.out.println("你及格了");
                    break;
                case 7:
                    System.out.println("良好");
                    break;
                case 8:
                case 9:
                case 10:
                    System.out.println("优秀");
                    break;
                default:
                    break;
            }
        }else {
            System.out.println("滚");
        }
        }


    public static void maxAndMinAndMid(int a,int b,int c){
        if (a!=b&&a!=c&&b!=c) {

            if (a > b && a > c) {
                System.out.println("max=" + a);
            }
            if (b > c && b > a) {
                System.out.println("max=" + b);
            }
            if (c > a && c > b) {
                System.out.println("max=" + c);
            }
            if (a > b && a < c || a > c && a < b) {
                System.out.println("mid=" + a);
            }
            if (b > a && b < c || b > c && b < a) {
                System.out.println("mid=" + b);
            }
            if (c > a && c < b || c < a && c > b) {
                System.out.println("mid=" + c);
            }
            if (a < b && a < c) {
                System.out.println("min=" + a);
            }
            if (b < a && b < c) {
                System.out.println("min" + b);
            }
            if (c < a && c < b) {
                System.out.println("min=" + c);
            }
        }else {
            System.out.println("请输入三个不相等的数字");
        }
    }
    public static void sumOfOneToThousand(){
        /*
         *求1到1000满足条件的所有数的和
         * 1.偶数 %2==0
         * 2.位数有1 Number%10==1 || Number/10%10==1 || Number/100==1
         */
        int max=1000;
        int sum=0;
        int number=0;
        while (number<=max){
            boolean flag=(((number%10==1)||(number/10%10==1) || (number/100==1))&&(number%2==0));
            if (flag){
                sum+=number;
            }
            number++;
        }
        System.out.println("1到1000满足条件的所有数的和="+sum);

    }
    public  static void genderAndAge(char gender,int age){
        if (gender == '男'){
            if (age<=0||age>=200){
                System.out.println("请您重新投胎");
            }else if(age<=18){
                System.out.println("小男孩👦");
            }else if(age<=35){
                System.out.println("帅哥");
            }else if(age<=60){
                System.out.println("叔叔🧍‍♂️");
            }else {
                System.out.println("爷爷👴");
            }
        }else if(gender=='女') {
            if (age<=0||age>=200){
                System.out.println("请您重新投胎");
            }else if(age<=18){
                System.out.println("小女孩👧");
            }else if(age<=35){
                System.out.println("美女");
            }else if(age<=60){
                System.out.println("阿姨🧍‍");
            }else {
                System.out.println("奶奶👵");
            }
        }else {
            System.out.println("请重新考虑你的性别");
    }

    }
}
