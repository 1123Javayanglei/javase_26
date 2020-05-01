package com.zhiyou100.basicclass.day27.threadlock;

/**
 * @packageName: javase_26
 * @className: LockJoinDemo02
 * @Description: TODO 死锁方法2 两个同步代码块嵌套
 * @author: YangLei
 * @date: 2020/4/8 8:58 下午
 */
public class LockJoinDemo02 {
    public static void main(String[] args) {
        SynchronizedCodeBlocksAreNested synchronizedCodeBlocksAreNested1 = new SynchronizedCodeBlocksAreNested();
        SynchronizedCodeBlocksAreNested synchronizedCodeBlocksAreNested2 = new SynchronizedCodeBlocksAreNested();
        // 创建两个线程对象
        Object o1 = new Object();
        Object o2 = new Object();
        // 创建两个锁对象
        synchronizedCodeBlocksAreNested1.internalLock=o1;
        synchronizedCodeBlocksAreNested1.externalLock=o2;

        synchronizedCodeBlocksAreNested2.internalLock=o2;
        synchronizedCodeBlocksAreNested2.externalLock=o1;

        // 给两个线程对象的锁对象属性赋值

        synchronizedCodeBlocksAreNested1.start();
        synchronizedCodeBlocksAreNested2.start();
        // 开启线程

    }
}

class SynchronizedCodeBlocksAreNested extends Thread {
    /**
     * @date: 2020/4/8 9:00 下午
     * @description: TODO 两个同步代码块嵌套
     */
    Object internalLock;
    Object externalLock;
    /**
     * internal 内
     * external 外
     *  定义内锁和外锁对象
     */
    @Override
    public void run() {
        while (true){
            synchronized (externalLock){
                System.out.println(getName()+" 拿到其外锁 "+externalLock);
                synchronized (internalLock){
                    System.out.println(getName()+" 拿到其内锁 "+internalLock);
                }
                System.out.println(getName()+" 释放其外锁 "+externalLock);
            }
        }
    }
}
