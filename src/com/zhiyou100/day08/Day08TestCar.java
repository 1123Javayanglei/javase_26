package com.zhiyou100.day08;

/**
 * @author yanglei
 */
public class Day08TestCar {
    public static void main(String[] args) {
         Car p1 = new Car();
         p1.logo ="Bugatti Veyron";
         p1.speed=430;
         p1.color="black";
         p1.money=1700000;
         p1.show();
         p1.run();

        p1.add(1,2);
    }
}
class Car{
    String logo;
    double speed;
    String  color;
    double money;

    public int add(int a,int b){
        System.out.println("I am here!");
        return a+b;
    }

    public void run(){
        System.out.println("I can speed "+speed+" Km/h");
    }
    public void show(){
        System.out.println("My name is "+logo+", money: "+money+"$ color: "+color);
    }
}
