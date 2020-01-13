package com.zhiyou100.day04;

/**
 * @author yanglei
 * day04作业
 * 1 打印四个方向的乘法口诀
 * 2 判断一个数是不是质数
 * 3 使用for循环把 圆周率的题再写一遍
 * 4 使用for循环 获取所有的水仙花数
 * 5 留下你的宝贵意见
 *
 *
 * 扩展题1： 判断一个正整数是几位数
 * 扩展题2：打印输出1到100内所有质数
 * 扩展题3：求1到100内所有质数的平均值
 */
public class Day04HomeWork {
    public static void main(String[] args) {

        leftTopPrint();
        leftBottomPint();
        System.out.println();
        rightTopPrint();
        rightBottomPrint();

        judgingPrimeNumbers(4);


        piOfZuChongZhi();

        getAllWaterFlowerNumber();

        getPositiveIntegerTheDigit(123);

        getJudgingPrimeNumbersOf1And100();


    }
    public static void getJudgingPrimeNumbersOf1And100(){
        System.out.println("1到100的所有质数:");
        int numberSum=0;
        int numberCnt=0;
        for (int j = 1; j <100 ; j++) {
            boolean flag=false;
            for (int i =2; i <=(int)(Math.sqrt(j)) ; i++) {
                if (j % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag||j==1){

            }else {
                numberCnt++;
                numberSum+=j;
                System.out.print(j+" ");
            }
        }
        System.out.println();
        System.out.println("1到100的所有质数的平均数:"+((numberSum*1.0)/(numberCnt*1.0)));
    }

    public static void getPositiveIntegerTheDigit(int number){
        if (number>0) {
            int flag = 0;
            int sum = number;
            while (number != 0) {
                number /= 10;
                flag++;
            }
            System.out.println(" " + sum + "是" + flag + "位数");
        }else {
            System.out.println("请输入一个正整数（大于零的数)");
        }
    }
    public static void getAllWaterFlowerNumber(){
        System.out.println("水仙花数：");
        for (int i = 111; i <=999 ; i++) {
            int theUnit=i%10;
            int theDecade=i/10%10;
            int theHundreds=i/100;
            boolean flag=((int)(Math.pow(theUnit,3))+(int)(Math.pow(theDecade,3))+(int)(Math.pow(theHundreds,3))==i);
            if (flag){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    public static void piOfZuChongZhi(){
        /*
         * 特点：
         * 奇数次为正，偶数次为负
         * 分子固定为4
         * 分母，从1开始每次加2
         *
         * 结束条件：
         * PI<3.1415926 || PI>3.1415927
         *
         */

        int cnt;
        double pI=0;
        double piMin=3.1415926;
        double piMax=3.1415927;
        double sum=0;
        for (cnt=1;pI< piMin|| pI>piMax;cnt++) {
            if (cnt%2==0){
                sum=-4.0/(2*cnt-1);
            }else {
                sum=4.0/(2*cnt-1);
            }
            pI+=sum;
        }
        System.out.println("计算了:"+(cnt-1)+"次");

    }

    public static void judgingPrimeNumbers(int number){
        boolean flag=false;
        for (int i = 2; i <=(int)(Math.sqrt(number)) ; i++) {
            if (number % i == 0) {
                flag = true;
                break;
            }
        }
        if (flag||number==1){
            System.out.println(" "+number+"不是质数");
        }else {
            System.out.println(" "+number+"是质数");
        }
    }
    public static void rightTopPrint(){
        for (int i = 1; i <10 ; i++) {
            for (int j = 0; j <i ; j++) {
                System.out.print("\t"+"\t");
            }
            for (int j = i; j <10 ; j++) {
                System.out.print(" "+i+"*"+j+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }
    public static void leftBottomPint(){
        for (int i = 1; i <10 ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(" "+i+"*"+j+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }
    public  static void leftTopPrint(){
        for (int i = 1; i <10 ; i++) {
            for (int j = i; j <10 ; j++) {
                System.out.print(" "+i+"*"+j+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }
    public static void rightBottomPrint(){
        for (int i = 1; i <10 ; i++) {
            for (int j = 1; j <(10-i) ; j++) {
                System.out.print("\t"+"\t");
            }
            for (int j = i; j >0 ; j--) {
                System.out.print(" "+i+"*"+j+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }
}
