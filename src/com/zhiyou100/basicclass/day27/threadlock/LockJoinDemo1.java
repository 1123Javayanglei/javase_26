package com.zhiyou100.basicclass.day27.threadlock;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;

/**
 * @packageName: javase_26
 * @className: LockJoinDemo1
 * @Description: TODO 死锁
 * @author: YangLei
 * @date: 2020/3/27 10:23 上午
 * <p>
 * 死锁：程序卡住，不能继续执行
 * <p>
 * join来死锁：两个线程互相调用对方的join方法
 */
public class LockJoinDemo1 {
    public static void main(String[] args) {
        RunImp runImp = new RunImp();
        RunImp runImp1 = new RunImp();
        Thread thread1 = new Thread(runImp, "线程1");
        Thread thread2 = new Thread(runImp1, "线程2");

        // 给实现类的thread属性赋值，记录要等待的线程对象
        runImp.thread = thread2;
        runImp1.thread = thread1;

        thread1.start();
        thread2.start();

    }
}

class RunImp implements Runnable {
    /**
     * 定义一个Thread 类型的引用，记录引用
     */
    Thread thread;

    @Override
    public void run() {
        int max = 50;
        for (int i = 0; i < max; i++) {
            int n = HomeWorkOfMath.randomOfMinToMax(0, 10);
            // 获取0到10的随机数
            System.out.println(Thread.currentThread().getName() + " " + n);
            // 打印当前线程名称
            try {
                Thread.sleep(100);
                // 使得当前线程休眠 100毫秒
            } catch (Exception ignored) {

            }
            if (n == 5) {
                // 如果等于5，调用thread的join方法
                try {
                    thread.join();
                } catch (Exception ignored) {

                }
            }
        }
    }
}
