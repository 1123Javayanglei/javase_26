package com.zhiyou100.day03;

/**
 * @author yanglei
 */
public class LoopStructure {
    public static void main(String[] args) {
        //1+100
        int sum=0,a=0,max=100;
        while (a<=max){
            sum+=a;
            a++;
        }
        System.out.println("1~100 sum="+sum);
        //1~200 %3=0 or %7=0  sum,avg
        int maxNumber=200;
        int numberOfSum=0;
        int numberCnt=1;
        int numberFlag=0;
        while (numberCnt<=maxNumber){
            if (numberCnt%3==0 || numberCnt%7==0){
                numberOfSum+=numberCnt;
                numberFlag++;
            }
            numberCnt++;
        }
        System.out.println("和:"+numberOfSum+" 平均值:"+numberOfSum*1.0/numberFlag);

        /*r
         *判断水仙花数
         * 三位数 各个位数的三次方的和等于这位数
         * abc=a^3+b^3+c^3
         */
        int waterOfNumber=131;



    }
}
