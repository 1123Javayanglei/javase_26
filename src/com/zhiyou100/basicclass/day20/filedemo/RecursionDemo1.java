package com.zhiyou100.basicclass.day20.filedemo;

/**
 * @packageName: javase_26
 * @className: RecursionDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/18 11:23 上午
 *
 * 方法递归：方法自己调用自己：：必须有一个出口，否则栈会溢出
 */
public class RecursionDemo1 {
    public static void main(String[] args) {
        System.out.println(cnt(10));
        System.out.println(cntSum(5));
    }
    static int cnt(int n){
        // 1到n的和
        if (n==1){
            return 1;
        }else {
            return n+cnt(n-1);
        }
    }
    static int cntSum(int n){
        if (n==1){
            return 1;
        }else {
            return n*cntSum(n-1);
        }
    }
}
