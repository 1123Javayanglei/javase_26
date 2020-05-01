package com.zhiyou100.basicclass.day27.threadsafe;

/**
 * @packageName: javase_26
 * @className: ThreadSafeHomework
 * @Description: TODO 模拟四个窗口卖一张火车的100张🎫，要求：卖🎫时打印票号，从100到1
 * @author: YangLei
 * @date: 2020/3/27 10:36 下午
 */
public class ThreadSafeHomework {
    public static void main(String[] args) {
        TheTicketApplication theTicketApplication = new TheTicketApplication();
        theTicketApplication.number = new Votes();
        Thread thread = new Thread(theTicketApplication, "1⃣号售票口");
        Thread thread1 = new Thread(theTicketApplication, "2⃣售票口");
        Thread thread2 = new Thread(theTicketApplication, "3⃣号售票口");
        Thread thread3 = new Thread(theTicketApplication, "4⃣号售票口");

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class Votes {
    /**
     * @date: 2020/3/27 10:38 下午
     * @description: TODO 记录票数
     */
    int number = 100;
}

class TextDemo1 {
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

class Windows implements Runnable {
    /**
     * 记录火车票
     */
    Votes s;

    @Override
    public void run() {

            while (true) {
                synchronized (s) {
                if (s.number <= 0) {
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " 卖了一张票，票号是" + s.number);
                    try {
                        Thread.sleep(100);
                    } catch (Exception ignored) {

                    }
                    s.number--;
                }
            }
        }

    }
}

class TheTicketApplication implements Runnable {
    /**
     * @date: 2020/3/27 10:39 下午
     * @description: TODO 售票程序
     */
    Votes number;

    @Override
    public void run() {
        int max = 100;
        for (int i = max; i >= 1; i--) {
            /*
             * 我也不知道为啥，反正能编译通过
             */
            if (number.number <= 3) {
                return;
            } else {
                synchronized (number) {
                    System.out.println(Thread.currentThread().getName() + " 卖了第" + number.number + "张票");
                    number.number--;
                }
            }
        }

    }
}
