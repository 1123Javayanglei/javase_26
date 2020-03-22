package com.zhiyou100.basicclass.day23.bufferedemo;

import com.zhiyou100.basicclass.day17.HashDemo1;

import java.io.*;
import java.util.Arrays;

/**
 * @packageName: javase_26
 * @className: BufferedReaderDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/21 5:11 下午
 */
public class BufferedReaderDemo1 {
    public static void main(String[] args) throws IOException {
//        Demo01();
        Demo02();
    }

    private static void Demo02() throws IOException {
        // Mark
        File file = new File("/Users/yanglei/javaText1/a.txt");
        File file1 = new File("/Users/yanglei/javaText2", "complete.txt");

        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file1);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        StringBuilder one= new StringBuilder();
        while (true) {
            String line=bufferedReader.readLine();
            if (line==null){
                break;
            }
            one.append(line+"\n");
        }
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println(one);
        HashDemo1.printCutOffRule();
        String arr=String.valueOf(one);
        String[] array=arr.split("^\\d*$、");
        System.out.println(Arrays.toString(array));
    }

    private static void Demo01() throws IOException {
        File file = new File("/Users/yanglei/javaText1/a.txt");
        // 创建字符输入流与文件关联
        File file1 = new File("/Users/yanglei/javaText2", file.getName());
        // 创建字符输出流与文件关联
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file1);

        // 创建高效流与字节流关联
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // 选择读写方式：为逐行读取
        while (true) {
            // 遍历
            String line = bufferedReader.readLine();
            // 用line记录
            if (line == null) {
                // 如果等于null 说明到达文件结尾，跳出
                break;
            }
            bufferedWriter.write(line);
            // 写入
            bufferedWriter.newLine();
            // 写入换行符
            bufferedWriter.flush();
            // 推送
        }
        // 关闭流
        bufferedReader.close();
        bufferedWriter.close();
    }
}
