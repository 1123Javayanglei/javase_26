package com.zhiyou100.basicclass.day20.filedemo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @packageName: javase_26
 * @className: FileDemo2
 * @Description: TODO 练习
 * @author: YangLei
 * @date: 2020/3/18 11:40 上午
 * <p>
 * 写一个
 */
public class FileDemo2 {
    public static void main(String[] args) {

    }

    public static void printStringPath(String string) {
        /*
         * @description: TODO 打印参数字符串，如果是文件，打印文件的绝对路径，如果是文件夹，打印其绝对路径，及其下的所有直接和间接子文件/文件夹的所有绝对路径,总结实现tree
         */
        // 提示 1封装 file 2 需要递归
        try {
            File file = new File(string);
            if (file.isDirectory()) {
                //如果是目录
                System.out.println(file.getAbsolutePath());
                // 打印
                File[] file1 = file.listFiles();
                // 把此目录下的所有文件提取
                String temp = Arrays.toString(file1);
                // 放此目录下的所有文件和目录
                String temp1 = temp.substring(1, temp.length() - 1) + ", ";
                // 去掉开头和结尾的' [ '
                String[] temp2 = temp1.split(", ");
                // temp2 是当前目录下的文件和目录
                for (String s1 :
                        temp2) {
                    // 递归遍历
                    printStringPath(s1);
                }
            } else if (file.isFile()) {
                // 如果是文件
                System.out.println(file.getAbsolutePath());
            } else {
                System.out.println("啥都是不是");
                System.exit(0);
                // 退出进程
            }
        } catch (Exception e) {
            System.out.println("不是目录或文件");
        }

    }

    public static boolean delString(String string) {
        /*
         * @description: TODO 删除参数字符串表示的文件夹/文件,总结实现 rm -rf
         */
        // 提示 需要递归
        try {
            File file = new File(string);
            if (file.isDirectory()) {
                // 如果目录，判断有没有子目录和子文件
                File[] file1 = file.listFiles();
                // 把此目录下的所有文件提取,判断file1的长度
                String stringNull = "[]";
                if (stringNull.equals(Arrays.toString(file1))) {
                    //如果为空说明没有子文件和子文件夹，删除
                    return file.delete();
                } else {
                    // 说明有子文件和子文件夹，递归删除
                    File[] file2 = new File[file1.length + 1];
                    // 创建一个新的长度+1的数组，用来放本身的目录
                    System.arraycopy(file1, 0, file2, 0, file1.length);
                    // 遍历赋值
                    file2[file2.length - 1] = file1[0].getParentFile();
                    // 把自身的目录，放入file2中
                    String temp = Arrays.toString(file2);
                    // 放此目录下的所有文件和目录
                    String temp1 = temp.substring(1, temp.length() - 1) + ", ";
                    // 去掉开头和结尾的' [ '
                    String[] temp2 = temp1.split(", ");
                    // 分割
                    for (String s :
                            temp2) {
                        // 递归删除
                        delString(s);
                    }
                    return true;
                }
            } else if (file.isFile()) {
                // 如果是文件删除
                return file.delete();
            } else {
                System.out.println("啥也不是");
                return false;
            }
        } catch (Exception e) {
            System.out.println("不是目录或文件");
            return false;
        }

    }
}