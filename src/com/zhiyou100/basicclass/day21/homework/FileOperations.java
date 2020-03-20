package com.zhiyou100.basicclass.day21.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @packageName: javase_26
 * @className: FileOperations
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/19 8:07 下午
 */
public class FileOperations {
    public static void main(String[] args) throws Exception {
        String old = "/Users/yanglei/Downloads/课程录屏";
        String now = "/Users/yanglei/Downloads/text";
        copy(old, now);
    }

    public static void copyByByte(String old, String now) {
        /*
         * @description: Todo 把old对应的文件中的所有数据，复制到now文件中，逐个字节的读写
         * 步骤：
         *  1、把old文件读出来
         *  2、把old读出来的字节写入now
         *  3、结束
         */
        try {
            FileInputStream fileInputStream1 = new FileInputStream(old);
            // 创建输出流与目的文件关联
            FileOutputStream fileInputStream = new FileOutputStream(now);
            // 创建输入流与目的文件关联
            int n;
            // 记录输出流的值
            while (true) {
                n = fileInputStream1.read();
                // 把old文件读出来
                if (n == -1) {
                    // 如果n=-1 跳出
                    break;
                }
                fileInputStream.write(n);
                // 把读入的写入
            }
            fileInputStream.close();
            fileInputStream1.close();
            // 关闭
        } catch (Exception e) {
            // 如果文件不存在，输出
            System.out.println("文件不存在");
        }

    }

    public static void copyByByteArray(String old, String now) {
        /*
         * @description: Todo 把old对应的文件中的所有数据，复制到now文件中，逐个字节数组的读写
         * 步骤：
         *  1、把old文件读出来
         *  2、把old读出来的字节写入now
         *  3、结束
         */
        try {
            FileInputStream fileInputStream1 = new FileInputStream(old);
            // 创建输出流与目的文件关联
            FileOutputStream fileInputStream = new FileOutputStream(now);
            // 创建输入流与目的文件关联

            byte[] bytes = new byte[4];
            // 创建数组放读入
            while (true) {
                // 循环遍历
                int n = fileInputStream1.read(bytes, 0, bytes.length);
                // 用n记录
                if (n == -1) {
                    // 如果没有了，跳出
                    break;
                }
                for (int i = 0; i < n; i++) {
                    // 遍历写入
                    fileInputStream.write(bytes[i]);
                }
            }
            fileInputStream.close();
            fileInputStream1.close();
            // 关闭
        } catch (Exception e) {
            // 如果文件不存在，输出
            System.out.println("文件不存在");
        }

    }

    public static void copy(String old, String now) throws Exception {
        //1 就行合理判断：yuan、muDi必须存在
        System.out.println("我执行了");
        File oldFile = new File(old);
        if (!oldFile.exists()) {
            throw new RuntimeException("源文件:" + oldFile.getAbsolutePath() + "不存在！");
        }
        File muDiFile = new File(now);
        if (!muDiFile.exists()) {
            if (!muDiFile.mkdirs()) {
                throw new RuntimeException("目的文件:" + oldFile.getAbsolutePath() + "创建失败！");
            }
        }
        //2 判断源文件的类型
        if (oldFile.isFile()) {
            File nowFile = new File(muDiFile, oldFile.getName());
            //需要在muDiFile下创建一个与yuanFile同名的文件
            //把源文件复制到目的目录中
            FileInputStream fin = new FileInputStream(oldFile);
            //创建输入流与源文件关联：：：把目的文件中的信息读到内存中
            FileOutputStream fileOutputStream = new FileOutputStream(nowFile);
            //创建输出流与目的文件关联：：：  输出流可以自动创建目的文件
//		    while(true){//选择读写方法：逐个字节的读写
//		    	int n=fin.read();//定义变量记录读取的字节信息
//		    	if(n==-1){break;}//判断是否到达文件末尾
//		    	fout.write(n);//把读取的信息通过输出流写出去
//		    }
            while (true) {
                //选择读写方式：逐个字节数组的读写
                byte[] arr = new byte[1024];
                //创建一个数组 装读取的字节
                int n = fin.read(arr, 0, 1024);
                //使用arr来记录读取的字节  记录最多1024个  n记录的读取的有效字节数
                if (n == -1) {
                    break;
                }
                fileOutputStream.write(arr, 0, n);
                //把读取的信息通过输出流写出去
            }
            fin.close();
            fileOutputStream.close();//关闭流
            return;
        }
        //说明是文件夹   获取文件夹下的所有子文件  把子文件拷贝到muDiFileNew下
        //需要在muDiFile下创建一个与yuanFile同名的文件夹
        File muDiFileNew = new File(muDiFile, oldFile.getName());
        muDiFileNew.mkdirs();
        File[] fileZis = oldFile.listFiles();
        //遍历yuanFile文件夹下的所有子文件
        assert fileZis != null;
        for (File zi : fileZis) {
            //要把zi拷贝到muDiFileNew文件夹下
            copy(zi.getAbsolutePath(), muDiFileNew.getAbsolutePath());
        }
    }
}
