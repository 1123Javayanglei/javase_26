package com.zhiyou100.basicclass.day13;

/**
 * @packageName: javase_26
 * @className: ThrowableMethod
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/9 5:24 下午
 */
public class ThrowableMethod {
    public static void main(String[] args) {
        /**
         * Throwable 方法
         *  构造方法
         *    Throwable() 异常原因是null
         *    Throwable(String message) 参数是异常原因
         *
         *  普通方法：
         *      String getMessage() 获取异常原因
         *      void printStackTrace() 通过错误输出流打印异常消息
         *      String toString() 字符串形式
         */
        Throwable throwable = new Throwable("我错了");
        System.out.println(throwable.getMessage());
        // 我错了
        throwable.printStackTrace();
        // java.lang.Throwable: 我错了
        //	at com.zhiyou100.basicclass.day13.ThrowableMethod.main(ThrowableMethod.java:23)
        System.out.println(throwable.toString());
        // java.lang.Throwable: 我错了

    }
}
