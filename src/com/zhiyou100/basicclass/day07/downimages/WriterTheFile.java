package com.zhiyou100.basicclass.day07.downimages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @packageName: javase_26
 * @className: WriterTheFile
 * @Description: TODO 把集合中的每行链接存储到到一个名为a.txt的文件夹中
 * @author: YangLei
 * @date: 2020/4/13 6:25 下午
 */
public class WriterTheFile {
    String path = "/Users/yanglei/javatext/WebDown/WebFile";
    /**
     * path是a.txt的父级目录
     * arrayList 是处理好的字符串
     */
    ArrayList<String> arrayList;
    public WriterTheFile(ArrayList<String> arrayList) {
        /*
         * 通过构造方法付获取字符串
         */
        this.arrayList = arrayList;
    }

    /**
     * 获取 处理好的链接，写入到a.txt文件
     */
    void writerFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path, "a.txt")));
            // 创建高效输出流
            for (String s :
                    arrayList) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
