package com.zhiyou100.basicclass.day02;

import java.util.Scanner;

/**
 * @packageName: javaee_26
 * @className: HomeWorkMath
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/21 11:50 上午
 */
 class HomeWorkMath {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
//            System.out.println(HomeWorkOfMath.randomDate());
            System.out.println(HomeWorkOfMath.createNewName());
        }

    }
}

public class HomeWorkOfMath {
    public static double myRounding(double in) {
        /*
         * @name: rounding
         * @param: double in
         * @description: TODO 四舍六入，五取偶
         * @date: 2020/2/21 2:02 下午
         * @return: double
         */
        int flagOfTenths = (int) (in * 10.0 % 10);
        // flagOfTenths 获取十分上的数
        int flagOfSingles = (int) (in % 10);
        // 获取个数上的数
        int max=5;
        int evenNumber=2;
        if (flagOfTenths < max) {
            //四舍
            return (double) ((int) (in));
        } else if (flagOfTenths == max) {
            // 5取偶
            if (flagOfSingles % evenNumber == 0) {
                //偶数不变
                return (double) (((int) (in)));
            } else {
                //奇数加1
                return (double) (((int) (in)) + 1);
            }
        } else {
            // 六进
            return (double) (((int) (in)) + 1);

        }
    }

    public static boolean determineIfTheInputNumberIsPrime() {
        /*
         * @name: determineIfTheInputNumberIsPrime
         * @param: void
         * @description: TODO 判断键盘输入的数是不是质数
         * @date: 2020/2/21 4:05 下午
         * @return: boolean
         */
        Scanner scanner = new Scanner(System.in);
        // 获取键盘输入
        int number = scanner.nextInt();
        // 把键盘输入赋值给number
        boolean primeOfFlag = false;
        // 判断是否为质数，是质数true，否则false
        for (int i = 2; i <= (int) (Math.sqrt(number)); i++) {
            if (number % i == 0) {
                primeOfFlag = true;
                break;
            }
        }
        if (primeOfFlag || number == 1||number<1) {
            return false;
        } else {
            return true;
        }
    }

    public static String randomDate() {
        /*
         * @name: randomDate
         * @param:
         * @description: TODO 随机一个日期，格式 XXXX-XX-XX ,XX:XX:XX,范围1900-1-1 00:00:00 ~ 2020-12-31 23:59:60
         * @date: 2020/2/21 4:20 下午
         * @return:
         */
        final String thickStick = "-";
        final String colon = ":";

        int randomOfYear = randomOfMinToMax(1900, 2020);
        // 年 [1900,2020]
        int randomOfMonth = randomOfMinToMax(1, 12);
        // 月 [1,12]
        int randomOfDay = randomOfMinToMax(1, judgeTheDaysOfTheMonth(randomOfYear, randomOfMonth));
        //天 [1,judgeTheDaysOfTheMonth(randomOfYear,randomOfMonth)]

        int randomHours = randomOfMinToMax(0, 23);
        // 小时 [0~23]
        int randomMinute = randomOfMinToMax(0, 59);
        // 分钟 [0,59]
        int randomSecond = randomOfMinToMax(0, 59);
        //秒 [0,59]
        return addZero(randomOfYear) + thickStick + addZero(randomOfMonth) + thickStick + addZero(randomOfDay) + " " + addZero(randomHours) + colon + addZero(randomMinute) + colon + addZero(randomSecond);
    }

    public static String addZero(int num) {
        /*
         * @name: addZero
         * @param: int num
         * @description: TODO  把 1 变成 01
         * @date: 2020/2/21 5:43 下午
         * @return: String
         */
        int theUnit=10;
        if (num / theUnit == 0) {
            // 1/10 =  0，是个位
            return "0" + num;
        } else {
            return String.valueOf(num);
            // Int -> String
        }
    }

    public static int randomOfMinToMax(double min, double max) {
        /*
         * @name: randomOfMinToMax
         * @param: double min,double max
         * @description: TODO  生成 [min,max]的随机数
         * @date: 2020/2/21 5:17 下午
         * @return: int
         */
        return (int) (min + (int) (Math.random() * (max - min + 1)));
    }

    public static int judgeTheDaysOfTheMonth(int year, int month) {
        /*
         * @name: judgeTheDaysOfTheMonth
         * @param: int year ,int month
         * @description: TODO  判断本月有多少天
         * @date: 2020/2/21 5:00 下午
         * @return: int
         */
        boolean yearLag = (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
        // yearLag true为闰年，false为平年
        /*
         * 平年的2月份是28天
         * 闰年的2月份是29天
         */
        int maxDay = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                maxDay = 31;
                break;
            case 2:
                if (yearLag) {
                    maxDay = 29;
                } else {
                    maxDay = 28;
                }
                break;
            default:
                maxDay = 30;
        }
        return maxDay;
    }

    public static String createNewName() {
        /*
         * @name: createNewName
         * @param:
         * @description: TODO 随机生成一个由小写字母组成的名字,字母个数[4,8]
         * @date: 2020/2/21 5:57 下午
         * @return:
         */
        // a=97,z=122;
        String name = getRandomCharToString() + getRandomCharToString() + getRandomCharToString() + getRandomCharToString() + getRandomCharToString() + getRandomCharToString() + getRandomCharToString() + getRandomCharToString();
        // 拼接
        int randomNum = randomOfMinToMax(4, 8);
        return name.substring(0, randomNum);
        // 切片

    }

    public static String getRandomCharToString() {
        /*
         * @name: getRandomCharToString
         * @param:
         * @description: TODO  随机获取一个小写字母，转换为字符串
         * @date: 2020/2/21 6:27 下午
         * @return:
         */
        return String.valueOf((char) (randomOfMinToMax(97, 122)));
    }
}

