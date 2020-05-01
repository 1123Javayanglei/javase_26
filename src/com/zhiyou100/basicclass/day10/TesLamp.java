package com.zhiyou100.basicclass.day10;

/**
 * @packageName: javase_26
 * @className: TesLamp
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/5 5:23 下午
 */
class TestLamp {
    public static void main(String[] args) {
        class inner implements Light{

            @Override
            public void shine() {
                System.out.println("shine in red");
                // 局部内部类
            }
        }


        Lamp lamp = new Lamp();


        lamp.on(new inner());

        lamp.on(new inner(){
            @Override
            public void shine() {
                System.out.println("shine in yellow");
                // 匿名内部类
            }
        });

        lamp.on(new Light() {
            @Override
            public void shine() {
                System.out.println("shine in yellow");
                // 匿名内部类
            }
        });
    }
}