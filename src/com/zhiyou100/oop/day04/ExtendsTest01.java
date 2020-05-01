package com.zhiyou100.oop.day04;

/**
 * @author yanglei
 * 作业二：
 * 某公司的雇员分为以下若干类：
 * Employee：这是所有员工总的父类，属性：员工的姓名,员工的生日月份。方法：getSalary(int month) 根据参数月份来确定工资，如果该月员工过生日，则公司会额外奖励100元。
 * SalariedEmployee：Employee的子类，拿固定工资的员工。属性：月薪
 * HourlyEmployee：Employee的子类，按小时拿工资的员工，每月工作超出160小时的部分按照1.5倍工资发放。属性：每小时的工资、每月工作的小时数
 * SalesEmployee：Employee的子类，销售人员，工资由月销售额和提成率决定。属性：月销售额、提成率
 * BasePlusSalesEmployee：SalesEmployee的子类，有固定底薪的销售人员，工资由底薪加上销售提成部分。属性：底薪。
 */
public class ExtendsTest01 {
    public static void main(String[] args) {

    }
}

class Employee {
    /**
     * 创建Employee(员工)类
     * 其信息不完整，没有创建对象的必要、
     * 存在的意义是 给子类定义共同的成员变量和成员方法
     */
    String name;
    int birthMonth;

    public double getSalary(int month) {
        if (month == birthMonth) {
            return 100;
        } else {
            return 0;
        }
    }
}

class SalariedEmployee extends Employee {
    /**
     * SalariedEmployee：Employee的子类，拿固定工资的员工。属性：月薪
     */
    double salary;

    @Override
    public double getSalary(int month) {
        if (birthMonth == month) {
            return salary += 100;
        } else {
            return salary;
        }
    }
}

class HourlyEmployee extends Employee {
    /**
     * HourlyEmployee：Employee的子类，按小时拿工资的员工，每月工作超出160小时的部分按照1.5倍工资发放。属性：每小时的工资、每月工作的小时数
     */
    double salaryOfHour;
    double workingHoursOfMonth;

    @Override
    public double getSalary(int month) {
        double salary = 0;
        if (birthMonth == month) {
            salary += 100;
        } else {
            salary += 0;
        }
        double maxHoursOfMonth = 160;
        if (workingHoursOfMonth >= maxHoursOfMonth) {
            /*
             * 若每月工作时长  > 160 ，工资 =(没超过160部分的工资+超过160部分的工资)
             * 否则 工资 = 没超过160的工资
             *
             * 没超过160部分的工资 = 160 * 时薪
             * 超过160部分的工资 = (总工作时间-160) * 时薪*1.5
             */
            salary += ((workingHoursOfMonth - 160) * (salaryOfHour * 1.5));
            salary += maxHoursOfMonth * salaryOfHour;
        } else {
            salary += workingHoursOfMonth * salaryOfHour;
        }
        return salary;
    }
}

class SalesEmployee extends Employee {
    /**
     * SalesEmployee：Employee的子类，销售人员，工资由月销售额和提成率决定。属性：月销售额、提成率
     */
    double monthlySales;
    double royaltyRate;

    @Override
    public double getSalary(int month) {
        double salary = 0;
        if (birthMonth == month) {
            salary += 100;
        } else {
            salary += 0;
        }
        salary += monthlySales * royaltyRate;
        return salary;
    }
}

class BasePlusSalesEmployee extends Employee {
    /**
     * //BasePlusSalesEmployee：SalesEmployee的子类，有固定底薪的销售人员，工资由底薪加上销售提成部分。属性：底薪。
     */
    double basicSalary;
    double monthlySales;
    double royaltyRate;

    @Override
    public double getSalary(int month) {
        double salary = 0;
        if (birthMonth == month) {
            salary += 100;
        } else {
            salary += 0;
        }
        salary += (monthlySales * royaltyRate) + basicSalary;
        return salary;
    }
}