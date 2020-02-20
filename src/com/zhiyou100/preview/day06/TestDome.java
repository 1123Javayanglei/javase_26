package com.zhiyou100.preview.day06;

/**
 * @author yanglei
 */
public class TestDome {
    public static void main(String[] args) {
        int[] arrOne={1,3,4,6,2};
        int max=arrOne[0];
        for (int i = 0; i < arrOne.length; i++) {
            if (arrOne[i]>max){
                max=arrOne[i];
            }
        }
        System.out.println(max);
        for (int i = 0; i <arrOne.length; i++) {
            System.out.print(arrOne[i]+"\t");
        }
        System.out.println();
        for (int i = 0; i <arrOne.length ; i++) {
            for (int j = 0; j <arrOne.length; j++) {

                System.out.print("*"+"\t");
            }
            System.out.println();
        }
    }
}
