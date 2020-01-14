package com.zhiyou100.day09;

/**
 * @author yanglei
 */
public class Day09Test {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println("第" + i + "个月兔子有：" + fibonacci(i));
        }
    }

    public static long fibonacci(long number) {
        if (number >= 0 && number <= 3) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }

    }

    public static void inputNumberOutStart(int number) {
        number = 3;

    }

    public static void findFiveNumber() {
        // find min to max Math.pow((ab+cd),2)==a b c d
        int min = 1000;
        int max = 9999;
        for (int i = min; i <= max; i++) {
            int a = i / 1000;
            int b = i / 100 % 10;
            int c = i / 10 % 10;
            int d = i % 10;
            boolean flag = (int) (Math.pow(((a * 10 + b) + (c * 10 + d)), 2)) == i;
            if (flag) {
                System.out.println(i);
            }
        }
    }
}
