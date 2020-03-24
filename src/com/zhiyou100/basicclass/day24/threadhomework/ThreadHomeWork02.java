package com.zhiyou100.basicclass.day24.threadhomework;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;

/**
 * @packageName: javase_26
 * @className: ThreadHomeWork02
 * @Description: TODO 作业2: 使用多线程模拟三个线程 同时执行  分别打印50个随机数字字符 50个随机小写字符  50个随机大写字符
 * @author: YangLei
 * @date: 2020/3/24 4:14 下午
 */
public class ThreadHomeWork02 {
    public static void main(String[] args) {
        // 创建对象
        RandomlyPrintedUppercaseCharacters randomlyPrintedUppercaseCharacters = new RandomlyPrintedUppercaseCharacters();
        PrintRandomLowercase printRandomLowercase = new PrintRandomLowercase();
        PrintRandomNumbers printRandomNumbers = new PrintRandomNumbers();
        // 启动
        randomlyPrintedUppercaseCharacters.start();
        printRandomLowercase.start();
        printRandomNumbers.start();
    }
}
class RandomlyPrintedUppercaseCharacters extends Thread{
    /**
     * 随机打印大写字母
     */
    @Override
    public void run() {
        InTwoNumberPrint.print50Times((int)('A'),(int)('Z'));
    }
}
class PrintRandomLowercase extends Thread{
    /**
     * 随机打印小写字母
     */
    @Override
    public void run() {
        InTwoNumberPrint.print50Times((int)('a'),(int) ('z'));
        // 随机 97~122
    }
}
class PrintRandomNumbers extends Thread{
    /**
     * 随机打印数字
     */
    @Override
    public void run() {
        InTwoNumberPrint.print50Times((int)('0'),(int) ('9'));
        // 随机48到57，0和9的字符编码
    }
}
class InTwoNumberPrint{
    static void printf(int start,int end){
        System.out.println((char) (HomeWorkOfMath.randomOfMinToMax(start,end)));
    }
    static void print50Times(int start, int end){
        int max=50;
        for (int i = 0; i < max; i++) {
            printf(start,end);
        }
    }
}
