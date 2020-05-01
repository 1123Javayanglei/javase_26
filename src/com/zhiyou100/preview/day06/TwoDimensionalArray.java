package com.zhiyou100.preview.day06;

/**
 * @author yanglei
 */
public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] array=new int[3][4];
        System.out.println(array);
        //[[I@38af3868
        System.out.println(array.length);
        //3 二维数组中一维数组的个数
        System.out.println(array[0]);
        //[I@77459877
        System.out.println(array[1].length);
        //4 二维数组arr中下标为1中的一维数组对象的元素个数
        System.out.println(array[0][1]);
        //0 二维数组arr中下标为0的一维数组对象中下标为1的元素
        array[0][0]=11;
        array[1][0]=12;
        array[1][1]=13;

        array=new int[][]{{1,2,3,},{1,3,5,6,4,},{1,2},{3},};

        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length; j++) {
                System.out.print(" ["+i+"] ["+j+"] = "+array[i][j]);
            }
            System.out.println();
        }

        int max=array[0][0];
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length; j++) {
                if (array[i][j]>max){
                    max=array[i][j];
                }
            }

        }
        System.out.println(max);

    }
}
