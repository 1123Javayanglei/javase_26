package com.zhiyou100.basicclass.day26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @packageName: javase_26
 * @className: CreateThreadDemo2
 * @Description: TODO 线程池创建线程
 * @author: YangLei
 * @date: 2020/3/26 10:47 上午
 * 创建Runnable的实现类
 *
 * 实现run方法
 * 创建ExecutorService对象（线程池对象）
 * 创建Runnable实现类对象
 * 调用ExecutorService对象的execute方法 ，并传递Runnable实现类对象
 * 关闭线程
 */
public class CreateThreadDemo2 {
    public static void main(String[] args) {
        // 创建线程池对象
        ExecutorService executorService= Executors.newCachedThreadPool();
        // 创建Runnable实现类对象
        TestRunnable testRunnable = new TestRunnable();
        // 调用ExecutorService对象的execute方法，传递Runnable实现类对象
        executorService.execute(testRunnable);
        executorService.execute(testRunnable);
        executorService.execute(testRunnable);
        executorService.execute(testRunnable);
        executorService.execute(testRunnable);
        executorService.execute(testRunnable);
        executorService.execute(testRunnable);
        // 关闭线程
        executorService.shutdown();

    }
}
class TestRunnable implements Runnable{
    /**
     * @name: run
     * @date: 2020/4/6 9:34 下午
     * @description: TODO 创建Runnable的实现类
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"被调用了");
    }
}
