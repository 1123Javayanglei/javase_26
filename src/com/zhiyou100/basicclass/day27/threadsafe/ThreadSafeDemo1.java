package com.zhiyou100.basicclass.day27.threadsafe;

/**
 * @packageName: javase_26
 * @className: ThreadSafeDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/27 8:50 下午
 * <p>
 * <p>
 * 同步代码块解决线程安全问题：
 * <p>
 * 同步代码块格式
 * synchronized(锁对象){
 * 当前线程操作共享数据的所有代码
 * }
 * <p>
 * 锁对象：可以是任意对象，仅仅是一种标志，哪个线程拿到锁对象，哪个线程就有共享数据的使用权，别的线程要使用共享数据就需要等待
 * <p>
 * 注意1：synchronized 必须包含了当前线程操作共享数据的所有代码
 * 注意2：锁对象必须唯一，所有线程必须使用的同一个锁对象
 */
public class ThreadSafeDemo1 {
    public static void main(String[] args) {
        Student student = new Student();
        // 创建一个实现类对象
        student.teacher = new Teacher();
        // 给实现类对象的 teacher赋值
        Thread thread1 = new Thread(student, "张三");
        Thread thread2 = new Thread(student, "李四");
        Thread thread3 = new Thread(student, "王舞");
        Thread thread4 = new Thread(student, "洛璃");
        Thread thread5 = new Thread(student, "王富贵");
        // 创建5个线程，五个线程对象的线程完全一样
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

class Teacher {
    int number = 0;
}

class Student implements Runnable {
    /**
     * 五个学生同时给一个老师交3本作业
     */
    Teacher teacher;

    @Override
    public void run() {
        int max = 3;
        for (int i = 1; i <= max; i++) {
            synchronized (teacher) {
                // 把共享数据teacher作为锁对象
                teacher.number++;
                try {
                    Thread.sleep(10);
                } catch (Exception ignored) {
                }
                System.out.println(Thread.currentThread().getName() + " 交第" + i + "本作业：：：老师作业总数" + teacher.number);
            }
        }
        try {
            Thread.sleep(10);
            // 线程休眠 增加锁对象换手概率
        } catch (Exception ignored) {

        }
    }
}