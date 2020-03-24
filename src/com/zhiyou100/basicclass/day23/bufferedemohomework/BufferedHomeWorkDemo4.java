package com.zhiyou100.basicclass.day23.bufferedemohomework;

import java.io.*;

/**
 * @packageName: javase_26
 * @className: BufferedHomeWorkDemo4
 * @Description: TODO 把参数源文件中的字符进行转换，大写转小写，小写转大写，删除汉字
 * @author: YangLei
 * @date: 2020/3/23 1:54 上午
 */
public class BufferedHomeWorkDemo4 {
    public static void main(String[] args) {
        File file = new File("/Users/yanglei/javatext/a.txt");
        change(file);
    }

    public static void change(File original) {
        if (!original.exists() || original.isDirectory()) {
            // 若原始文件不存在，或是一个目录跳出
            System.out.println(original.getAbsolutePath() + " 文件存在或者是一个目录");
            return;
        }
        File file = new File("temp.txt");
        // 创建中间变量接收
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(original));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                for (char c :
                        line.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        // 如果是大写
                        bufferedWriter.write(Character.toLowerCase(c));
                        bufferedWriter.flush();
                    } else if (Character.isLowerCase(c)) {
                        // 如果是小写
                        bufferedWriter.write(Character.toUpperCase(c));
                        bufferedWriter.flush();

                    } else if (isChinese(c)) {
                        // 如果是汉字

                    } else {
                        // 其他情况
                        bufferedWriter.write(c);
                        bufferedWriter.flush();
                    }
                }
            }
            // 关闭流
            bufferedReader.close();
            bufferedWriter.close();


            if (!file.renameTo(original)) {
                System.out.println("重命名失败");
            } else {
                System.out.println("重命名成功");
            }

        } catch (IOException e) {
            System.out.println("高效流创建失败");
        }


    }

    public static boolean isChinese(char c) {
        // 判断是不是汉字
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }
}
