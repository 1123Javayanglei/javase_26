package com.zhiyou100.basicclass.day15.collectionDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static com.zhiyou100.basicclass.day15.collectionDemo.CollectionDemo01.*;

/**
 * @packageName: javase_26
 * @className: CollectionHomeWork
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/12 8:16 下午
 */
public class CollectionHomeWork {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        // 创建集合
        collection.add("12341234");
        collection.add("12341234");
        collection.add("23");
        collection.add("abcdefg");
        collection.add("HIJKLMN");
        collection.add("opqlmn");
        collection.add("aoe");
        collection.add("aeuio");
        collection.add("45723894");
        collection.add("abcEFG");
        // 添加元素
        System.out.println("操作前：");
        printCollection3(collection);
        System.out.println("=============");
        int numberFlag = 0;
        for (Object object :
                collection) {
            if (object instanceof String) {
                // 判断是不是Sting类型
                String s = (String) object;
                // 向下转型
                if (s.length() == 2) {
                    // 判断
                    numberFlag++;
                }
            }
        }
        System.out.println("元素个数是两个字符的个数是：" + numberFlag);

        Collection collection1 = new ArrayList();
        // 接收去掉数字后的元素
        Iterator iterator = collection.iterator();
        //创建迭代器对象
        while (iterator.hasNext()) {
            Object object = iterator.next();
            // 用Object接受
            if (object instanceof String) {
                // 判断能不能向下转型
                String s = (String) object;
                // 向下转型成Sting
                if (!decideIfItSAllNumbers(s)) {
                    // 判断是不是都是数字
                    collection1.add(object);
                    // 用collection1接收
                }

            }
        }
        System.out.println("===============");
        System.out.println("去掉都是数字的元素后：");
        printCollection3(collection1);

        Collection collection2 = new ArrayList();
        // 接收大小写转换后的元素
        Iterator iterator1 = collection1.iterator();
        // 用去掉重复数字的collection1创建迭代器对象
        while (iterator1.hasNext()) {
            Object object = iterator1.next();
            // 用object接收
            if (object instanceof String) {
                String s = (String) object;
                // 向下转型
                collection2.add(toggleCase(s));
            }
        }
        System.out.println("===========");
        System.out.println("大小写转换后：");
        printCollection3(collection2);
    }
}
