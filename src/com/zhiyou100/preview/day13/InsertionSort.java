package com.zhiyou100.preview.day13;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;

import java.util.Arrays;

/**
 * @packageName: javase_26
 * @className: InsertionSort
 * @Description: TODO 插入排序
 * @author: YangLei
 * @date: 2020/4/10 9:27 下午
 * <p>
 * 前面的元素是有序的，拿当前元素和其前面的元素做比较
 */
public class InsertionSort {
    public static void main(String[] args) {
        int size=10;
        int[] ints = new int[size];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = HomeWorkOfMath.randomOfMinToMax(0, size);
        }

        System.out.println("排序前");
        System.out.println(Arrays.toString(ints));

        System.out.println();

        arrSort(ints);
        System.out.println("排序后");
        System.out.println(Arrays.toString(ints));





    }

    public static int[] arrSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 当前元素是arr[i]
            int temp = arr[i];
            // 用 temp 记录arr[i]的值
            int j;
            for (j = i - 1; j >= 0; j--) {
                // 拿temp倒着和前面的元素做比较
                if (arr[j] > temp) {
                    // 如果前面的元素 arr[j] > temp , arr[j]后移一位
                    arr[j + 1] = arr[j];
                } else {
                    // 当前元素比temp小，跳出
                    // 找到了当前元素temp的位置
                    break;
                }
            }
            arr[j+1]=temp;
            // 把temp放在j+1的位置处

        }
        return arr;
    }
}
