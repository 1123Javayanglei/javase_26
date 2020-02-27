package com.zhiyou100.basicclass.day05;

/**
 * @packageName: javase_26
 * @className: Body
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/27 11:07 下午
 */
public class Body {
    // 外部类
    public class Heart {
        // 成员内部类
        public void beat() {
            //内部类方法
            System.out.println("心跳");
            System.out.println("我叫："+name);
            // 正确写法
        }
    }
    public String name;
    // 外部类的成员变量
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void methodBody() {
        // 外部类的方法
        System.out.println("外部类的方法");
        /**
         * 1、
         *    Heart heart=new Heart();
         *         heart.beat();
         *
         *  2、 new Heart().beat();
         */
        new Heart().beat();
        //匿名对象
    }
}
