package com.zhiyou100.preview.day07;

/**
 * @author yanglei
 */
public class MethodTest {
    public static void main(String[] args) {
        //在主方法中调用方法
        System.out.println(getSumOfTwoInt(2,3));
        System.out.println(getSumOfOneAndTwo());
        printSumOfTheTwoInt(1,2);
    }
    public static void printSumOfTheTwoInt(int a,int b){
        /*
         * 特殊情况：没有返回值
         * 打印a和b的和
         */
        System.out.println(a+b);
    }
    public static void printHelloWord(int i){
        /*
         * 循环打印hello world
         */
        for (int j = 0; j <i; j++) {
            System.out.println("hello world");
        }
    }
    public static int getSumOfOneAndTwo(){
        /*
         *  特殊情况：不需要参数列表
         */
        return 1+2;
    }
    public static int getSumOfTwoInt(int a, int b){
        /*
         *  求a和b的和
         */
        return a+b;
    }

}
