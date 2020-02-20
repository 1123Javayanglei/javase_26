package com.zhiyou100.oop.day03;

/**
 * @author yanglei
 */
public class Demo01 {
    public static void main(String[] args) {
        Car car = new Car();
        car.color = '黑';
        Car car1 = new Car(200);
        car.setMoney(100);
    }
}

class Car {
    char color;
    String logo = "布加迪威龙";
    double money;
    Car(double money) {
        if (money >= 0) {
            this.money = money;
        }
    }
    public Car() {}
    public void setMoney(double money) {
        if (money > 0) {
            this.money = money;
        }
    }
}
