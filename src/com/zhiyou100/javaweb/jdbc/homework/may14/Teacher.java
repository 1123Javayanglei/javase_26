package com.zhiyou100.javaweb.jdbc.homework.may14;

/**
 * @packageName: javase_26
 * @className: myTeacher
 * @Description: TODO 用于数据库的老师类
 * @author: yanglei
 * @date: 2020/5/14
 */
public class Teacher {
    private int id;
    private String name;
    private String gender;
    private double salary;
    private boolean isOrIsNotPoliticalPartyMember;
    private String birthday;

    public Teacher(String name, String gender, double salary, boolean isOrIsNotPoliticalPartyMember, String birthday) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.isOrIsNotPoliticalPartyMember = isOrIsNotPoliticalPartyMember;
        this.birthday = birthday;
    }

    public Teacher(int id, String name, String gender, double salary, boolean isOrIsNotPoliticalPartyMember, String birthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.isOrIsNotPoliticalPartyMember = isOrIsNotPoliticalPartyMember;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", isOrIsNotPoliticalPartyMember=" + isOrIsNotPoliticalPartyMember +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isOrIsNotPoliticalPartyMember() {
        return isOrIsNotPoliticalPartyMember;
    }

    public void setOrIsNotPoliticalPartyMember(boolean orIsNotPoliticalPartyMember) {
        isOrIsNotPoliticalPartyMember = orIsNotPoliticalPartyMember;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
