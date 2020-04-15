package com.zhiyou100.basicclass.day32.xmlanalysis.homework;

import com.zhiyou100.basicclass.day02.HomeWorkOfMath;

import java.util.ArrayList;

/**
 * @packageName: javase_26
 * @className: XmlHomeWorkForTeacher
 * @Description: TODO 用于xml作业的 老师类
 * @author: YangLei
 * @date: 2020/4/15 7:17 下午
 */
public class XmlHomeWorkForTeacher {
    /**
     * 属性 姓名、id、工资、性别
     */
    private String name;
    private String id;
    private double salary;
    private String gender;

    public XmlHomeWorkForTeacher(String name, String id, double salary, String gender) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.gender = gender;
    }

    public XmlHomeWorkForTeacher() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public ArrayList<XmlHomeWorkForTeacher> getArrayList(){
        ArrayList<XmlHomeWorkForTeacher> xmlHomeWorkForTeachers = new ArrayList<>();
        // 创建一个集合放置
        int max=10;
        for (int i = 0; i < max; i++) {
            // 生成10个老师对象
            String id=String.valueOf(HomeWorkOfMath.randomOfMinToMax(1,5000));
            // 随机 0-50的id
            String name=("杨"+ HomeWorkOfMath.randomOfMinToMax(1,500)+"磊");
            // 随机姓名
            double salary=HomeWorkOfMath.randomOfMinToMax(1000,3000);
            // 随机 1000-3000的工资
            int genderTemp=HomeWorkOfMath.randomOfMinToMax(0,1);
            String gender=(genderTemp==0?"男":"女");
            // 随机性别
            XmlHomeWorkForTeacher xmlHomeWorkForTeacher = new XmlHomeWorkForTeacher(name, id, salary, gender);
            // 创建老师对象
            xmlHomeWorkForTeachers.add(xmlHomeWorkForTeacher);
            // 把老师对象放入集合
        }
        return xmlHomeWorkForTeachers;
    }

    public void printTeacher(ArrayList<XmlHomeWorkForTeacher> arrayList) {
        // TODO 打印方法
        for (XmlHomeWorkForTeacher x :
                arrayList) {
            System.out.println(x.getId()+" "+x.getName()+" "+x.getSalary()+" "+x.getGender());
        }
    }
}
