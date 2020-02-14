package com.zhiyou100.review.oop.day10;

/**
 * @packageName: javase_26
 * @className: Pdf06OfDome03
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/14 7:38 下午
 */
public class Pdf06OfDome03 {
    public static void main(String[] args) {
        Employee[] employee=new Employee[4];
        employee[0]=new SalariedEmployee("杨磊",11,2000);
        employee[1]=new HourlyEmployee("杨磊",11,15.5,60);
        employee[2]=new SalesEmployee("杨磊",11,2000,0.01);
        employee[3]=new BasePlusSalesEmployee("杨磊",11,2000,0.01,2000);
        for (Employee value :
                employee) {
            System.out.println(value.getSalary(11));
        }
    }



}
 class Employee{
    /**
     * @name: Employee
     * @param: 当前月份
     * @description: TODO  所有员工的父类，属性有名字，生日的月份，方法是若员工本月过生日，奖励100
     * @date: 2020/2/14 7:44 下午
     * @return:
    */
    private String name;
    private int birthMonth;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getBirthMonth() {
         return birthMonth;
     }

     public void setBirthMonth(int birthMonth) {
         this.birthMonth = birthMonth;
     }

     public Employee(String name, int birthMonth) {
         this.name = name;
         this.birthMonth = birthMonth;
     }

     public Employee() {
     }

     double getSalary(int month){
        if (month==birthMonth){
            return 100;
        }else {
            return 0;
        }
    }
}
class SalariedEmployee extends Employee{
    /**
     * @name: SalariedEmployee
     * @param:
     * @description: TODO  拿固定工资的子类，属性月薪
     * @date: 2020/2/14 7:46 下午
     * @return:
    */
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public SalariedEmployee(String name, int birthMonth, double salary) {
        super(name, birthMonth);
        this.salary = salary;
    }

    @Override
    double getSalary(int month) {
        return super.getSalary(month)+ getSalary();
    }
}
class HourlyEmployee extends Employee{
    /**
     * @name: HourlyEmployee
     * @param:  每小时个工资、每月的工作总时间
     * @description: TODO
     * @date: 2020/2/14 7:48 下午
     * @return:
    */
    private double hourlySalary;
    private int  hours;

    public HourlyEmployee(String name, int birthMonth, double hourlySalary, int hours) {
        super(name, birthMonth);
        this.hourlySalary = hourlySalary;
        this.hours = hours;
    }

    public HourlyEmployee(String name, int birthMonth, double hourlySalary) {
        super(name, birthMonth);
        this.hourlySalary = hourlySalary;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = (int) hours;
    }

    @Override
    double getSalary(int month) {
        /**
         * 月工作时间超过160小时的部分 1.5倍工资
         */
        double salary=0;
        int maxHoursOfMonth=160;
        if (getHours()>=maxHoursOfMonth){
            salary+=(getHours()-160)* getHourlySalary()*1.5;
        }
        salary+= getHours()* getHourlySalary();
        return salary+super.getSalary(month);
    }
}
class SalesEmployee extends Employee{
    /**
     * @name: SalesEmployee
     * @param: 月销售额 提成率 当前月份
     * @description: TODO  销售人员工资 = 销售额 * 提成率
     * @date: 2020/2/14 7:54 下午
     * @return:
    */
    private double sales;
    private double rate;

    public SalesEmployee(String name, int birthMonth, double sales, double rate) {
        super(name, birthMonth);
        this.sales = sales;
        this.rate = rate;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    double getSalary(int month) {
        return super.getSalary(month)+ getRate()* getSales();
    }
}
class BasePlusSalesEmployee extends SalesEmployee{
    /**
     * @name: BasePlusSalesEmployee
     * @param:        同上
     * @description: TODO  有底薪的销售人员
     * @date: 2020/2/14 7:59 下午
     * @return:
    */
    private double baseSalary;

    public BasePlusSalesEmployee(String name, int birthMonth, double contOfMonthSalary, double commissions, double baseSalary) {
        super(name, birthMonth, contOfMonthSalary, commissions);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    double getSalary(int month) {
        return super.getSalary(month)+getBaseSalary();
    }
}
