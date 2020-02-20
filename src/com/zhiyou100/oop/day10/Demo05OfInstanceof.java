package com.zhiyou100.oop.day10;

/**
 * @packageName: javase_26
 * @className: Demo04OfInstanceof
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/14 9:04 下午
 */
public class Demo05OfInstanceof {
    public static void main(String[] args) {
        showAnimal(new Cat());
        showAnimal(new Dog());
        showAnimal(new Animal());
    }

    public static void showAnimal(Animal animal) {
        // 只能调用实现类在接口中定义过的方法
//         animal.eat();
//         animal.show();

        /**
         * // 想调用实现类的特有成员
         * 先判断多态对象的具体类型： 展现得是Animal
         * 判断对态对象的具体类型 通过 instanceof 关键字 是运算符
         */
        System.out.println("animal 是 Cat 类型的吗:" + (animal instanceof Cat));
        System.out.println("animal 是 Dog 类型的吗:" + (animal instanceof Dog));
        System.out.println("animal 是 Animal 类型的吗:" + (animal instanceof Animal));
        /**
         * 把子类对象伪装成发了对象 ：： 向上转型
         *  格式 ： 父类引用 = 子类对象;
         *  1 隐藏父类特有
         *  2 隐藏子类重新定义的成员变量
         *  3 显示父类被隐藏的成员变量
         *
         * 把多态对象 打回原形 ：： 向下转型
         *  格式：子类引用 = (子类类型)多态对象;
         *  1 显示子类特有
         *  2 显示子类重新定义的成员变量
         *  3 隐藏父类被重新定义的成员变量
         */
//        Dog dog =(Dog)animal;
        //将 'animal' 转换为 'Dog' 可能产生 'ClassCastException'
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            // 向下转型
            cat.sport();
            // 调用cat特有的成员
        } else if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            // 向下转型
            // 调用dog的特有成员
            dog.sport();
        }


    }
}

class Animal {
    void eat(){};

    void show(){};
}

class Dog extends Animal {
    String name;

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    @Override
    public void show() {
        System.out.println("狗 名字" + name);
    }

    public void sport() {
        System.out.println("狗 名字" + name + ",在抓老鼠!!!");
    }
}

class Cat extends Animal {
    String name;

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void show() {
        System.out.println("猫 名字" + name);
    }

    public void sport() {
        System.out.println("猫 名字" + name + ",在晒太阳!!!");
    }
}