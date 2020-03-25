package com.zhiyou100.basicclass.day25;

/**
 * @packageName: javase_26
 * @className: TheadMethod2Demo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/25 11:41 上午
 *
 * 创建线程方式2：
 *  声明实现Runnable 接口的类.
 *  然后实现run方法，然后可以分配该类的实例，在创建Thread时作为一个参数来传递并启动
 */
public class TheadMethod2Demo1 {
    public static void main(String[] args) {
        /**
         * 创建实现类对象
         * 创建Thread对象，通过构造方法参数列表关联实现类对象
         * 开启线程
         */
        Demo1 demo1 = new Demo1();
        Thread t=new Thread(demo1);
        t.setName("link start");
        t.start();
    }
}
class Demo1 implements Runnable{
    /**
     *  创建Runnable的实现类
     *  实现run方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+"--------i="+i);
        }
    }
}