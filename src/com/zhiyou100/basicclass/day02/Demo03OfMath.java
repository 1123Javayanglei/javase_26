package com.zhiyou100.basicclass.day02;

/**
 * @packageName: javase_26
 * @className: Demo03OfMath
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/21 11:08 上午
 */
public class Demo03OfMath {
    public static void main(String[] args) {
        System.out.println(HomeWorkOfMath.addZero(1));
        /**
         * static double	E
         * double值比其他任何一个都更接近 e ，自然对数的基数。
         *
         * static double	PI
         * double值比任何其他的更接近 pi ，圆周长与其直径的比率。
         */
//        System.out.println(Math.E);
//        System.out.println(Math.PI);

        /**
         * 求绝对值
         * static double	abs(double a)
         * 返回值为 double绝对值。
         *
         * static float	abs(float a)
         * 返回 float值的绝对值。
         *
         * static int	abs(int a)
         * 返回值为 int绝对值。
         *
         * static long	abs(long a)
         * 返回值为 long绝对值。
         */

        /**
         * 平方根
         * static double	sqrt(double a)
         * 返回的正确舍入正平方根 double值。
         */

        /**
         * 立方根
         * static double	cbrt(double a)
         * 返回 double值的多维数据集根。
         */
//        System.out.println(Math.cbrt(27));
//        System.out.println(Math.pow(9,1.0/2.0));
        /**
         * 幂
         * static double	pow(double a, double b)
         * 将第一个参数的值返回到第二个参数的幂。
         */

        /**
         * 近似值
         * static double	ceil(double a)
         * 返回大于或等于参数的最小（最接近负无穷大） double值，等于一个数学整数。
         *
         * static double	floor(double a)
         * 返回小于或等于参数的最大（最接近正无穷大） double值，等于一个数学整数。
         *
         * static long	round(double a)
         * 返回参数中最接近的 long ，其中 long四舍五入为正无穷大。
         * static int	round(float a)
         * 返回参数中最接近的 int ，其中 int四舍五入为正无穷大。
         *
         * static double	rint(double a)
         * 返回与参数最接近值的 double值，并且等于数学整数。 //四舍六入，五取偶数
         */
        for (int i = 10; i <100 ; i++) {
            double n=i/10.0;
//            System.out.println(n+"::"+Math.floor(n));
            int flag=((int) (n*10))%10;
            if (flag==5) {
                System.out.println(n + "  " + Math.rint(n));
            }
        }

        /**
         * 伪随机
         * static double	random()
         * 返回值为 double值为正号，大于等于 0.0 ，小于 1.0 。
         *
         * 随机[a,b]的整数
         * int(Math.random() * 范围 + 起始值)
         *
         */
        for (int i = 0; i < 10; i++) {
//            System.out.println(i+" :: "+(int)((Math.random()*11+0)));
        }


    }
    public static int randomWeek(){
        return (int) (Math.random()*7+1);
    }
    public static double randomScore(){
        return ((int)(Math.random()*1000+0.0))/0.0;
    }
}

