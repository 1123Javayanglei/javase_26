package com.zhiyou100.basicclass.day31.designpattern;

/**
 * @packageName: javase_26
 * @className: DesignPatternDemo01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/4/13 4:05 下午
 */
public class DesignPatternDemo01 {

}
 class Demo {
}
class DemoFactory1{
    /**
     * 实例工厂模式
     * @return
     */
    public Demo newInstance(){
        return new Demo();
    }
}
class DemoFactory2{
    /**
     * 静态工厂模式
     * @return
     */
    public static Demo newInstance(){
        return new Demo();
    }
}
