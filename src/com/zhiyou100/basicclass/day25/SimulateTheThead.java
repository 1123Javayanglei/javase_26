package com.zhiyou100.basicclass.day25;

/**
 * @packageName: javase_26
 * @className: SimulateTheThead
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/25 5:51 下午
 * <p>
 * Thead 类有自己的run方法，Runnable接口也有run方法
 * 当继承Thread重写run方法时，线程开启，虚拟机执行的时Thread类的run方法
 * 当实现Runnable接口，实现run方法时，线程开启，虚拟机执行的是runnable的run方法
 */
public class SimulateTheThead {
}

interface MyRunnable {
    /**
     * @param: 无
     * @Description: TODO 接口
     * @return : 无
     * @author: 杨磊
     */
    void run();
}

class MyThread {
    private MyRunnable myRunnable;

    public MyThread() {
    }

    public MyThread(MyRunnable myRunnable) {
        this.myRunnable = myRunnable;
    }

    public void run() {
    }

    public void start() {
        // 线程开启虚拟机自动调用run方法
        if (myRunnable == null) {
            this.run();
        } else {
            this.myRunnable.run();
        }
    }
}
