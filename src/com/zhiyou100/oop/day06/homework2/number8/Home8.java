package com.zhiyou100.oop.day06.homework2.number8;

/**
 * @packageName: javase_26
 * @className: Home8
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/11 12:07 上午
 */
public class Home8 {
    public static void main(String[] args) {
        ClassD cd1 = new ClassD();
        ClassD cd2 = new ClassD(10);
    }
}
class ClassA{
    public ClassA(){
        System.out.println("ClassA()");
    }
}
class ClassB{
    public ClassB(){
        System.out.println("ClassB()");
    }
}
class ClassC extends ClassA{
    public ClassC(){
        System.out.println("ClassC()");
    }
}
class ClassD extends ClassB{
    private ClassA classA=new ClassA();
    private ClassC classC;
    public ClassD(){
        System.out.println("ClassD()");
    }
    public ClassD(int i){
        classC=new ClassC();
        System.out.println("ClassD(int)");
    }

}