package com.zhiyou100.basicclass.day18.maplearn;

import com.zhiyou100.basicclass.day15.collectionDemo.CollectionDemo01;
import com.zhiyou100.basicclass.day17.HashDemo1;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @packageName: javase_26
 * @className: MapLearnDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/16 10:54 上午
 */
public class MapLearnDemo1 {
    public static void main(String[] args) {
        // hashMap 无参数的静态方法1
        HashMap<Integer, String> map = new HashMap<>();
        // 键是学号，值是学生名字
// V put(K key, V value) 将指定的值与此映射中的指定键关联（可选操作）。返回此map中原来此key对应的值，如果不包含此key，返回null
// void putAll(Map<? extends K,? extends V> m) 从指定映射中将所有映射关系复制到此映射中（可选操作）。
        System.out.println(map.put(101, "韩梅梅"));
        // null
        System.out.println(map.put(102, "韩梅子"));
        // null
        System.out.println(map.put(101, "韩放"));
        // 韩梅梅

//  int	size() 返回此映射中的键-值映射关系数。
        System.out.println(map.size());
        // 2
//  V	remove(Object key) 根据键删除映射，返回对应的值
        System.out.println(map.remove(103));
        // null
        System.out.println(map.remove(101));
        // 韩放
//  boolean	isEmpty() 如果此映射未包含键-值映射关系，则返回 true。
//  void	clear() 从此映射中移除所有映射关系（可选操作）。

// boolean	containsKey(Object key) 如果此映射包含指定键的映射关系，则返回 true。
// boolean	containsValue(Object value) 如果此映射将一个或多个键映射到指定值，则返回 true。
        for (int i = 103; i < 110; i++) {
            System.out.println(map.put(i, "韩" + i));
        }
        HashDemo1.printCutOffRule();
        // 分隔符
        System.out.println(map.containsKey(109));
        // turn
        System.out.println(map.containsValue("韩5"));
        // false
        HashDemo1.printCutOffRule();
        // 分隔符
        //  Set<K>	keySet() 返回此映射中包含的键的 Set 视图。
        Set<Integer> keys = map.keySet();
        System.out.println("keySet方法：");
        CollectionDemo01.printCollection1(keys);
        HashDemo1.printCutOffRule();
        //  V get(Object key) 返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
        System.out.println(map.get(101));
        // null
        System.out.println(map.get(102));
        // 韩梅子
        HashDemo1.printCutOffRule();
        /*
         * 遍历方法
         *   1. 先提供KeySet方法获取所有的键，再通过get方法由键获取值
         */
        Set<Integer> integers = map.keySet();
        for (Integer in :
                integers) {
            String value = map.get(in);
            System.out.println("key:" + in + " value:" + value);
        }
        HashDemo1.printCutOffRule();
//  Set<Map.Entry<K,V>>	entrySet() 返回此映射中包含的映射关系的 Set 视图。
//  Entry 类是对一个映射的📦----> 键值对对象
// 方法： K getKay()          V getValue()
        /**
         * 遍历方法
         *  2. 先获取entrySet方法获取所有键值对对象对应的set，再通过entry的getKey和getValue方法获取键和值
         */
        Set<Entry<Integer, String>> entries = map.entrySet();
        for (Entry<Integer, String> entry :entries) {
            System.out.println("key:"+entry.getKey()+" Value:"+entry.getValue());
        }
        HashDemo1.printCutOffRule();

    }
}
