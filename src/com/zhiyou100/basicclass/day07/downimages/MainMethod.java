package com.zhiyou100.basicclass.day07.downimages;

import java.util.ArrayList;

/**
 * @packageName: javase_26
 * @className: MainMethod
 * @Description: TODO 集成方法
 * @author: YangLei
 * @date: 2020/4/14 10:07 上午
 */
public class MainMethod {
    String url="www.baidu.com";

    /**
     * url 是要下载的网页的链接
     */
    public MainMethod() {
    }

    public MainMethod(String url) {
        this.url = url;
    }
    public void run(){
        /*
         * 第一步，删除上一个已经下载的文件，防止冲突
         *
         * 第二步，通过链接，下载要下载图片的页面
         *
         * 第三步，把下载的html文件读到一个字符串中
         *
         * 第四步，处理字符串，返回一个格式完毕的集合
         *
         * 第五步，把集合写入到a.txt 文件中
         *
         * 第六部，通过wget -i 下载a.txt文件中的所有链接
         */

        String webString="";
        // 记录下载的html文件的内容
        ArrayList<String> str;
        // 记录处理完毕的字符串的集合


        DelTheFiles delTheFiles = new DelTheFiles();
        // 创建删除文件的类
        delTheFiles.del();
        // 调用删除方法

        DownFileForWeb downFileForWeb = new DownFileForWeb(url);
        // 创建下载html页面的类
        downFileForWeb.creatHtml();
        // 下载html界面

        ReadTheFile readTheFile = new ReadTheFile();
        // 创建读取html文件的类
        webString=readTheFile.getString();
        // 获取一个字符串，里面装的是上一步下载的html文件的内容

        ProcessingString processingString = new ProcessingString(webString);
        // 创建一个解析字符串的类，把上一步的字符串传进去
        str= processingString.getStr();
        // 获取处理好的集合

        WriterTheFile writerTheFile = new WriterTheFile(str);
        // 创建写文件的类
        writerTheFile.writerFile();
        // 写入文件

        DownloadThePictures downloadThePictures = new DownloadThePictures();
        // 创建下载图片的类
        downloadThePictures.downLoadImages();
        // 开启下载任务


    }

    public static void main(String[] args) {
        MainMethod mainMethod = new MainMethod();
        mainMethod.run();
    }
}
