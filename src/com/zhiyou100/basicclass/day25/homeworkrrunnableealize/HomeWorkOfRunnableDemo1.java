package com.zhiyou100.basicclass.day25.homeworkrrunnableealize;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;

/**
 * @packageName: javase_26
 * @className: HomeWorkOfRunnableDemo1
 * @Description: TODO 使用多线程模拟三个线程同时执行，随机打印50个随机数字，50个随机大写字母，50个随机小写字母
 * @author: YangLei
 * @date: 2020/3/25 6:02 下午
 */
public class HomeWorkOfRunnableDemo1 {
    public static void main(String[] args) {
        MyRunnable1 myRunnable1 = new MyRunnable1('a', 'b');
        MyRunnable1 myRunnable11 = new MyRunnable1('0', '9');
        MyRunnable1 myRunnable12 = new MyRunnable1('A', 'Z');
        // 创建实现类对象
        Thread thread = new Thread(myRunnable1);
        Thread thread1 = new Thread(myRunnable11);
        Thread thread2 = new Thread(myRunnable12);
        // 创建线程对象
        thread.start();
        thread1.start();
        thread2.start();
        // 开启线程

    }
}
class MyRunnable1 implements Runnable{
    /**
     * 创建Runnable的实现类
     */
    char start;
    char end;

    public MyRunnable1(char start, char end) {
        this.start = start;
        this.end = end;
    }

    public MyRunnable1() {
    }

    @Override
    public void run() {
        // 实现run方法
        int max=50;
        for (int i = 0; i < max; i++) {
            System.out.println((char) (HomeWorkOfMath.randomOfMinToMax((int)(start),(int)(end))));
        }
    }
}