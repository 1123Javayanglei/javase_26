package com.zhiyou100.basicclass.day07.downimages;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @packageName: javase_26
 * @className: ProcessingString
 * @Description: TODO 处理字符串，返回一个格式完毕的集合
 * @author: YangLei
 * @date: 2020/4/13 4:32 下午
 */
public class ProcessingString {
    /**
     * 获取读取出来的字符串
     */
    String str;

    public ProcessingString(String str) {
        this.str = str;
    }

    public ArrayList<String> getStr() {
        ArrayList<String> arrayList = new ArrayList<>();
        // 用arrayList记录匹配出来的每一个链接
        String urlRegex = "https://[^\":<>]*\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png)";
        // 匹配图片正则
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        // 匹配表达式，忽略大小写
        Matcher matcher = pattern.matcher(str);
        // 对匹配的集合进行循环处理，将文件保存到本地
        while (matcher.find()) {
            String mather = matcher.group(0);
            // 定义字符串，记录匹配到的链接
            arrayList.add(mather);
        }
        return arrayList;
    }
}
