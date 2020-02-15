package com.zhiyou100.review.oop.day11;


/**
 * @packageName: javase_26
 * @className: Pdf07OfDemo01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/15 8:55 上午
 */
public class Pdf07OfDemo01 {
}
class MyClass01{
    int a;
    static int b;
    void fa(){}
    static void fb(){}
    public void m1(){
        System.out.println(a);
        System.out.println(b);
        fa();
        fb();
    }
    public static void m2(){
        // 报错原因 ： 静态方法中无法调用实例成员
//        System.out.println(a);
        System.out.println(b);
//        fa();
        fb();
    }
}
class MyClass02{
    static int cnt=0;
    public MyClass02(){
        cnt++;
        System.out.println(cnt);
    }
}
class TestMain01{
    public static void main(String[] args) {
        MyClass02 myClass01 = new MyClass02();
        MyClass02 myClass02 = new MyClass02();
        MyClass02 myClass03 = new MyClass02();
    }
}
class MyClass03{
    static int i=10;
    static {
        i=20;
        System.out.println("In Static");
    }
    public MyClass03(){
        System.out.println("MyClass()");
    }
    public MyClass03(int i){
        System.out.println("MyClass(int)");
        this.i=i;
    }
}
class TestMain02{
    public static void main(String[] args) {
        MyClass03 myClass01=new MyClass03();
        System.out.println(myClass01.i);
        MyClass03 myClass02=new MyClass03(10);
        System.out.println(myClass02.i);
    }
}
class Super04{
    int a=10;
    public static void m1(){
        System.out.println("m1 in Super");

    }
    public void m2(){
        System.out.println("m2 in Super");
    }
}
class Sub04 extends Super04{
    public static void m1(){
        System.out.println("m1 in Sub");
    }
    @Override
    public void m2(){
        System.out.println("m2 in Sub");
    }
}
class TestMain03 {
    public static void main(String[] args) {
        Super04 sup = new Sub04();
        sup.m1();
        sup.m2();
        Sub04 sub = (Sub04) sup;
        sub.m1();
        sub.m2();
    }
}
class MyClass05 {
    public void printValue(final int value){
        System.out.println(value);
    }
    public void changeValue(int value){
        value=value*2;
        System.out.println(value);
    }
}
class TestMain05{
    public static void main(String[] args) {
        MyClass05 myClass05=new MyClass05();
        int value=5;
        final int fValue=10;
        myClass05.printValue(value);
        myClass05.printValue(fValue);
        myClass05.changeValue(value);
        myClass05.changeValue(fValue);
    }

}
abstract   class AbstractMyClass06{
//    abstract final void m();

    /**
     * Illegal combination of modifiers: 'abstract' and 'final'
     * 修饰语的非法组合：“抽象”和“最终”
     */
//    static abstract void my();
    // Illegal combination of modifiers: 'abstract' and 'static'
    // 修饰语的非法组合：“抽象”和“静态”
    private final void m() {

    }
//    private abstract void my();
//    Illegal combination of modifiers: 'abstract' and 'private'
//    修饰符的非法组合 抽象和私有
    public static final void my(){}
//    public void final m2(){}
//    Modifier 'final' not allowed here
//    此处允许使用final
}