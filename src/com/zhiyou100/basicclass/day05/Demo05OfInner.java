package com.zhiyou100.basicclass.day05;

/**
 * @packageName: javase_26
 * @className: Demo05OfInner
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/28 12:30 上午
 */

/**
 * 如果接口的实现类，或者父类的子类，只需要使用唯一的一次，
 * 那么这种情况下，就可以省略掉该类的定义，而改为使用【匿名内部类】
 *
 * 格式：
 *  接口名称 对象名 = new 接口名称(){
 *      //覆写所有的抽象方法
 *  };
 *
 *  对格式进行解析"new 接口名称(){.....}:
 *  1.new代表创建对象的动作
 *  2.接口名称就是匿名内部类需要实现哪个接口
 *  3.{...}这才是匿名内部类的内容
 *
 *  注意：
 *  1.匿名内部类，在【创建对象】的时候，只能使用唯一一次，如果希望多次创建对象，那就必须使用单独定义的实现类了
 *  2. 匿名对象，在【调用方法】的时候，只能调用唯一一次，如果希望同一个对象，调用多次方法，那么必须给对象起个名字
 *  3. 匿名内部类是省略了【实现类/子类名称】，但是匿名对象是省略了【对象名称】，强调：匿名内部类和匿名对象不是一回事！！！
 */
public class Demo05OfInner {
    public static void main(String[] args) {
//        MyInterface myInterface=new MyInterfaceImpl();
//        myInterface.medthod();

        // 使用了匿名内部类，但不是匿名对象，对象名是 myInterface
        MyInterface myInterface=new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类实现了方法！11--a");
            }

            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！22--a");
            }
        };
        myInterface.method();
        myInterface.method1();
        System.out.println("====================");
        // 使用了匿名内部类，而且省略了对象名称，也是匿名对象
        new MyInterface(){
            @Override
            public void method() {
                System.out.println("匿名内部类实现了方法！11--b");
            }

            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！22--b");
            }
        }.method();
        // 只能调用一次  .method().method 错
        new MyInterface(){
            @Override
            public void method() {
                System.out.println("匿名内部类实现了方法！11--b");
            }

            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！22--b");
            }
        }.method1();
        // 只能调用一次  .method().method 错误

    }
}
interface MyInterface{
    void method();
    void method1();
}
class MyInterfaceImpl implements MyInterface{

    @Override
    public void method() {
        System.out.println("实现类覆写了方法！");
    }

    @Override
    public void method1() {
        System.out.println("实现类覆写了方法！");
    }
}
