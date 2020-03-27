package com.zhiyou100.basicclass.day26;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @packageName: javase_26
 * @className: JoinDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/26 10:27 上午
 *
 * 创建线程方式3：
 * 实现Callable接口，实现call方法，可以获取返回值
 */
public class CreateThreadDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 创建Callable的实现类对象，不要泛型
         * 创建FutureTask对象，关联Callable类的对象
         * 创建Thread对象，关联FutureTask对象
         * 开启线程
         */
        CallableImp callableImp = new CallableImp();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(callableImp);
        Thread thread = new Thread(integerFutureTask);
        thread.start();
        // 获取返回值
        int sum=integerFutureTask.get();
        System.out.println(sum);

    }
}
class CallableImp implements Callable<Integer>{
    /**
     * 创建Callable接口的实现类
     * 重写call方法
     *
     */
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 0; i < 100; i++) {
            System.out.println("i="+i);
            Thread.sleep(100);
            sum+=i;
        }
        return sum;
    }
}
