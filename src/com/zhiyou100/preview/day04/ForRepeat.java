package com.zhiyou100.preview.day04;

/**
 * @author yanglei
 */
public class ForRepeat {
    public static void main(String[] args) {
        /*
         *一百文💰，要买100只🐔
         * 🐓：3文
         * 母鸡：2文
         * 🐤：1/3 文
         *
         * 🐓+母鸡+🐤==100 && 🐓*3+母鸡*2+小鸡*(1/3)==100
         *
         * 0~33
         * 0~50
         * 100-rooster-hen
         */
        int rooster;
        int hen;
        int chicken;
        for (rooster = 0; rooster <=33 ; rooster++) {
            for (hen = 0; hen <=50; hen++) {
                for (chicken = 0; chicken <=(100-rooster-hen); chicken++) {
                    boolean flag=(rooster+hen+chicken==100&&rooster*3+hen*2+chicken/3==100&&chicken%3==0);
                    if (flag){
                        System.out.println("现在"+rooster+"母鸡:"+hen+"小鸡:"+chicken);
                    }
                }
            }
        }

        System.out.println();

        for (int i = 1; i <10 ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(" "+i+"*"+j+"="+(i*j)+"\t");
                /*
                 * \t \n 都是制表符
                 */
            }
            System.out.println();
        }

        System.out.println();



        System.out.println();

        for (int i = 9;i>0;i--) {
            for (int j = i; j >0 ; j--) {
                System.out.print(" "+i+"*"+j+"="+(i*j)+"\t");
                /*
                 * \t \n 都是制表符
                 */
            }
            System.out.println();
        }

        System.out.println();


        for (int i = 1; i <10 ; i++) {
            for (int k = 1; k <(10-i) ; k++) {
                System.out.print("\t"+"\t");
            }
            for (int j = i; j >0 ; j--) {
                System.out.print("\t"+i+"*"+j+"="+(i*j));
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 1; i<10 ; i++) {

            for (int k = 1; k <i ; k++) {
                System.out.print("\t"+"\t");
            }

            for (int j = i; j <10 ; j++) {
                System.out.print("\t"+i+"*"+j+"="+(i*j));
            }
            System.out.println();
        }
        /*
         * 1.打印4个方向的九九乘法表
         * 2.什么是质数
         *  除了1和其本身，不能被其他数整除的数，叫质数
         *         6=1 6 2 3
         *         ⚠️：1不是质数
         *
         *   判断2~Number-1 是否有可以整除Number的数，若有，则Number不是质数
         *
         */
        for (int j=1;j<100;j++){

        int number=j;

        boolean flag=false;

        for (int i = 2; i <(number-1) ; i++) {
            if (number%i==0){
                flag=true;
            }
        }

        if (flag||number==1) {
            System.out.println(" "+number+"不是质数");

        }else {
            System.out.println(" "+number+"是质数");
        }

    }
    }
}
