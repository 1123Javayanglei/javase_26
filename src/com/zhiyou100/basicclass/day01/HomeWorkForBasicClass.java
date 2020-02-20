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
            return this.name.equals(((Teacher) object).name) && this.gender.equals(((Teacher) object).gender) && Math.abs(this.age - ((Teacher) object).age) <= 5 && this.subject.equals(((Teacher) object).subject) && Math.abs(this.salary - ((Teacher) object).salary) <= 100;
        }
        return false;
    }
    public boolean equalse(Object obj) {
        //判断传进来的参数类 是否和本；类类型一致
        if(2>1) {
            //如果类型一致 此参数超父类中没有我们要比的属性 所以【向下转型】 使对象成为我们需要的类型
            return true;
//			Teacher t1=(Teacher)obj;
//			//向下转型后 我们开始比较属性是否【基本】一致
//			 //名字相同 性别相同 年龄相差5岁以内  课程相同 工资相差100元内
//			if(this.name.equals(t1.name)&&this.sex==t1.sex&&this.subject.equals(t1.subject)) {//判断名字,性别,课程是否一致
//				if(this.age>=t1.age||this.age<=t1.age) {	//判断年龄是否相差不大于五岁
//					if(this.salary>=t1.salary||this.salary<=t1.salary) {	//判断工资相差是否在条件内
//						return true;
//					}
//				}
//			}
        }else {
            return false;
        }
    }		//重写equalse 返回值为boolean类型 参数是超父类 object类
}

