package com.zhiyou100.basicclass.day16;

import com.zhiyou100.basicclass.day15.collectionDemo.CollectionDemo01;

import java.util.ArrayList;

/**
 * @packageName: javase_26
 * @className: ArrayListDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/13 3:11 下午
 *
 * ArrayList 特有的方法：都是于下标有关的方法
 *  添加
 *      void add(int index,E element) 将指定的元素插入此列表中的指定位置。
 *  获取
 *       E	get(int index) 返回此列表中指定位置上的元素。
 *       int	indexOf(Object o) 返回此列表中首次出现的指定元素的索引，或如果此列表不包含元素，则返回 -1。
 *       int	lastIndexOf(Object o) 返回此列表中最后一次出现的指定元素的索引，或如果此列表不包含索引，则返回 -1。
 *  删除
 *       E	remove(int index) 移除此列表中指定位置上的元素。
 *       E	set(int index, E element) 用指定的元素替代此列表中指定位置上的元素。
 */
public class ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("123434");
        arrayList.add(134);
        arrayList.add('a');
        arrayList.add(true);
        arrayList.add(false);
        System.out.println("=========");
        CollectionDemo01.printCollection1(arrayList);
        System.out.println("===========");
        arrayList.add(0,"我是第一个");
        CollectionDemo01.printCollection1(arrayList);
        System.out.println("==============");

        System.out.println("第一个元素是："+arrayList.get(0));
        System.out.println("'a'第一次出现的位置" +arrayList.indexOf('a'));
        System.out.println("true最后一次出现的位置" +arrayList.lastIndexOf(true));
        System.out.println("=============");

        System.out.println(arrayList.remove(4)+"删除后：");
        CollectionDemo01.printCollection1(arrayList);

        text1(0);
        // 自动装箱，int to Integer，Integer向上转型为Object
    }
    static void text1(Object object){
        // 自动装箱，int to Integer，Integer向上转型为Object
    }
}
