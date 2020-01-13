package com.zhiyou100.day05;

import javax.sound.midi.SoundbankResource;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author yanglei
 * 1 定义一个装10个int元素的数组：求元素的和
 * 2定义一个装10个int元素的数组：求平均数
 * 3定义一个装10个int元素的数组：获取最大值
 * 4定义一个装10个int元素的数组： 获取最大值元素的下标
 */
public class TextArray00 {
    public static void main(String[] args) {
        int[] array01=new int[10];
        for (int i = 0; i <array01.length; i++) {
            double rand = Math.random()*10;
            //随机生成1～9的随机数
            array01[i]=(int)rand;

        }
        int sum=0;
        int max=array01[0];
        int i;
        for (i = 0; i < array01.length; i++) {
            sum+=array01[i];
            if (array01[i]>array01[max]){
                max=array01[i];
            }
        }
        System.out.print("元素是："+ Arrays.toString(array01) +"元素的和:"+sum+" 平均值:"+(sum*1.0/10));
        for (i = 0; i < array01.length; i++) {

            if (array01[i]==max){
                System.out.print(" 最大值:"+max+" 最大值下标是:"+i+" ");
            }
        }

        /*
         *  定义一个装10个int元素的数组，获取次大值
         *  定义一个装10个double元素的数组，把所有的元素保留最多一位小数
         */

        int[] array02=new int[10];
        for (i = 0; i <array02.length; i++) {
            double rand = Math.random()*10;
            //随机生成1～9的随机数
            array02[i]=(int)rand;
        }

        System.out.println("\n"+"原数组"+Arrays.toString(array02));

        for (int j = 0; j <array02.length ; j++) {
            for (int k = 0; k <j ; k++) {
                if (array02[k+1]>array02[k]){
                    int temp;
                    temp=array02[k];
                    array02[k]=array02[k+1];
                    array02[k+1]=temp;
                }
            }
        }
        System.out.println("排序后原数组"+Arrays.toString(array02));

        System.out.println("原数组"+Arrays.toString(array02)+" 的次大值为"+array02[1]);

        double number=123.134;
        System.out.println(getNumberIntegerDigits(number));
        System.out.println(Math.pow(10,3));
        double numberInteger=number/(int)Math.pow(10,getNumberIntegerDigits(number));
        System.out.println(numberInteger);

        System.out.println(getDoubleDigits(number));

    }
    public  static int getDoubleDigits(double number){
        int flag=getNumberIntegerDigits(number);
        for (int i=0;i<=flag;i++){
            number/=10;
        }
        return (int) number;
    }
    public static double getDoubleNumberDigitsOne(double number){
//        double newNumber=number/Math.pow(getNumberIntegerDigits(number))
        return 0;
    }
    public static int getNumberIntegerDigits(double number){
        int flag=0;
        while ((int)(number)!=0){
            number/=10.0;
            flag++;
        }
        return flag;
    }
    public static int getNumberDecimalDigits(double number) {
        if (number == (long)number) {
            return 0;
        }
        int i = 0;
        while (true){
            i++;
            if (number * Math.pow(10, i) % 1 == 0) {
                return i;
            }
        }
    }


}
