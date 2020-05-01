package com.zhiyou100.preview.day03;

/**
 * @author yanglei
 */
public class ProcessControl {
    public static void main(String[] args) {
        /*
         *选择结构：单分支
         *练习：
         * 1.a,b,c 求Max
         * 2.月份判断季节 345 678 9,10,11 12,1,2
         * 3.判断闰年 4年一闰 百年不闰 四百年再闰
         * 公元年分除以4可整除但除以100不可整除，为闰年。 公元年分除以400可整除，为闰年。
         * 4.根据月份和年判断此年此月有多少天
         */
        for (int i = 1696; i <=2032 ; i++) {

            leapYear(i);
        }
    }
    public static void yearAndMonthIsDay(int year,int month){
        /*
         * 平年的2月份是28天
         * 闰年的2月份是29天
         */
        int []oneArr={31,28,31,30,31,30,31,31,30,31,30,31};
        boolean yearFlag=( ((year%4==0) &&(year%100!=0)) || (year%400==0)  );
        //闰年为true，平年为false
        if (month<0||month>12){
            System.out.println("大哥，回火星吧，地球不适合你");
        }else if (month!=2){
            System.out.println(year+"年的"+month+"月份有"+oneArr[month-1]+"天");
        }else {
            if (yearFlag){
                System.out.println(year+"年的"+month+"月份有"+29+"天");
            }else {
                System.out.println(year+"年的"+month+"月份有"+28+"天");
            }
        }

    }
    public static void leapYear(int year){
        //公元年分除以4可整除但除以100不可整除，为闰年。 公元年分除以400可整除，为闰年。
        boolean yearLag=( ((year%4==0) &&(year%100!=0)) || (year%400==0)  );
        if(yearLag){
            System.out.println(year+"年是闰年");
        }else {
            System.out.println(year+"年是平年");
        }
    }
    public static int thereNumberOfMax(int a,int b,int c){
        int max=0;
        if (a>b&&a>c){
            max=a;
        }
        if (b>a&&b>c){
            max=b;
        }
        if (c>a&&c>b){
            max=c;
        }
        return max;
    }
    public  static void judgingTheSeason(int season){
        if (season<=0||season>12){
            System.out.println("大哥，你混哪个星球的？不是地球的吧");
        }else if(season>=3&&season<=5){
            System.out.println("春天来了，万物到了交配的季节");
        }else if(season>=6&&season<=8){
            System.out.println("夏天到了");
        }else if(season>=9&&season<=11){
            System.out.println("秋天到了");
        }else {
            System.out.println("Winter is coming");
        }
    }
}
