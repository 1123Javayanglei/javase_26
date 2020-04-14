package com.zhiyou100.basicclass.day07.downimages;

import java.io.IOException;

/**
 * @packageName: javase_26
 * @className: DownFileForWeb
 * @Description: TODO 下载 index.html文件
 * @author: YangLei
 * @date: 2020/4/13 4:32 下午
 */
public class DownFileForWeb {
    String theUrl;
    public DownFileForWeb(String theUrl) {
        this.theUrl = theUrl;
    }

    public void creatHtml() {
        /*
         *  通过wget 下载文件
         */
        String cmd="fuck wget -O index.html -P /Users/yanglei/javatext/WebDown/WebFile "+theUrl;
        String cmd1="wget -O index.html -P /Users/yanglei/javatext/WebDown/WebFile "+theUrl;
        // 通过代理下载，并指定位置
        try {
            System.out.println(cmd1);
            Runtime.getRuntime().exec(cmd1);
//            Runtime.getRuntime().exec(cmd);
            // 停一下
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String url="www.baidu.com";
        String cmd="wget -O index.html -P /Users/yanglei/javatext/WebDown/WebFile "+url;

        System.out.println(cmd);

        try {
            Runtime.getRuntime().exec(cmd);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
