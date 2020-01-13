package com.zhiyou100.day05;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;

/**
 * @author yanglei
 */
public class TextArray {
    public static void main(String[] args) {

        int[] arr= new int[10];

        for (int i = 0; i <arr.length; i++) {
            double rand = Math.random()*10;
            arr[i]=(int)rand;

        }

        System.out.println(Arrays.toString(arr));
        //[I@38af3868

        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "]=" + arr[i] + " ");
        }

        System.out.println();

        for (int value :
                arr) {
            System.out.print(value+"\t");
        }

        System.out.println();

        System.out.println(Arrays.toString(arr));

        byte[] byteArray=new byte[10];
        int[] intArray=new  int[10];
        short[] shortArray=new short[10];
        long[] longArray=new long[10];
        float[] floatsArray=new float[10];
        double[] doublesArray=new double[10];
        boolean[] booleanArray=new boolean[10];
        char[] charArray=new char[10];





        System.out.println("byte: "+Arrays.toString(byteArray));
        System.out.println("int: "+Arrays.toString(intArray));
        System.out.println("short: "+Arrays.toString(shortArray));
        System.out.println("long: "+Arrays.toString(longArray));
        System.out.println("float: "+Arrays.toString(floatsArray));
        System.out.println("double: "+Arrays.toString(doublesArray));
        System.out.println("boolean: "+Arrays.toString(booleanArray));
        System.out.println("char: "+Arrays.toString(charArray));

        int[] textArray=new int[]{1,2,3};
        //定义一个数组名textArray并指向一个装11个int元素的数组对象
        textArray=new int[]{3,4,5};
        //让数组名textArray指向一个新的数组对象
        int[] textArray01;
        textArray01=textArray;
        System.out.println(Arrays.toString(textArray01));
        //out 3.4.5

    }
}
