package com.zhiyou100.basicclass.day19;

import com.zhiyou100.basicclass.day15.collectionDemo.CollectionDemo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @packageName: javase_26
 * @className: ArraysDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/17 5:17 下午
 */
public class ArraysDemo1 {
    public static void main(String[] args) {
        /**
         * Arrays 数组工具类
         * static <T> List<T> asList(T... a) 把数组转换为一个List
         *
         *  static void	fill(Object a[] a, Object val) 使用val填充数组a中所有的值
         *
         *  static void	sort(Object[] a) 对数组a升序排序
         *  static <T> void sort(T[] a, Comparator<? super T> c) 根据指定比较器产生的顺序对指定对象数组进行排序。
         *
         *  static String	toString(Object[] a) 返回指定数组内容的字符串表示形式。
         */
        String[] arr={"123","345","343","frwe","fdsafas",};
        List arrayList=  Arrays.asList(arr);
        CollectionDemo01.printCollection1(arrayList);
        System.out.println(Arrays.toString(arr));


    }
}
