package com.zhiyou100.basicclass.day13.tryAndCatchDemo;

/**
 * @packageName: javase_26
 * @className: MyException
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/10 5:46 下午
 */
public class MyException extends Throwable {
    // 1. 继承throwable方法
    public MyException(String message) {
        // 2. 提供有参数的构造方法
        super(message);
        // 调用父类有参数的构造方法来指定原因
    }
}
