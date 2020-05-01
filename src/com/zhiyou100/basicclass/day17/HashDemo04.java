package com.zhiyou100.basicclass.day17;

import java.util.HashSet;

/**
 * @packageName: javase_26
 * @className: HashDemo04
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/14 11:12 上午
 */
public class HashDemo04 {
    public static void main(String[] args) {
        HashSet<HashDemo3Student> hashDemo3Students = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            HashDemo3Student hashDemo3Student = new HashDemo3Student("韩"+i%5+"梅",((int)(Math.random()*50+50)));
            System.out.println(hashDemo3Student);
            System.out.println(hashDemo3Students.add(hashDemo3Student));
        }

    }

}
