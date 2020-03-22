package com.zhiyou100.basicclass.day23.bufferedemohomework;

import java.io.*;
import java.rmi.server.ExportException;

/**
 * @packageName: javase_26
 * @className: BufferedHomeWorkDemo3
 * @Description: TODO 写一个拆分方法 把原文本文件按照字母、数字、其他字符的类型拆分为三个文件，存入目的文件夹
 * @author: YangLei
 * @date: 2020/3/22 11:17 下午
 */
public class BufferedHomeWorkDemo3 {
    public static void main(String[] args)  {
        File file = new File("/Users/yanglei/javaText1/b.txt");
        File file1 = new File("/Users/yanglei/javaText3");
        splitMethod(file,file1);
    }

    private static void splitMethod(File old, File now) {
        /**
         * 思路：
         *  1、判断file是不是文件并且存在，如不是，直接结束函数
         *  2、判断file1是否存在,不存在，则创建
         *  3、判断创建后的file1是不是目录，如不是目录，跳出
         *  4、file1 是目录，继续操作，创建三个子文件，写入
         */
        if (!old.exists() || !old.isFile()){
            // 若，file不存在或者不是个文件，跳出
            System.out.println(old.getAbsolutePath()+"不存在或者不是个文件");
            return;
        }
        if (!now.exists()){
            // 判断file1是否存在，如不存在则创建
            if (!now.mkdirs()){
                System.out.println(now.getAbsolutePath()+"创建失败");
            }
        }
        if (now.getName().contains(".")){
            // 如果包含"." 说明是文件，跳出
            System.out.println(now.getAbsolutePath()+"是文件");
            return;
        }
        // 一下就是安全情况
        File file = new File(now, "number.txt");
        File letter = new File(now, "letter.txt");
        File file1 = new File(now, "other.txt");
        try {
            // 创建流
            BufferedReader bufferedReader = new BufferedReader(new FileReader(old));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(letter));
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file1));

            while (true){
                String line=bufferedReader.readLine();
                // 一次读一行
                if (line==null){
                    // 读到末尾，跳出
                    break;
                }
                for (char c :
                        line.toCharArray()) {
                    if (Character.isDigit(c)){
                        // 如果是数字
                        bufferedWriter.write(c);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }else if (Character.isLetter(c)){
                        // 如果是字母
                        bufferedWriter1.write(c);
                        bufferedWriter1.newLine();
                        bufferedWriter1.flush();
                    }else {
                        // 其他情况
                        bufferedWriter2.write(c);
                        bufferedWriter2.newLine();
                        bufferedWriter2.flush();
                    }
                }
            }
            // 关闭流
            bufferedReader.close();
            bufferedWriter.close();
            bufferedWriter1.close();
            bufferedWriter2.close();

        }catch (IOException e){
            System.out.println("我在这里");
            System.out.println("创建失败");
        }

    }

}
