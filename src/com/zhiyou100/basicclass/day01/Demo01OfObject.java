package com.zhiyou100.basicclass.day01;

import java.util.Objects;

/**
 * @packageName: javase_26
 * @className: Demo01OfObject
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/20 11:13 上午
 */
public class Demo01OfObject {
    /**
     * Object 方法
     * 1.
     * 2.hashCode 获得对象的内存地址
     * 3. getClass()
     */
    public static void main(String[] args) {
        Object object1 = new Object();
        int hc = object1.hashCode();
        System.out.println(hc);
        // 哈希值 1528902577
        System.out.println(object1);
        // 地址 java.lang.Object@5b2133b1
        System.out.println(Integer.toHexString(hc));
        // 16进制的字符串


        Demo01 demo01 = new Demo01();
        Demo01 demo02 = new Demo01();
        Class class01 = demo01.getClass();
        System.out.println(demo01.getClass());
        // 字节码文件
        System.out.println(class01.getName());
        // 包名+类名
        System.out.println(class01.getSimpleName());
        // 类名

        System.out.println(demo01.toString());


        demo01.age = 11;
        demo01.name = "123";
        demo02.age = 11;
        demo02.name = "1235";
        System.out.println(demo01.equals(demo02));

    }
}

class Student {

}

class Demo01 {
    int age;
    String name;

    public String myToString() {
        /**
         * 先获取字节码文件对象
         * 再获取类名
         * 获取地址
         * 转换进制
         */
        Class class1 = this.getClass();
        String className = class1.getName();
        int hashCode = this.hashCode();
        String hashCode16 = Integer.toHexString(hashCode);
        return className + "@" + hashCode16;

    }

    @Override
    public String toString() {
        /**
         * @name: toString
         * @param: null
         * @description: TODO 获取属性的值
         * @date: 2020/2/20 11:43 上午
         * @return:
         */
        return "Demo01{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        /**
         * @name: equals
         * @param: null
         * @description: TODO 判断name和age属性是否相同
         * @date: 2020/2/20 11:45 上午
         * @return:
         */
        // 向下转型
        if (o instanceof Demo01) {
            Demo01 demo01 = (Demo01) o;
            return (this.name.equals(((Demo01) o).name) && this.age == ((Demo01) o).age)||(this.name==null&&((Demo01) o).name==null||this.age==0&&((Demo01) o).age==0) ;
        }
        return false;
    }


}