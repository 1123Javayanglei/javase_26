package com.zhiyou100.day07;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author yanglei
 */
public class MethodOf3Test {

    public static void main(String[] args) {
        StdOut.println();

    }

    public static void collatzConjectureHello(int number){
        /*
         * 角谷猜想
         *  number
         *  偶数 number / 2
         *  奇数 number *3+1
         *
         *  最后number等于1
         */
            int tmp = number;
            int flag = 0;
            while (number != 1) {
                if (number % 2 == 0) {
                    System.out.print("第"+(flag+1)+"次 "+number+"%2=");
                    number /= 2;
                    System.out.print(number+"\n");
                    flag++;
                } else {
                    System.out.print("第"+(flag+1)+"次 "+number+"*3+1=");
                    number = number * 3 + 1;
                    System.out.print(number+"\n");
                    flag++;
                }
            }
            System.out.println(tmp + "需要" + flag + "次");
    }
    public static void getNumberOfDaffodils(){
        /*
         * 水仙花数
         */
        for (int i = 100; i <=999 ; i++) {
            if (Math.pow(i%10,3)+Math.pow(i/10%10,3)+Math.pow(i/100,3)==i){
                System.out.println(i);
            }
        }
    }
    public static void getTheSqrt(int a,int b,int c){
        /*
         * a*pow(x,2)+b*x+c=0
         * pow(b,2)-4*a*c > 0 有两个不相等的实数根
         * pow(b,2)-4*a*c = 0 有一个的实数根
         * pow(b,2)-4*a*c < 0 没有实数根，无解
         */
        int flag= (int) (Math.pow(b,2)-(4*a*c));
        int one=0;
        int two=0;
        if (flag>0){
            one= (int) ((-b+Math.sqrt(Math.pow(b,2)-4*a*c))/2*a);
            two= (int) ((-b-Math.sqrt(Math.pow(b,2)-4*a*c))/2*a);
            System.out.println("第一个根是："+one+"第二个根是："+two);
        }else if (flag==0){
            one= (int) ((-b+Math.sqrt(Math.pow(b,2)-4*a*c))/2*a);
            two= (int) ((-b-Math.sqrt(Math.pow(b,2)-4*a*c))/2*a);
            System.out.println("有两个相等的实数根 "+one);
        }else {
            System.out.println("此方程式无实数根，无解");
        }
    }
    public static int determineTheDistanceBetweenTheTwoCoordinates(int x1,int y1,int x2,int y2){
        /*
         *计算两点之间的距离
         * 如 x1,y1 x2,y2
         * (x1-x2)可能是负数，所以abs(x1-x2)求绝对值
         * 距离就是算三角形的斜边
         * a^2+b^2=c^2
         * c=sqrt(a^2+b^2)
         *
         */
        return (int) Math.sqrt(Math.pow(Math.abs(x1-x2),2)+Math.pow(Math.abs(y1-y2),2));
    }
    public static boolean judgeTheNumberIsPrime(int number){
        /*
         * 判断一个数是否是质数，是返回true ，不是返回 false
         */
        boolean flag=false;
        for (int i = 2; i <=(int)(Math.sqrt(number)); i++) {
            if (number%i==0){
                flag=true;
                break;
            }
        }
        if (flag||number==1){
            return false;
        }else {
            return true;
        }

    }
    public  static int getCntSumOfOneToTheNumber(int number){
        //输入n 获取1到n的和
        int cnt=0;
        for (int i = 1; i <=number ; i++) {
            cnt+=number;
        }
        return cnt;
    }
    public static int getTheNumberDigit(int number){
        //获取一个大于0的整数的位数
        int flag=0;
        while (number!=0){
            number/=10;
            flag++;
        }
        return flag;
    }
    public static int sumOfTwoInt(int a,int b){
        //返回a+b的和
        return a+b;
    }
    public static void printTheNumberAllDivisor(int number){
        //输出这个数的所有因子
        System.out.println(number+"的所有因子是：");
        for (int i = 1; i <=number ; i++) {
            if (number%i==0){
                System.out.print(i+" ");
            }
        }
    }
    private static void printInputIsHelloWorld(int n){
        //输入一个数，输出n遍hello world
        for (int i = 0; i <= n; i++) {
            System.out.println("HelloWorld");
        }
    }
}
