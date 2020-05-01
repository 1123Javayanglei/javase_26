package com.zhiyou100.basicclass.day16;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Date;

/**
 * @packageName: javase_26
 * @className: GenericsDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/13 4:07 下午
 */
public class GenericsDemo1 {
    public static void main(String[] args) {
        print1();
    }

    public static ArrayList<String> getList() {
        // =注意：以后的集合 必须都使用泛型，没有泛型的集合不能使用
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("1123");
        strings.add("3434");
        return strings;
    }

    public static void print1() {
        for (String s :
                getList()) {
            System.out.println(s);
        }
    }

    public static void printGenerics() {
        // 向下转型
        ArrayList arrayList = getList();
        for (Object obj :
                arrayList) {
            if (obj instanceof String) {
                String string = (String) obj;
                System.out.println("这是一个字符串 " + string);
            } else if (obj instanceof Date) {
                Date date = (Date) obj;
                System.out.println("这是一个日期类" + date);
            } else if (obj instanceof Boolean) {
                boolean flag = (boolean) obj;
                System.out.println("这是一个boolean类 " + flag);
            } else if (obj instanceof Integer) {
                Integer integer = (Integer) obj;
                System.out.println("int类型 " + obj);
            } else {
                System.out.println("这是一个Object类 " + obj);
            }
        }
    }
}
