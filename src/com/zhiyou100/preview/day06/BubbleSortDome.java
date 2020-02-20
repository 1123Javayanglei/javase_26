package com.zhiyou100.preview.day06;

import java.util.Arrays;

/**
 * @author yanglei
 */
public class BubbleSortDome {
    public static void main(String[] args) {
        int[] array={5,8,6,3,9,2,1,7};
        sequentialOrder(array);

//        bubbleSort(array);




    }

    public static void bubbleSort(int[] array){

        System.out.println("冒泡排序：");
        System.out.println("原数组"+ Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
        System.out.println("排序后原数组"+Arrays.toString(array));
    }

    public static void sequentialOrder(int[] array){

        System.out.println("顺序排序：");
        System.out.println("原数组"+ Arrays.toString(array));

        for (int j = 0; j <array.length-1 ; j++) {
            for (int k = j+1; k <array.length ; k++) {
                if (array[j]<array[k]){
                    int temp;
                    temp=array[k];
                    array[k]=array[j];
                    array[j]=temp;
                    System.out.println(Arrays.toString(array));
                }
            }
        }
        System.out.println("排序后原数组"+Arrays.toString(array));
    }
}
