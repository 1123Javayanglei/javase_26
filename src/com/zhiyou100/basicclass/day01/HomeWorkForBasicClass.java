package com.zhiyou100.basicclass.day01;

/**
 * @packageName: javase_26
 * @className: HomeWorkForBasicClass
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/20 12:09 下午
 */
public class HomeWorkForBasicClass {
    public static void main(String[] args) {

    }
}

class Teacher {
    private String name;
    private int age;
    private double salary;
    private String gender;
    private String subject;

    public Teacher() {
    }

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher(String name, int age, double salary, String gender, String subject) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.subject = subject;
    }

    @Override
    public String toString() {
        /**
         * @name: toString
         * @param:
         * @description: TODO 输出
         * @date: 2020/2/20 12:22 下午
         * @return:
         */
        return "老师：我叫" + name + ",今年" + age + "岁，月薪" + salary + "元，性别" + gender + ",所学课程为" + subject;
    }

    @Override
    public boolean equals(Object object) {
        /**
         * @name: equals
         * @param: Object object
         * @description: TODO  姓名相同，性别相同，年龄差5岁以内，课程相同，工资相差100元之内,返回true，否则false
         * @date: 2020/2/20 12:18 下午
         * @return: boolean
         */
        if (object instanceof Teacher) {
            Teacher teacher = (Teacher) object;
            boolean flag= (this.name.equals(teacher.name))&& (this.gender.equals(teacher.gender)) && (Math.abs(this.age - teacher.age) <= 5) && (this.subject.equals(teacher.subject)) && (Math.abs(this.salary - teacher.salary) <= 100);
            // Mark一下
            return MyEquaUtil.compareString(this.name,teacher.name);
        }
        return false;
    }

}
class MyEquaUtil{
    public static boolean compareString(String string1,String string2){
        if (string1==null&&string2==null){
            return true;
        }
        if (string1.equals(string2)){
            return true;
        }else {
            return false;
        }
    }
    public static boolean compareNumber(int a,int b,int c){
        /**
         * 判断 a-b是否小于等于c
         */
        return Math.abs(a-b)<=c;
    }
}

