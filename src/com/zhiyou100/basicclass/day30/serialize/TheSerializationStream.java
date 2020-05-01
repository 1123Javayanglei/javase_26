package com.zhiyou100.basicclass.day30.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @packageName: javase_26
 * @className: TheSerializationStream
 * @Description: TODO 序列化流  // 把对象放在 /Users/yanglei/javatext/object 中
 * @author: YangLei
 * @date: 2020/4/11 12:34 上午
 * <p>
 * ObjectOutputStream 序列化流
 * 作用 ： 把内存中对象的信息持久的保存到外部设备中
 * <p>
 * 构造方法:
 * ObjectOutputStream(OutputStream out)  创建写入指定 OutputStream 的 ObjectOutputStream。
 * <p>
 * 普通方法:
 * void	close() 关闭流。
 * void	flush() 刷新该流的缓冲。
 * void	writeObject(Object obj) 将指定的对象写入 ObjectOutputStream。
 */
public class TheSerializationStream {
    private static final String FILE_NAME = "/Users/yanglei/javatext/object";

    public static void main(String[] args) {
        // 把对象放在 /Users/yanglei/javatext/object 中
        String s = new String("我要被存储在文件中");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            // 创建字节流和文件关联

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // 创建序列化流于字节流关联

            objectOutputStream.writeObject(s);
            // 把String类型的字符串存储
            objectOutputStream.flush();
            // 刷新
            objectOutputStream.close();
            // 关闭
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
