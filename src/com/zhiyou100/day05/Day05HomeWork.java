package com.zhiyou100.day05;

import java.util.Arrays;

/**
 * @author yanglei
 */
public class Day05HomeWork {
    public static void main(String[] args) {

        int[] array01=new int[10];

        for (int i = 0; i <array01.length; i++) {
            double rand = Math.random()*10;
            //随机生成1～9的随机数
            array01[i]=(int)rand;
        }

        getMidMax(array01);

        System.out.println();

        double[] arrayOfDouble={1.163,4.325,3.134,5.435,534.35};

        getNumberOfDoubleToOne(arrayOfDouble);

        System.out.println();

        get10IntToElementAssignment(array01);

        System.out.println();

        getArrayForFive();

        getArrayForFave();

        getArrayForSix(1,1000);

        for (int i = 1; i <=1000000 ; i++) {
            judgmentCompletionOfSeven(i);
        }




    }

    public static void judgmentCompletionOfSeven(int num){
        int[] array =new int[num+1];
        for (int i = 1,j=0; i <num ; i++) {
            if (num%i==0){
                array[j]=i;
                j++;
            }
        }
        int sum=0;
        for (int i = 0; i <array.length; i++) {
            sum+=array[i];
        }

        if (num==sum){
            System.out.println(" "+num+"是完数");
        }else {
//            System.out.println(" "+num+"不是完数");
        }

    }
    
    public static int getDigit(int number){
        int flag=0;
        while (number!=0) {
            number /= 10;
            flag++;
        }
        return flag;
    }

    public static void getArrayForSix(int i,int j){
        int sum=0;
        int flag=0;
        for (;i<j;i++){
            boolean booleanFlag=false;
            for (int k = 2; k <=(int)(Math.sqrt(i)); k++) {
                if (i%k==0){
                    booleanFlag=true;
                    break;
                }
            }
            if (booleanFlag||i==1){

            }else {
                boolean digitFlag=((i/100!=0)&&(i%10==0||i/10%10==0||i/100==0));
                if (digitFlag){
                    sum+=i;
                    flag++;
                }
            }
        }
        System.out.println("平均值为:"+(sum*1.0/flag));
    }

    public static void getArrayForFave() {
        int[] arrayForFiveOne={1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i <= arrayForFiveOne.length; i++) {
            System.out.print(i+" ");
            for (int j = 1; j <=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void getArrayForFive(){
        //定义一个装10个int元素的数组arr并给元素赋值  再创建一个新的数组来装arr中所有的质数元素

        int[] arrayForFiveOne={1,2,3,4,5,6,7,8,9,10};
        int arrayCnt=0;
        for (int indexFlag = 0; indexFlag <arrayForFiveOne.length ; indexFlag++) {
            boolean flag=false;
            for (int i = 2; i <=(int)(Math.sqrt(arrayForFiveOne[indexFlag])) ; i++) {
                if (arrayForFiveOne[indexFlag]%i==0){
                    flag=true;
                    break;
                }
            }
            if (flag||arrayForFiveOne[indexFlag]<=1){

            }else {
                arrayCnt++;
            }
        }
        int[] arrayForFiveTwo = new int[arrayCnt];
        for (int i = 0,l=0; i < arrayForFiveOne.length; i++) {
            boolean arrayForFiveFlag=false;
            for (int j = 2; j <=(int)(Math.sqrt(arrayForFiveOne[i])) ; j++) {
                if (arrayForFiveOne[i]%j==0){
                    arrayForFiveFlag=true;
                    break;
                }
            }
            if (arrayForFiveFlag||arrayForFiveOne[i]<=1){

            }else {
                arrayForFiveTwo[l]=arrayForFiveOne[i];
                l++;
            }
        }
        System.out.println("质数的数组:"+Arrays.toString(arrayForFiveTwo));

    }


    public static void get10IntToElementAssignment(int[] array){
        System.out.println("\n"+"原数组"+"\n"+ Arrays.toString(array));
        for (int i = 0; i <10; i++) {
            if (array[i]%2==0){
                array[i]=array[i]-1;
            }else {
                array[i]=array[i]*2;
            }
        }
        System.out.println("操作后:");
        for (int a :
                array) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void getNumberOfDoubleToOne(double[] array){
        System.out.println("数组保留前:");
        for (double value :
                array) {
            System.out.print(value+" ");
        }
        for (int i = 0; i <array.length; i++) {
            int flag=(int)(array[i]*100%10);
            if (flag>=5){
                array[i]=(int)((array[i]*10+1)/10*10)*1.0/10;
            }else {
                array[i]=(int)(array[i]*10)*1.0/10;
            }
        }
        System.out.println("\n"+"保留后"+"\t");
        for (double val :
                array) {
            System.out.print(val+" ");
        }
    }

    public static void getMidMax(int[] array02){
        System.out.println("\n"+"原数组"+ Arrays.toString(array02));

        for (int j = 0; j <array02.length ; j++) {
            for (int k = 0; k <array02.length-1 ; k++) {
                if (array02[k+1]>array02[k]){
                    int temp;
                    temp=array02[k];
                    array02[k]=array02[k+1];
                    array02[k+1]=temp;
                }
            }
        }
        System.out.println("排序后原数组"+Arrays.toString(array02));

        int midMax=array02[0];
        for (int i = 0; i < array02.length; i++) {
            if (midMax!=array02[i]){
                midMax=array02[i];
                break;
            }
        }
        System.out.println("原数组"+Arrays.toString(array02)+" 的次大值为"+midMax);
    }
}
