package com.zhiyou100.basicclass.day19;

import com.zhiyou100.basicclass.day15.collectionDemo.CollectionDemo01;
import com.zhiyou100.basicclass.day17.HashDemo1;
import com.zhiyou100.basicclass.day17.homework.HomeWorkForHashSet1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @packageName: javase_26
 * @className: CollectionsDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/17 4:37 下午
 */
public class CollectionsDemo1 {
    public static void main(String[] args) {
        /**
         * 集合工具类的Collections方法：
         * public static <T> void copy(List<? super T> dest,List<? extends T> src) 把src中的元素拷贝到dest中，⚠️：dest集合中必须有元素
         *
         * static <T> List<T> emptyList() 清空列表
         * static <K,V> Map<K,V> emptyMap() 清空Map
         * static <T> Set<T> emptySet() 清空set
         *
         * static <T> void fill(List<? super T> list, T obj) 使用Obj填充list
         *
         * static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll) 根据元素的自然顺序，返回给定 collection 的最大元素。
         * static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) 根据指定比较器产生的顺序，返回给定 collection 的最大元素。
         * static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll) 根据元素的自然顺序 返回给定 collection 的最小元素。
         * static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp) 根据指定比较器产生的顺序，返回给定 collection 的最小元素。
         *
         *
         * static <T> boolean replaceAll(List<T> list, T oldVal, T newVal) 使用newValue替换List中所有的OldVal
         *
         * static void	reverse(List<?> list) 反转指定列表中元素的顺序。
         *
         * static void	shuffle(List<?> list) 使用默认随机源对指定列表打乱顺序
         *
         * static <T extends Comparable<? super T>> void sort(List<T> list) 根据元素的自然顺序 对指定列表按升序进行排序。
         * static <T> void sort(List<T> list, Comparator<? super T> c) 根据指定比较器产生的顺序对指定列表进行排序。
         */
        ArrayList objects = new ArrayList<>();
        objects.add("111a");
        objects.add("111b");
        objects.add("111c");
        objects.add("111d");
        objects.add("111e");
        System.out.println("objects:");
        CollectionDemo01.printCollection1(objects);
        HashDemo1.printCutOffRule();
        ArrayList objects1 = new ArrayList<>();
        objects1.add("111a0");
        objects1.add("111b0");
        objects1.add("111c0");
        objects1.add("111d0");
        objects1.add("111e0");
        System.out.println("objects1:");
        CollectionDemo01.printCollection1(objects1);
        HashDemo1.printCutOffRule();
        Collections.copy(objects1,objects);
        // 把objects复制到Object1，覆盖原有的Object1
        System.out.println("copy 后的objects");
        CollectionDemo01.printCollection1(objects);
        HashDemo1.printCutOffRule();
        System.out.println("copy 后的objects1");

        CollectionDemo01.printCollection1(objects1);
        HashDemo1.printCutOffRule();

        Collections.fill(objects,"100");
        System.out.println("替换后：");
        CollectionDemo01.printCollection1(objects);
        HashDemo1.printCutOffRule();
        System.out.println(Collections.max(objects1));
        HashDemo1.printCutOffRule();
        System.out.println("打乱后：");
        Collections.shuffle(objects1);
        System.out.println(Collections.max(objects1));
        HashDemo1.printCutOffRule();

        Collections.replaceAll(objects,"100","1");
        CollectionDemo01.printCollection1(objects);
        HashDemo1.printCutOffRule();
        System.out.println("翻转前：");
        CollectionDemo01.printCollection1(objects1);
        HashDemo1.printCutOffRule();
        System.out.println("打乱后：");
        Collections.reverse(objects1);
        CollectionDemo01.printCollection1(objects1);
        HashDemo1.printCutOffRule();
        System.out.println("排序后：");
        Collections.sort(objects1);
        CollectionDemo01.printCollection1(objects1);






    }
}
