package com.zhiyou100.basicclass.day27.threadsafe;

/**
 * @packageName: javase_26
 * @className: ThreadSafeHomeWorkDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/28 5:52 下午
 *
 * 当方法的方法体是同步代码时，可以把方法定义为同步方法
 *  对于普通同步方法，锁是当前实例对象
 *  对于静态同步方法，锁是当前类的Class对象
 *  对于同步方法块，锁是Synchronized括号里配置的对象
 *
 */
public class ThreadSafeHomeWorkDemo1 {
    public static void main(String[] args) {
        Windows windows = new Windows();
        Votes votes = new Votes();

        windows.s = votes;

        new Thread(windows, "窗口1").start();
        new Thread(windows, "窗口2").start();
        new Thread(windows, "窗口3").start();
        new Thread(windows, "窗口4").start();
        /**
         * 同一个票号 被打印两次，a线程
         */
    }
}

class Votes1 {
    /**
     * @date: 2020/3/27 10:38 下午
     * @description: TODO 记录票数
     */
    int number = 100;
}

class Windows1 implements Runnable {
    /**
     * 记录火车票
     */
    Votes s;

    @Override
    public void run() {
        /**
         * 为了测试同步实例方法的锁对象是this，让线程任务在synchronousTickets和synchronousTickets1之间切换
         * 如果同步，说明锁对象相同
         */
        boolean b=true;
        while (true){
            if (b){
                synchronousTickets();
            }else {
                synchronousTickets1();
                b=!b;
            }
        }
    }
    public void synchronousTickets1(){
        /*
         *  同步代码快
         */
        synchronized (this){
            if (s.number > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖了一张票，票号是" + s.number);
                try {
                    Thread.sleep(100);
                } catch (Exception ignored) {

                }
                s.number--;
            }
        }
    }
    public synchronized void synchronousTickets(){
        /**
         * 同步方法
         */

        if (s.number > 0) {
            System.out.println(Thread.currentThread().getName() + " 卖了一张票，票号是" + s.number);
            try {
                Thread.sleep(100);
            } catch (Exception ignored) {

            }
            s.number--;
        }
    }
}