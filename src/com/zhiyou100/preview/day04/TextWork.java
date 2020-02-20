package com.zhiyou100.preview.day04;

/**
 * @author yanglei
 */
public class TextWork {
    public static void main(String[] args) {
        int sumOfHundredAndThousand=0;
        for (int i = 100; i <=1000; i++) {
            if (i%2==0||i%7==0){
                sumOfHundredAndThousand+=i;
            }
        }
        System.out.println("1到1000内可以被2或7整除的所有数的和是"+sumOfHundredAndThousand);

        int sumOf100And999=0;
        for (int i =100; i <=999; i++) {
            boolean flag=(i%3==0&&(i%10==1||i/10%10==1||i/100==1));
            if (flag){
                sumOf100And999+=i;
            }
        }
        System.out.println("100到999内可以被3整除并且位数上有1的所有数的和是："+sumOf100And999);

        int sumOfThere=0,i;
        for (i=1; sumOfThere<1500 ; i++) {
            sumOfThere+=i;
        }
        System.out.println("从1开始求和 和第一次加到1500时，加到"+(i-1));

        int sumOf100And1000Cnt=0,sunOf100And1000Sum=0;
        for (int j = 100; j <=1000; j++) {
            if (j%2==0 && j%7==0)
            {
                sunOf100And1000Sum+=j;
                sumOf100And1000Cnt++;
            }
        }
        System.out.println("100到1000内可以被2和7整除的所有数的和是："+sumOf100And1000Cnt);

        for (int j = 100; j <=1000; j++) {
            if (j%2==0 && j%7==0)
            {
                sunOf100And1000Sum+=j;
                sumOf100And1000Cnt++;
            }
        }


    }
}
