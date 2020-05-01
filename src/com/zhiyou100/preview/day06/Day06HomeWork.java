package com.zhiyou100.preview.day06;

import java.util.Arrays;

/**
 * @author yanglei
 */
public class Day06HomeWork {
    public static void main(String[] args) {
//        homeOne();
//        System.out.println();
//        homeTwo();
//        System.out.println();
        homeFive();
//
//        System.out.println();
//
//        printPascalIsTriangle(10);
//
//        System.out.println();
//        collatzConjecture();

//        sortTwo();
    }

    public static void collatzConjecture(){
        /*
         * 角谷猜想
         *  number
         *  偶数 number / 2
         *  奇数 number *3+1
         *
         *  最后number等于1
         */
        for (int i = 10; i <=1000 ; i++) {
            int number = i;
            int tmp = number;
            int flag = 0;
            while (number != 1) {
                if (number % 2 == 0) {
                    number /= 2;
                    flag++;
                } else {
                    number = number * 3 + 1;
                    flag++;
                }
            }
            System.out.println(tmp + "需要" + flag + "次");
        }
    }

    public static void printPascalIsTriangle(int i){
        /*
        1
        1	1
        1	2	1
        1	3	3	1
        1	4	6	4	1
        1	5	10	10	5	1
        1	6	15	20	15	6	1
        1	7	21	35	35	21	7	1
        1	8	28	56	70	56	28	8	1
         */
        /*
         * 总结规律:
         *  1.每层都比上层元素个数多一个
         *  2.每层的起始和结束都是1
         *  3.除了起始和结束，其他元素：row[j][k] = (row[j - 1][k - 1] + row[j - 1][k]); 左上角和上方的元素之和 e.g.6=3+3 4=1+3 6=5+1
         */
        int [][] row= new int[i][i];
        for (int j = 0; j <row.length ; j++) {
            for (int k =j;k>=0 ; k--) {
                if (j==k||k==0){
                    //起始和结束的条件
                    row[j][k]=1;
                }else {
                    row[j][k] = (row[j - 1][k - 1] + row[j - 1][k]);
                }
            }
        }
        for (int j = 0; j < row.length; j++) {
            for (int k = 0; k < row[j].length; k++) {
                if (row[j][k]!=0) {
                    System.out.print(row[j][k] + "\t");
                }
            }
            System.out.println();
        }
    }
    public static void homeFive(){
        int[] arrayOfPrimeNumber = new int[1000];
        //从2开始到1000的素数的个数是168个
        //获取从2开始到1000的质数
        int l = 0;
        for (int i = 2; i <= 1000; i++) {
            boolean flag = false;
            for (int j = 2; j <= (int) (Math.sqrt(i)); j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag || i == 1) {

            } else {
                arrayOfPrimeNumber[l++] = i;
            }

        }
        for (int homeFiveFlag = 4; homeFiveFlag < 1000; homeFiveFlag+=2) {
            //开始测试
            int testFlag;
            /*
             * testFlag 记录在质数中第一个大于test的下标
             * 组成test两个质数的必定小于test
             * 
             * 转换思想：
             * 因为 一个质数+一个质数 = 一个偶数
             * 所以  一个偶数 - 一个质数 == 一个质数
             */
            for (testFlag = 0; testFlag < arrayOfPrimeNumber.length; testFlag++) {
                if (arrayOfPrimeNumber[testFlag] > homeFiveFlag) {
                    break;
                }
            }
            int[] arrayOfTheTest = new int[homeFiveFlag];
            //arrayOfTheTest 放 （test数据 - 可以用的质数库内的质数）的一个数，再加上不为负数的判断 数组内还会有零，去零
            for (int i = 0; i < homeFiveFlag; i++) {
                if (homeFiveFlag - arrayOfPrimeNumber[i] > 0) {
                    arrayOfTheTest[i] = homeFiveFlag - arrayOfPrimeNumber[i];
                }
            }
            int arrayOfThetest = 0;
            //判断不为零
            for (int i = 0; i < arrayOfTheTest.length; i++) {
                if (arrayOfTheTest[i] != 0) {
                    arrayOfThetest++;
                }
            }
            //重新把范围内的 (test-小于test的质数)=另一个质数[无零，无负数]
            int[] arrayOfTheTestTrue = new int[arrayOfThetest];
            for (int i = 0; i < arrayOfTheTestTrue.length; i++) {
                arrayOfTheTestTrue[i] = arrayOfTheTest[i];
            }
            //去零 操作 ，现在arrayOfTheTestTrue为可用的 （test数据 - 小于test数据的素数）库，
            // 拿这个库和 小于这个数的质数库中的最大小标比较（testFlag)
            
            boolean testOfTheFlag = false;
            //定义 testOfTheFlag = false
            //遍历 arrayOfTheTestTrue 和 arrOfPrimeNumber[0,testFlag] ,若有相等的，则说明这个偶数可以通过判断

            int getNumberOfOne=0,getNumberOfTwo=0;
            for (int i = 0; i < arrayOfTheTestTrue.length; i++) {
                for (int j = 0; j < testFlag; j++) {
                    if (arrayOfTheTestTrue[i] == arrayOfPrimeNumber[j]) {
                        getNumberOfOne=arrayOfPrimeNumber[j];
                        testOfTheFlag = true;
                        break;
                    }
                }
            }
            getNumberOfTwo=homeFiveFlag-getNumberOfOne;
            System.out.println(homeFiveFlag+" = "+getNumberOfOne+" + "+getNumberOfTwo+" 是 "+testOfTheFlag);
        }
    }
    public static void printOneDimensionalArray(int[] array){
        for (int i = 0; array[i]!=0 ; i++) {
            System.out.print(array[i]+"\n");
        }
    }
    public static void printTwoDimensionalArray(int[][] array){
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length; j++) {
                System.out.print("["+i+"] ["+j+"] = "+array[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void sortTwo(){
        int[] arrayOne={1,4,8,9,0,23,1,2,};

        //选择排序
        for (int i = 0; i < arrayOne.length-1; i++) {
            for (int j = i+1; j < arrayOne.length; j++) {
                //拿arrayOne[i]和arrayOne[j]做比较
                if (arrayOne[i]<arrayOne[j]){
                    int tmp=arrayOne[i];
                    arrayOne[i]=arrayOne[j];
                    arrayOne[j]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arrayOne));

        int[] arrayTwo={1,4,8,9,0,23,1,2,};

        //冒泡排序
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayOne.length-1; j++) {
                //拿arrayTwo[j+1]和arrayTwo[j]做比较
                if (arrayOne[j+1]<arrayOne[j]){
                    int tmp=arrayOne[j+1];
                    arrayOne[j+1]=arrayOne[j];
                    arrayOne[j]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arrayOne));
    }
    public static void homeTwo(){
        int[][] array=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //创建int类型的二维数组并赋值

        for (int i = 0; i < array.length; i++) {
            //i 一维数组的个数
            int sum=0;
            int flag=0;
            //遍历二维数组
            for (int j = 0; j < array[i].length; j++) {
                //j 当前一维数组的元素
                sum+=array[i][j];
                flag++;
            }
            System.out.println("第"+i+"行的平均值等于:"+((sum*1.0)/flag));
            System.out.println("第"+i+"行的平均值等于:"+((sum*1.0)/array[i].length));
            //array[i].length 当前一维数组的个数
        }

    }
    public static void homeOne(){
        /*
         *创建一个二维数组，求平均值
         */
        int[][] array=new int[][]{{1,2,3,},{1,3,5,6,4,},{1,2},{3},};
        //创建int类型的二维数组并赋值
        int sum=0,flag=0,flagOne=0;

        for (int i = 0; i < array.length; i++) {
            //i 一维数组的个数
            for (int j = 0; j < array[i].length; j++) {
                //j 当前一维数组的元素
                sum+=array[i][j];
                //sum 累加
                flag++;
                //flag 计算元素的个数
            }
            flagOne+=array[i].length;
            // flagOne 当前一维数组的元素的个数
        }
        System.out.println("平均值是："+((sum*1.0)/flag));
    }
}
