package com.zhiyou100.review.oop.day02;

/**
 * @author yanglei
 */
public class Review02 {
    public static void main(String[] args) {
        Car c1=new Car('白',"吉利");
        c1.color='红';
        c1.show();
        Car c2=c1;
        c2.setMoney(2000);
    }
}
class Car{
    char color;
    double money=1000.0;
    String logo="bmw";
    void show(){
        System.out.println(color+","+logo+","+money);
    }
    public Car(char color,String logo){
        this.color=color;
        this.logo=logo;
    }
    void  setMoney(double money){
        this.money=money;
    }
}