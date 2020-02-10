package com.zhiyou100.review.oop.day06;

/**
 * @packageName: javase_26
 * @className: Demo02
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/10 3:13 下午
 */
public class Demo02 {
    public static void main(String[] args) {
        Son01 son01 = new Son01();
        son01.sayHi();
    }
}
class  Father01{
     void sayHi(){
        System.out.println("父亲 say hi");
    }
}
class  Son01 extends Father01{
    @Override
    protected void sayHi() {
        System.out.println("儿子 say hi");
    }

}
