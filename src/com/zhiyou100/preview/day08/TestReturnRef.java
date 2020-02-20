//package com.zhiyou100.preview.day08;
//
///**
// * @author yanglei
// */
////class ClassA {
////    int value = 10;
////}
//
///**
// * @author yanglei
// */
//public class TestReturnRef {
//    public static void main(String[] args) {
//        ClassA ca = new ClassA();
//        ca = getObject();
//        // 让ca指向getObject方法返回的对象
//        ca = getObject();
//        ca = getObject();
//        System.out.println(ca.value);
//    }
//    /**
//     * 如果方法没加static ，方法必须被对象调用
//     * 如果加了static，可以在方法中直接调用
//     */
//    public static ClassA getObject() {
//        ClassA newObject = new ClassA();
//        newObject.value += 10;
//        return newObject;
//    }
//}
