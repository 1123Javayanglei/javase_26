package com.zhiyou100.day02;

/**
 * @author yanglei
 */
public class Grammar02 {
    public static void main(String[] args) {

        long l1=11;

        /*
         *在内存中开辟了一块区域，区域类型是long 大小是8个字节 空间名l1
         * 把int类型的4个字节的11 自动转化为long类型的8个字节的11
         * 把long类型的11赋值给long类型的变量l1
         */

        float f1=11;
        /*
         *在内存中开辟了一块区域，区域类型是float 大小是4个字节 空间名f1
         * 把int类型的4个字节的11 自动转化为float类型的4个字节的11.0f
         * 把float类型的11.0f赋值给float类型的变量l1
         */
        f1=(int)11.3;
        /*
         * 把占8给字节的double类型的11.3 强制转化为占4个字节的int类型的11
         * 把int类型的4个字节的11 自动转化为float类型的4个字节的11.0f
         * 把float类型的11.0f赋值给float类型的变量f1
         */
        f1=11.1f;
        /*
         *  把float类型的11.0f赋值给float类型的变量f1
         */

        char c1=12345;
        System.out.println(c1);
        /*
         *在内存中开辟了一块区域，区域类型是char 大小是2个字节 空间名c1
         * 把int类型的4个字节的12345 自动转化为char类型的2个字节的12345
         * 把l=char型的12345赋值给char类型的变量c1
         */
        c1='a'+19999;
        /*
         *把char类型的2个字节的'a'转化为为int类型的97
         * 97+19999=20,096
         * 把int类型的4个字节的20,096 自动转化为char类型的2个字节的20,096
         * 把char类型的20,096赋值给char类型的变量c1
         */
        System.out.println((int)('a'));
        byte b1=122;
        /*
         *在内存中开辟了一块区域，区域类型是byte 大小是1个字节 空间名b1
         * 把int类型的4个字节的122 自动转化为byte类型的1个字节的122
         * 把byte类型的122赋值给byte类型的变量b1
         */
        b1=(byte)188;
        /*
         *把int类型的4个字节的188强制转换为byte类型的1个字节的188
         * 把byte类型的188赋值给byte类型的变量b1
         */

        int i1=b1;
        /*
         *在内存中开辟了一块区域，区域类型是int 大小是4个字节 空间名i1
         * 把byte类型的1个字节的188 自动转化为int类型的4个字节的188
         * 把int类型的188赋值给int类型的变量i1
         */
        i1=(byte)134.5;
        System.out.println("i1= "+i1);
        /*
         *把double类型的8个字节的134.5强制转换为byte类型的1个字节的-122
         * 赋值
         */

        short s1=12+199;
        /*
         *12+199=211
         *在内存中开辟了一块区域，区域类型是short 大小是2个字节 空间名s1
         * 把int类型的4个字节的211 自动转化为short类型的2个字节的211
         * 把short类型的211赋值给short类型的变量s1
         */
        s1=(short)(i1+199);
        /*
        *  运算 il+199得到一个int类型的变量值77
        *  int 77 to short 77
        * 赋值
        *
        */

        float f2=144L+19;
        System.out.println((float)(144L+19));
        /*
         *开辟空间 类型float ， 名字 f2
         * 144L+19得到8个字节long类型的163L
         * long 163L to float 163.0F
         * 赋值
         */
    }
}
