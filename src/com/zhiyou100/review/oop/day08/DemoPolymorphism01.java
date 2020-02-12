package com.zhiyou100.review.oop.day08;

/**
 * @packageName: javase_26
 * @className: DemoPolymorphism01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/12 10:22 上午
 */
public class DemoPolymorphism01 {
    public static void main(String[] args) {
        Son son = new Son();
        test1(son);
        // 需要一个父类对象，但传递的是子类对象
        System.out.println();
        // 等价于：
        Father father=son;
        //这就是多态
        /*
        什么是多态：
            给子类对象起个父类类型的名字
            让父类引用指向一个子类对象
            把子类对象伪装成父类对象使用

        格式：
            父类类型的引用 = 子类对象;
         */
    }
    public static void test1(Father father){
        /*
         * @name: test1
         * @description: TODO 需要一个父类对象调用其吃饭方法
         * @param father
         * @return: void
         * @date: 2020/2/12 10:30 上午
         * @author: YangLei
         *
        */
        father.eat();
        father.smoke();
        System.out.println(father.face+":::"+father.home);
    }

}
class Father{
    String face="🐒";
    String home="石道苗庄";
    void smoke(){
        System.out.println("爸爸吸水烟");
    }
    void eat(){
        System.out.println("真香！");
    }
}
class Son extends Father{
    String face="刀疤";
    String tattoo="天道酬勤";

    @Override
    void smoke() {
        System.out.println("儿子吸过滤嘴");
    }
    void game(){
        System.out.println("真好玩");
    }
}
