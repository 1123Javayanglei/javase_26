package com.zhiyou100.basicclass.day24;

/**
 * @packageName: javaSe_26
 * @className: ThreadDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/24 10:14 上午
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        for (int i = 0; i < 13; i++) {
            new Demo1();
        }

        System.gc();

        for (int i = 0; i < 13000; i++) {
            if (i % 1000 == 0) {
                System.out.println(i);
            }
        }
    }
}

class Demo1 {
    private static int n;
    public final int num;

    public Demo1() {
        n++;
        num = n;
        System.out.println("第" + num + "号对象创建完毕！");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("第" + num + "号对象的finalize方法被调用了");
    }
}

