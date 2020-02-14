package com.zhiyou100.review.oop.day10;

/**
 * @packageName: javase_26
 * @className: Pdf06
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/14 1:56 下午
 */
public class Pdf06 {
    public static void main(String[] args) {
        Student student=new Student();

        student.setAddress("河南");
        student.setZipCoed("3432");
        student.setAge(33);
        student.setMobile("123451234");
        student.setName("张三");
        PostAddress postAddress=student.getPostAddress();
        // 用对象放
        System.out.println(postAddress.getAddress()+" "+postAddress.getZipCoed());
    }
}

class Student {
    private String name;
    private int age;
    private String address;
    private String zipCoed;
    private String mobile;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCoed() {
        return zipCoed;
    }

    public void setZipCoed(String zipCoed) {
        this.zipCoed = zipCoed;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public PostAddress getPostAddress() {
        // 返回对象
        return  new PostAddress(address,zipCoed);
    }
}

class PostAddress {
    // 面向对象
    private String address;
    private String zipCoed;

    public PostAddress() {
    }

    public PostAddress(String address, String zipCoed) {
        this.address = address;
        this.zipCoed = zipCoed;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCoed() {
        return zipCoed;
    }

    public void setZipCoed(String zipCoed) {
        this.zipCoed = zipCoed;
    }
}
