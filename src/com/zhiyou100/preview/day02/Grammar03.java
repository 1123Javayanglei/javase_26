package com.zhiyou100.preview.day02;

/**
 * @author yanglei
 */
public class Grammar03 {
    public static void main(String[] args) {
        byte b1=11;
        byte b2= (byte) (b1+1);
        //byte 不能直接进行运算，需要转化为int才能进行运算
        System.out.println(b2);

        short s1=1;
        int i1=1;
        long l1=1;
        float f1=1;
        double d1=1;

        s1= (short) (i1+s1);
        //i1+s1 = int

        s1= (short) (i1+s1+l1);
        //i1+s1+l1=long

        s1= (short) (i1+s1+l1+f1);
        //i1+s1+l1+f1 = float
        /*
        运算后结果的数据取决于精度最高的数据
         */

        /*
         *字符串：打印输出语句中带双引号的就是字符串
         * 任何数据和字符串连接都会形成一个新的字符串
         */

        System.out.println(1+2+3+"abc"+1+2);
        //out 6+"abc12"

        System.out.println(2.0-1.1);
        //out 0.8999999999999999

        System.out.println("s1="+s1);
        //out "s1=7"

        //取模
        System.out.println(10%3.0);
        //out 1


        //++ 自增 --自减


        int a=4;
        a+=3;
        //a=(a的类型)a+3;


    }
}
