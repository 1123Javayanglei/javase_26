package com.zhiyou100.basicclass.day07.downimages;

import com.zhiyou100.basicclass.day20.filedemo.FileDemo2;

/**
 * @packageName: javase_26
 * @className: DelTheFiles
 * @Description: TODO 删除文件，防止无法下载
 * @author: YangLei
 * @date: 2020/4/13 6:50 下午
 */
public class DelTheFiles {
    String fatherPath = "/Users/yanglei/javatext/WebDown/WebFile/";
    String sonOfTxt = "a.txt";
    String sonOfIndex = "index.html";
    String sonOfImages = "imags";
    public void del(){
        /**
         * 删除上一次下载的文件文件
         */
        FileDemo2.delString(fatherPath + sonOfIndex);
        FileDemo2.delString(fatherPath + sonOfImages);
        FileDemo2.delString(fatherPath + sonOfTxt);
        try {
            Thread.sleep(3000);
            // 线程休眠
        } catch (InterruptedException e) {
            System.out.println("删除文件出错");
        }
    }
}
