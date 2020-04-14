package com.zhiyou100.basicclass.day07.downimages;

import java.io.IOException;

/**
 * @packageName: javase_26
 * @className: DownloadThePictures
 * @Description: TODO 通过 fuck wget -i a.txt 下载所有图片
 * @author: YangLei
 * @date: 2020/4/14 9:57 上午
 */
public class DownloadThePictures {
    public void downLoadImages(){
        /**
         * 通过 fuck wget -i a.txt -P /Users/yanglei/javatext/WebDown/WebFile/imags 下载图片
         */
        String cmd="fuck wget -i a.txt -P /Users/yanglei/javatext/WebDown/WebFile/imags";
        try {
            Runtime.getRuntime().exec(cmd);
            Thread.sleep(5000);
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
