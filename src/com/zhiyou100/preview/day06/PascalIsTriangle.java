package com.zhiyou100.preview.day06;

/**
 * @author yanglei
 * 特点
 * 1.第几行=1,11,121,1331..   pow(11,n-1)
 * 2.第几行的和=1,2,4,8       pow(2,n-1)
 * 3.列和=拐角处数字
 * 4.每个数是它左上角和右上方数字的和
 */
public class PascalIsTriangle {
    public static void main(String[] args) {
        int i=30;
        int [][] row= new int[i][i];
        for (int j = 0; j <row.length ; j++) {
            for (int k =j;k>=0 ; k--) {
                if (j==k||k==0){
                    row[j][k]=1;
                }else {
                    row[j][k] = (row[j - 1][k - 1] + row[j - 1][k]);
                }
            }
        }
        for (int j = 0; j < row.length; j++) {
            for (int k = 0; k < row[j].length; k++) {
                if (row[j][k]!=0) {
                    System.out.print(row[j][k] + "\t");
                }
            }
            System.out.println();
        }
    }
}
