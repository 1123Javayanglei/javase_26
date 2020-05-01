package com.zhiyou100.basicclass.day25.homeworkrrunnableealize;

/**
 * @packageName: javase_26
 * @className: HomeWorkOfRunnableDemo2
 * @Description: TODO 模拟5个学生同时给老是交作业
 * @author: YangLei
 * @date: 2020/3/25 6:11 下午
 */
public class HomeWorkOfRunnableDemo2 {
    public static void main(String[] args) {
        MyRunnable2 myRunnable1 = new MyRunnable2();


        Thread thread1 = new Thread(myRunnable1);
        Thread thread2= new Thread(myRunnable1);
        Thread thread3 = new Thread(myRunnable1);
        Thread thread4 = new Thread(myRunnable1);
        Thread thread5 = new Thread(myRunnable1);

        thread1.setName("张三");
        thread2.setName("赵四");
        thread3.setName("王舞");
        thread4.setName("王陆");
        thread5.setName("王富贵");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
class MyRunnable2 implements Runnable{
    static int num=0;
    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        // 获取当前线程的名字
        for (int i = 1; i <4 ; i++) {
            num++;
            System.out.println(name+"的第 "+i+"本作业提交了，老师的作业总数"+num);
        }
    }
}
