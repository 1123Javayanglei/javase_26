package com.zhiyou100.basicclass.day26;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;

/**
 * @packageName: javase_26
 * @className: CreateThreadDemo3
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/26 11:36 上午
 * <p>
 * Thread类的 join方法
 * void join();
 * 在a线程对象的线程任务中调用b线程对象的join方法
 * a线程终止，等待b线程执行完毕，a线程才继续执行
 * <p>
 * 使用场景：
 * 当a线程的线程任务中需要b线程的执行结果
 */
public class CreateThreadDemo3 {
    public static void main(String[] args) {
        PrintMethod printMethod = new PrintMethod();
        PrintMethod printMethod1 = new PrintMethod();

        printMethod.start = 'A';
        printMethod.end = 'Z';

        printMethod1.start = 'a';
        printMethod1.end = 'z';

        new Thread(printMethod).start();
        new Thread(printMethod1).start();

    }
}

class PrintMethod implements Runnable {
    char start;
    char end;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println((char) (HomeWorkOfMath.randomOfMinToMax((int) (start), (int) (end))));
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

