package com.zhiyou100.basicclass.day13.tryAndCatchDemo;

/**
 * @packageName: javase_26
 * @className: CaptureDemo2
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/10 5:51 下午
 */
public class CaptureDemo2 {
    public static void main(String[] args) {
        test2(2);
    }

    public static void test2(int a) {
        if (a > 1) {
            // 3. 指定特定情况，来产生自定义异常
            try {
                throw new MyException("a>1错误");
                // 提供throw 异常对象; 来表示出现异常的情况
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
    }
}
