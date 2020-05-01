package com.zhiyou100.basicclass.day15.collectionDemo;

import java.util.*;

/**
 * @packageName: javase_26
 * @className: CollectionDemo01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/12 11:24 上午
 */
public class CollectionDemo01 {
    public static void main(String[] args) {
        /**
         * 注意   学习了Collection 等价学习了List和Set
         *       学习集合：集合特点+集合增删改查+遍历方式
         *       先不管 < > 泛型
         *       集合空框架的api中的E 认为是Object
         * 方法：
         *  查
         *      int size(); 获取元素个数
         *
         *  增
         *      boolean add(E e) 把参数对象e 添加到当前集合中，返回值表示是否添加成功
         *      boolean addAll(Collection c) 把当前参数集合中的所有集合添加到当前集合中
         *
         *  删：通过equals方法来比较
         *      void clear() 清空元素
         *      boolean remove(Object o) 从当前集合中删除参数元素
         *      boolean removeAll(Collection < > c) 从当前集合中的删除参数集合中的所有元素
         *
         *  判断
         *   boolean contains(Object o） 判断当前集合中是否包含参数对象
         *   boolean containAll(Collection c) 判断当前集合中是否包含参数集合c中的所有元素
         *   boolean isEmpty() 是否为空 size()==0
         *
         *  遍历方式: Collection 3种，Set3种，List4种，Map2种
         *   Collection 1：简洁for循环
         *
         */
        Collection arrayList1 = new ArrayList();
        Collection arrayList2 = new ArrayList();
        // 查
        System.out.println(arrayList1.size());
        // out 0
        System.out.println("=================");

        //增
        System.out.println(arrayList1.add(new Object()));
        System.out.println(arrayList1.add("1234432"));
        System.out.println(arrayList1.add(new Date()));
        System.out.println(arrayList1.size());
        // out 3
        System.out.println(arrayList2.size());
        // out 0
        System.out.println(arrayList2.addAll(arrayList1));
        System.out.println(arrayList2.size());
        // out 3
        System.out.println("=================");
        // 删
        System.out.println("删除arr2中的所有arr1的元素:");
        System.out.println(arrayList2.size());
        System.out.println(arrayList2.removeAll(arrayList1));
        System.out.println(arrayList2.size());
        System.out.println("=================");
        //查看
        // 1 foreach
        for (Object obj :
                arrayList1) {
            // 通过引用 obj循环接受集合c1中的元素
            System.out.println(obj);
            // 注意：foreach 同样适用于数组，但是不能获取下标
            // 必须使用Object来取出元素，因为add方式接受的就是 Object 对象
        }
        System.out.println("=================");
        // 2 转换成 Object数组，Object[] toArray()
        Object[] arr = arrayList1.toArray();
        for (Object ob :
                arr) {
            System.out.println(ob);
        }
        System.out.println("=================");
        // 3 获取集合的迭代器对象：Iterator
        Iterator iterator = arrayList1.iterator();
        // 获取迭代器对象
        while (iterator.hasNext()) {
            // 判断迭代器中还有没元素可以遍历，如果为true，继续遍历
            System.out.println(iterator.next());
            // next() 获取下一个元素，指针下移一位
        }
        System.out.println("=================");
//        System.out.println(decideIfItSAllNumbers("34343"));
    }

    /**
     * homeWork
     * 创建一个Collection 装10个字符串，
     * 判断两个字符的元素的个数
     * 删除纯数字字符的元素
     * 所有元素大小写转换
     */
    static String toggleCase(String string) {
        StringBuilder ultimately = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            // 操作
            char temp = string.charAt(i);
            // 把每一个字符提取出来
            if (Character.isLowerCase(temp)) {
                //判断是不是小写字母
                ultimately.append(Character.toUpperCase(temp));
                // 如果是小写字母，转为大写，放进ultimately中
            } else if (Character.isUpperCase(temp)) {
                // 如果是大写字母
                ultimately.append(Character.toLowerCase(temp));
                // 转换为小写，放进ultimately中
            } else {
                ultimately.append(temp);
                // 其他情况放进
            }
        }
        return String.valueOf(ultimately);
    }

    static boolean decideIfItSAllNumbers(String string) {
        /**
         * @name: decideIfItSAllNumbers
         * @param: String string
         * @date: 2020/3/12 5:37 下午
         * @return: boolean
         * @description: TODO 判断一个String是不是全部是数字，如果全部是数字，返回true，否则返回false
         */
        boolean isAllNumber = true;
        // 默认是false;
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                // 如果是有一个不是数字
                isAllNumber = false;
                break;
            }
        }
        return isAllNumber;
    }

    public static void printCollection1(Collection collection) {
        // 第一种foreach
        for (Object object :
                collection) {
            System.out.println(object);
        }

    }

    public static void printCollection2(Collection collection) {
        // 第二种 转换成 Object ，foreach
        Object[] array = collection.toArray();
        for (Object obj :
                array) {
            System.out.println(obj);
        }
    }

    public static void printCollection3(Collection collection) {
        // 迭代器打印
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
