package com.zhiyou100.basicclass.day08;

/**
 * @packageName: javase_26
 * @className: Singleton
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/3 6:16 下午
 */
public class Singleton {
    /**
     * 目的：只允许此类创建一个对象
     * 方法：1. 构造方法私有化
     *      2. 提供一个私有的静态成员变量，来记录唯一的对象
     *      3. 提供一个静态方法返回此单例对象
     */
    public static void main(String[] args) {
        RecordsTheOrderInWhichObjectsAreCreated recordsTheOrderInWhichObjectsAreCreated = new RecordsTheOrderInWhichObjectsAreCreated();
        System.out.println(RecordsTheOrderInWhichObjectsAreCreated.getCnt());
        RecordsTheOrderInWhichObjectsAreCreated recordsTheOrderInWhichObjectsAreCreated1 = new RecordsTheOrderInWhichObjectsAreCreated();
        System.out.println(RecordsTheOrderInWhichObjectsAreCreated.getCnt());
        RecordsTheOrderInWhichObjectsAreCreated recordsTheOrderInWhichObjectsAreCreated2 = new RecordsTheOrderInWhichObjectsAreCreated();
        System.out.println(RecordsTheOrderInWhichObjectsAreCreated.getCnt());
    }
}

class OnlySingleton {
    /**
     * 饿汉单例模式，无论是否调用静态方法，都会创建一个对象
     */
    private OnlySingleton() {
        // 构造方法私有化
    }
    private static OnlySingleton s = new OnlySingleton();
    /**
     * 提供一个私有的静态的成员变量 来 记录唯一的对象
     * @return s
     */
    public static OnlySingleton getInstance() {
        // 提供一个静态方法来返回此单例对象
        return s;
    }
}
class OnlySingleton1 {
    /**
     * 懒汉单例模式 只有调用静态方法才会创建对象
     */
    private OnlySingleton1() {
        // 构造方法私有化
    }
    private static OnlySingleton1 s;
    /**
     * 提供一个私有的静态的成员变量 来 记录唯一的对象
     * @return s
     */
    public static OnlySingleton1 getInstance() {
        // 提供一个静态方法 返回此对象的实例
       if (s==null){
           s=new OnlySingleton1();
       }
       return s;
    }
}
class RecordsTheOrderInWhichObjectsAreCreated{
    /**
     * 记录对象创建的顺序
     */
    private static int cnt=0;
    // 记录次数

    public static int getCnt() {
        //提供一个get方法，获取cnt
        return cnt;
    }

    public RecordsTheOrderInWhichObjectsAreCreated(){
       cnt++;
       // 每创建一个对象，cnt+1
    }
}
class RecordsTheOrderInWhichObjectsAreCreated1{
    /**
     * 记录对象创建的顺序
     */
    private static int cnt=0;
    // 记录次数

    public final  int number;
    // 用一个final记录

    public RecordsTheOrderInWhichObjectsAreCreated1(){
       cnt++;
       // 每创建一个对象，cnt+1
        number =cnt;
        // 把cnt赋给final的number
    }
}