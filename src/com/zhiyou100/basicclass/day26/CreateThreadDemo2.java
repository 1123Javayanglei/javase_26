package com.zhiyou100.basicclass.day26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @packageName: javase_26
 * @className: CreateThreadDemo2
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/26 10:47 上午
 */
public class CreateThreadDemo2 {
    public static void main(String[] args) {
        /**
         * 创建Runnable的实现类
         * 实现run方法
         *
         * 创建ExecutorService对象（线程池对象）
         * 创建Runnable实现类对象
         * 调用ExecutorService对象的execute方法 ，并传递Runnable实现类对象
         * 关闭线程
         */
        ExecutorService executorService= Executors.newCachedThreadPool();
        TestRunnable testRunnable = new TestRunnable();
        executorService.execute(testRunnable);
        executorService.execute(testRunnable);
        executorService.execute(testRunnable);
        executorService.execute(testRunnable);
        executorService.execute(testRunnable);
        executorService.execute(testRunnable);
        executorService.execute(testRunnable);
        executorService.shutdown();
    }
}
class TestRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"被调用了");
    }
}
