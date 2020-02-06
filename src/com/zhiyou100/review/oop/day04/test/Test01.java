package com.zhiyou100.review.oop.day04.test;

/**
 * @author yanglei
 */
public class Test01 {
    private String privateField="私有的";
    String field="默认的";
    protected String protectedField="受保护的";
    public  String publicField="公共的";

    public void show(){
        // 在本类中可以访问4个属性
        System.out.println(privateField+" "+field+" "+protectedField+" "+publicField);
    }
}
