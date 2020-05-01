package com.zhiyou100.basicclass.day20.filedemo;

import com.zhiyou100.basicclass.day17.HashDemo1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @packageName: javase_26
 * @className: FileDemo1
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/18 10:20 上午
 */
public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        /**
         * File 类的字段：
         * static String separator
         */
        System.out.println(File.separator);
        // out / ⚠️：转义字符，需要写两个
        /**
         * File 类的构造方法1
         * File(String pathname)
         */
        File file = new File("/Users/yanglei/Desktop/text");
        // 写法一：\\
        // 写法二：/
        System.out.println(file);
        // out /Users/yanglei/Desktop/text 重写了toString方法

        /**
         * File 类的构造方法2
         * File(String parent,String child)
         */
        File a = new File("/Users/yanglei/Desktop/text", "a");
        System.out.println(a);
        // out /Users/yanglei/Desktop/text/a

        /**
         * File 类的构造方法3
         * File(File parent,String child)
         */
        File b = new File(file, "b");
        System.out.println(b);
        //out /Users/yanglei/Desktop/text/b
        File file1 = new File(file, "a.txt");
        System.out.println(file1);
        //out /Users/yanglei/Desktop/text/a.txt

        /**
         * File 类的普通方法
         *      判断
         *          boolean exists() 判断当前file是否存在
         *          boolean isDirectory() 测试此抽象路径名表示的文件是否是一个目录。
         *          boolean	isFile()  测试此抽象路径名表示的文件是否是一个标准文件。
         *
         *      创建
         *           boolean	createNewFile() 创建一个新文件，返回值表示是是否成功
         *           boolean	mkdir() 创建此抽象路径名指定的目录。
         *           boolean	mkdirs() 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
         *
         *      获取
         *           String	getPath() 将此抽象路径名转换为一个路径名字符串。
         *           String	getName() 返回由此抽象路径名表示的文件或目录的名称。
         *           File	getAbsoluteFile() 返回此抽象路径名的绝对路径名形式。
         *           String	getParent() 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。
         *           File	getParentFile() 返回此抽象路径名父目录的抽象路径名；如果此路径名没有指定父目录，则返回 null。
         *           long	getTotalSpace() 返回此抽象路径名指定的分区大小。
         *           long	length() 返回由此抽象路径名表示的文件的长度,如果此路径名表示一个目录，则返回值是不确定的。
         *           File[]	listFiles() 返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
         *
         *      删除
         *          boolean	delete() 删除此抽象路径名表示的文件或目录。如果此路径名表示一个目录，则该目录必须为空才能删除。
         *
         *      重命名
         *          boolean renameTo(File dest) 重命名
         *
         *
         *
         */
        HashDemo1.printCutOffRule();
        System.out.println(b.exists());
        // out true
        System.out.println(b.isDirectory());
        // out true
        System.out.println(file1.isFile());
        // out false

        HashDemo1.printCutOffRule();

//创建文件
        HashDemo1.printCutOffRule();
        File file2 = new File("/Users/yanglei/Desktop/text/child/child1/child2");
        // out true
        System.out.println(file2.mkdirs());

        HashDemo1.printCutOffRule();
        File file3 = new File("./text.txt");
        // 相对路径 当前项目 /Users/yanglei/Documents/javase_26/.
        System.out.println(file3.createNewFile());
        // out true
        File file4 = new File("/Users/yanglei/Documents/javase_26/text1.txt");
        // 绝对路径
        System.out.println(file4.createNewFile());
        //out true
        HashDemo1.printCutOffRule();

        System.out.println(file4.getName());
        // text1.txt 不带父目录
        System.out.println(file4.getPath());
        // /Users/yanglei/Documents/javase_26/text1.txt 路径
        System.out.println(file4.getAbsolutePath());
        // /Users/yanglei/Documents/javase_26/text1.txt 绝对路径

        System.out.println(file3.getName());
        // text.txt 不带父目录
        System.out.println(file3.getPath());
        // ./text.txt 路径
        System.out.println(file3.getAbsolutePath());
        // /Users/yanglei/Documents/javase_26/./text.txt 绝对路径
        HashDemo1.printCutOffRule();


        System.out.println(file4.getParent());
        // 获取父目录 /Users/yanglei/Documents/javase_26
        System.out.println(file4.getParentFile());
        // 获取父目录对象 /Users/yanglei/Documents/javase_26

        HashDemo1.printCutOffRule();

        System.out.println(file3.getTotalSpace());
        // out 250685575168 当前路径指定的分区大小，以字节为单位
        System.out.println(file3.length());
        // out 160 当前文件占的字节数
        File file5 = new File("/Users/yanglei/Documents/javase_26");
        System.out.println(file5.length());
        // out 480 如果此路径名表示一个目录，则返回值是不确定的。

        HashDemo1.printCutOffRule();
        File[] file6=file.listFiles();
        System.out.println(Arrays.toString(file6));

        HashDemo1.printCutOffRule();
        System.out.println(file.delete());
        // false 必须为空才能删除
        System.out.println(file3.delete());
        // true
        System.out.println(file4.delete());
        // true
        File[] files=new File("/Users/yanglei/Desktop/重名名").listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].delete());
        }
        System.out.println(new File("/Users/yanglei/Desktop/重名名").delete());

        HashDemo1.printCutOffRule();
        System.out.println(file.renameTo(new File("/Users/yanglei/Desktop/重名名")));








    }
}
