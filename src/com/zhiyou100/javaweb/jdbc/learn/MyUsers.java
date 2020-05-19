package com.zhiyou100.javaweb.jdbc.learn;

/**
 * @packageName: javase_26
 * @className: MyUsers
 * @Description: TODO
 * @author: yanglei
 * @date: 2020/5/17
 */
public class MyUsers {
    private String name;;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MyUsers(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyUsers{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
