package com.zhiyou100.basicclass.day14.Pdf11Of14;

/**
 * @packageName: javase_26
 * @className: User
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/10 7:32 下午
 */
public class User {
    /** 
     * @name: User
     * @date: 2020/3/10 7:34 下午
     * @description: TODO 创建一个 User 类，包括：用户登录名（ username）、密码（password）、用 户真实姓名（name）、电子邮件地址（email）属性和相应的构造方法及 set/get 方 法。
     */
    private String username;
    private String password;
    private String name;
    private String email;

    public User() {
    }

    public User(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
