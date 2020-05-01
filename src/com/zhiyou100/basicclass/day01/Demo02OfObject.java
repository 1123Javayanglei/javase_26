package com.zhiyou100.basicclass.day01;

/**
 * @packageName: javase_26
 * @className: Demo02OfObject
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/20 9:00 下午
 */
public class Demo02OfObject {
    public static void main(String[] args) {
        Object object1 = new Object();
        Student student01 = new Student(11,"sb");
        Student student02 = new Student(11,"sb");
        Student student03 = new Student(12,"nb");
        var var01 = student01.getClass();

        System.out.println(student01.getClass());
        // class com.zhiyou100.basicclass.day01.Student 字节码文件
        System.out.println(var01.getName());
        // com.zhiyou100.basicclass.day01.Student 包名.类名
        System.out.println(var01.getSimpleName());
        // Student 类名

        System.out.println(student01);
        // com.zhiyou100.basicclass.day01.Student@72ea2f77 默认调用toString方法
        System.out.println(student01.toString());
        // com.zhiyou100.basicclass.day01.Student@72ea2f77 输出 类名 @ 地址
        System.out.println(student01.hashCode());
        // 1927950199 对象地址的哈希值
        int hashCode = student01.hashCode();
        System.out.println(Integer.toHexString(hashCode));
        // 72ea2f77 把哈希值转回对象的地址(16进制)

        System.out.println(student01.age);
        // 当两个对象指向一个地址，且不为null，返回true
        System.out.println(student01.equals(student03));

        System.out.println(student02.equals(student03));


    }
}
