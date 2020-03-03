package com.zhiyou100.basicclass.day08;

/**
 * @packageName: javase_26
 * @className: DesignPatterns
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/3 1:15 下午
 */
public class AbstractFactoryPattern {
    /**
     * 抽象工厂
     *  思路：A类的创建 由B类的静态方法来实现
     *  作用：把创建对象的具体过程屏蔽隔离起来，达到提高灵活性的目的
     */
    public static void main(String[] args) {
        House house=HouseFactory.BuyHouse("DelicateDecoration");
        house.live();
    }
}

interface House {
    void live();
    // 居住功能
}

class DelicateDecoration implements House {
    @Override
    public void live() {
        System.out.println("精致生活");
    }
}

class OrdinaryHouses implements House {
    @Override
    public void live() {
        System.out.println("简约而不简单，经济实用");
    }
}

class HouseFactory {
    public static House BuyHouse(String s) {
        if ("DelicateDecoration".equals(s)) {
            return new DelicateDecoration();
        }
        if ("OrdinaryHouses".equals(s)) {
            return new OrdinaryHouses();
        }
        return null;
    }
}