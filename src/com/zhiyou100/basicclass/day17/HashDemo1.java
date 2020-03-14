package com.zhiyou100.basicclass.day17;

import com.zhiyou100.basicclass.day15.collectionDemo.CollectionDemo01;
import com.zhiyou100.basicclass.day16.ArrayListDemo1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @packageName: javase_26
 * @className: HashDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/14 10:23 上午
 */
public class HashDemo1 {
    public static void main(String[] args) {
        /**
         * HashSet : 不重复的特点
         *
         */
        HashSet<String> strings = new HashSet<>();
        // 创建对象中的泛型类型省略，编译器会根据引用自动补上
        System.out.println(strings.add("3434"));
        // true
        System.out.println(strings.add("3434"));
        // false
        // add public boolean add(E e) (e==null ? e2==null : e.equals(e2)) 调用e的equals方法比较所有的元素
        System.out.println(strings.add(new String("3434")));
        // false
        System.out.println(strings.add("123"));
        System.out.println(strings.add("a123"));
        System.out.println(strings.add("a1234"));
        System.out.println(strings.add("a1234"));
        // true
        printCutOffRule();
        CollectionDemo01.printCollection1(strings);
        printCutOffRule();
        CollectionDemo01.printCollection2(strings);
        printCutOffRule();
        CollectionDemo01.printCollection3(strings);
        printCutOffRule();
        printStringHash(strings);
        printCutOffRule();
    }

    public static void printStringHash(HashSet<String> strings) {
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    public static void printCutOffRule(){
        System.out.println("===============");
    }
}
