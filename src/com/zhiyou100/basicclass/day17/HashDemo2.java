package com.zhiyou100.basicclass.day17;

import java.util.HashSet;
import java.util.Objects;

/**
 * @packageName: javase_26
 * @className: HashDemo2
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/14 10:40 上午
 */
public class HashDemo2 {
    private final int num;
    private static int n;

    public HashDemo2() {
        n++;
        num = n;
        System.out.println("第 " + num + "个对象创建了");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HashDemo2)) {
            return false;
        }
        HashDemo2 hashDemo2 = (HashDemo2) o;
        System.out.println(this.num + "的equals的方法别调用了 与" + hashDemo2.num + "做比较");
        return hashDemo2.num%2==this.num%2;
    }

    @Override
    public int hashCode() {
        return num%3;
    }

    public static void main(String[] args) {
        HashSet<HashDemo2> hashDemo2s = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            HashDemo2 demo2 = new HashDemo2();
            hashDemo2s.add(demo2);
            System.out.println("-----添加-------"+hashDemo2s.add(demo2));
//            if (i % 2 == 0) {
//                hashDemo2s.add(demo2);
//            }
        }
    }

}
