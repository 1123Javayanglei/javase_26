package com.zhiyou100.day07;

/**
 * @author yanglei
 */
public class MethodOfPracticeAtNoon {
    public static void main(String[] args) {

        getJudgingPrimeNumbersOf1And100();
        leapYear(2019);
        yearAndMonthIsDay(2019,2);
        leftBottomPint();
        int[] array={1,23,5,6,};
        System.out.println(getMaxOfTheArray(array));
        getSortTheArray(array);
        printTheSort(array);

    }
    public static void printTheSort(int[] array){
        for (int value :
                array) {
            System.out.print(value+" ");
        }
        System.out.println();
    }
    public static void getSortTheArray(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if (array[i]<array[j]){
                    int tmp=array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }
    public static int getMaxOfTheArray(int[] array){
        int max=array[0];
        for (int i = 0; i < array.length; i++) {
            if (max<array[i]){
                max=array[i];
            }
        }
        return max;
    }
    public static void getJudgingPrimeNumbersOf1And100(){
        System.out.println("1到100的所有质数:");
        int numberSum=0;
        int numberCnt=0;
        for (int j = 1; j <100 ; j++) {
            boolean flag=false;
            for (int i =2; i <=(int)(Math.sqrt(j)) ; i++) {
                if (j % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag||j==1){

            }else {
                numberCnt++;
                numberSum+=j;
                System.out.print(j+" ");
            }
        }
        System.out.println();
        System.out.println("1到100的所有质数的平均数:"+((numberSum*1.0)/(numberCnt*1.0)));
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

    public static void yearAndMonthIsDay(int year,int month){
        /*
         * 平年的2月份是28天
         * 闰年的2月份是29天
         */
        int []oneArr={31,28,31,30,31,30,31,31,30,31,30,31};
        boolean yearFlag=( ((year%4==0) &&(year%100!=0)) || (year%400==0)  );
        //闰年为true，平年为false
        if (month<0||month>12){
            System.out.print("大哥，回火星吧，地球不适合你");
        }else if (month!=2){
            System.out.print(year+"年的"+month+"月份有"+oneArr[month-1]+"天");
        }else {
            if (yearFlag){
                System.out.print(year+"年的"+month+"月份有"+29+"天");
            }else {
                System.out.print(year+"年的"+month+"月份有"+28+"天");
            }
        }
        if (yearFlag){
            System.out.print(" "+year+"共有366天");
        }else {
            System.out.print(" "+year+"共有365天");
        }
        System.out.println();
    }
    public static void leftBottomPint(){
        for (int i = 1; i <10 ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(" "+i+"*"+j+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }

}
