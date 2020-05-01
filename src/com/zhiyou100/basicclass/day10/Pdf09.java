package com.zhiyou100.basicclass.day10;

//package com.zhiyou100.basicclass.day10;
//
//class Student{
//    private int age;
//    private String name;
//    public Student(){}
//    public Student(String name, int age){
//        this.name = name;
//        this.age = age;
//    }
//    @Override
//    public String toString(){
//        return name + " " + age;
//    }
//}
//class TestStudent{
//    public static void main(String[] args){
//        Student stu1 = new Student();
//        Student stu2 = new Student("Tom", 18);
//        System.out.println(stu1);
//        // 默认调用stu1.toString 方法
//        // null 0
//        System.out.println(stu2);
//        // Tom 18
//    }
//}
// class TestEquals{
//    public static void main(String args[]){
//        String str1 = new String("hello");
//        String str2 = new String("hello");
//        System.out.println(str1.equals(str2));
//        System.out.println(str1 == str2);
//    }
//}
//class Animal{}
//class Dog extends Animal{}
// class TestGetClass{
//    public static void main(String args[]){
//        Animal a1 = new Dog();
//        Animal a2 = new Animal();
//        System.out.println(a1 instanceof Animal);
//        System.out.println(a1.getClass() == a2.getClass());
//        // getClass 获得本来的类型
//    }
//}
//
//class Number11{
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String into=scanner.next();
//        // 从输入中读取一个字符串
//        int number1=Integer.parseInt(into);
//        System.out.println("直接转换为int类型："+number1);
//        Integer integer=Integer.valueOf(into);
//        int number2=integer;
//        System.out.println("转为Integer，再转为int："+number2);
//
//    }
//}
//interface IA{
//    void ma();
//}
//class Myclass implements IA{
//    public void ma(){}
//    public String toString(){
//        return "MyClass toString()";
//    }
//}
//class TestMyclass{
//    public static void main(String[] args) {
//        IA ia=new Myclass();
//        System.out.println(ia);
//        // "MyClass toString()"
//    }
//}

//interface IA {
//    void ma();
//}
//
//class MyClass {
//    public static void method(IA ia) {
//        System.out.println("in method");
//        ia.ma();
//    }
//}
//
//class TestInnerClass {
//    public static void main(String[] args) {
//        MyClass.method(
//                new IA() {
//                    @Override
//                    public void ma() {
//                        System.out.println("ma in anonymous inner class");
//                    }
//                }
//        );
//        class MyMaClass implements IA {
//            @Override
//            public void ma() {
//                System.out.println("ma in local inner class");
//            }
//        }
//        MyClass.method(new MyMaClass());
//    }
//}


interface Light{
    void shine();
}
//定义Lamp 类：
class Lamp{
    public void on(Light light){
        light.shine();
    }
}