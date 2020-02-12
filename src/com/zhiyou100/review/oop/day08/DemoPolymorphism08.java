package com.zhiyou100.review.oop.day08;

/**
 * @packageName: javase_26
 * @className: DemoPolymorphism08
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/12 9:08 下午
 */
public class DemoPolymorphism08 {
    public static void main(String[] args) {
        Lamp01 lamp01=new RedBule01("第1");
        lamp01.on();
    }
    public static void kai(Lamp01 lamp01){
        lamp01.on();
    }
}
class Lamp01{
    String deng;

    public Lamp01(String deng) {
        this.deng = deng;
    }

    void on(){
        System.out.println(deng);
    }
}
class RedBule01 extends Lamp01{
    public RedBule01(String deng) {
        super(deng);
    }

    @Override
    void on() {
        System.out.println("红灯亮了 "+deng);
    }
}
class GreenBule extends Lamp01{
    public GreenBule(String deng) {
        super(deng);
    }

    @Override
    void on() {
        System.out.println("绿灯亮了 "+deng);
    }
}
