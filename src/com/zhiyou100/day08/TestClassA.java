package com.zhiyou100.day08;

/**
 * @author yanglei
 */
class ClasssA {
    int value;

    public void method(int value) {
        System.out.println(value);
    }
    public void method() {
        System.out.println(value);
    }
}
class TestClassA {
    public static void main(String[] args) {
        ClasssA classA = new ClasssA();
        classA.value = 10;
        classA.method();
        classA.method(20);
    }
}

