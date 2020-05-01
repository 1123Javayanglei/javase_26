package com.zhiyou100.oop.day05;

/**
 * @author yanglei
 * @date 2020/2/7 3:58 下午
 */
public class Demo04Super {
    public static void main(String[] args) {
        BasePlusSalesEmployee basePlusSalesEmployee = new  BasePlusSalesEmployee("杨磊",11,10,0.1,100);
        System.out.println(basePlusSalesEmployee.getSalary(11));

    }
}

class Employee {
    /**
     * 创建Employee(员工类)
     * 私有化 名字 name,生日 birthMonth
     * 提供 get,set 方法，判断数据有效性
     * 提供了 有参和无参数的构造方法
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
        if (birthMonth > 0 && birthMonth <= 12) {
            this.birthMonth = birthMonth;
        } else {
            System.out.println("月份不合法");
        }

    }

    Employee() {

    }

    Employee(String name, int birthMonth) {
        this.name = name;
        this.birthMonth = birthMonth;
    }

    public double getSalary(int month) {
        if (month == getBirthMonth()) {
            return 100;
        } else {
            return 0;
        }
    }

}

class SalariedEmployee extends Employee {
    /**
     * SalariedEmployee：Employee的子，拿固定工资的员工。属性：月薪
     */
    private double salary = 0;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    SalariedEmployee() {
        super();
    }

    SalariedEmployee(double salary, String name, int birthMonth) {
        super(name,birthMonth);
        this.salary = salary;
    }

    @Override
    public double getSalary(int month) {
        return salary += super.getSalary(month);
    }
}

class HourlyEmployee extends Employee {
    /**
     * HourlyEmployee：Employee的子类，按小时拿工资的员工，每月工作超出160小时的部分按照1.5倍工资发放。
     * 属性：每小时的工资(salaryOfHour)、每月工作的小时数(workingHoursOfMonth)
     */
    private double salaryOfHour;
    private double workingHoursOfMonth;

    public double getSalaryOfHour() {
        return salaryOfHour;
    }

    public void setSalaryOfHour(double salaryOfHour) {
        this.salaryOfHour = salaryOfHour;
    }

    public double getWorkingHoursOfMonth() {
        return workingHoursOfMonth;
    }

    public void setWorkingHoursOfMonth(double workingHoursOfMonth) {
        if (workingHoursOfMonth > 0) {
            this.workingHoursOfMonth = workingHoursOfMonth;
        }
    }

    HourlyEmployee() {
        super();
    }

    HourlyEmployee(String name, int birthMonth, double salaryOfHour, double workingHoursOfMonth) {
        super(name, birthMonth);
        this.setSalaryOfHour(salaryOfHour);
        this.setWorkingHoursOfMonth(workingHoursOfMonth);
    }

    @Override
    public double getSalary(int month) {
        double salary = 0;
        salary += super.getSalary(month);
        double maxHoursOfMonth = 160;
        if (getWorkingHoursOfMonth() >= maxHoursOfMonth) {
            /*
             * 若每月工作时长  > 160 ，工资 =(没超过160部分的工资+超过160部分的工资)
             * 否则 工资 = 没超过160的工资
             *
             * 没超过160部分的工资 = 160 * 时薪
             * 超过160部分的工资 = (总工作时间-160) * 时薪*1.5
             */
            salary += (getWorkingHoursOfMonth() - 160) * (getSalaryOfHour() * 1.5);
            salary += maxHoursOfMonth * getSalaryOfHour();
        } else {
            salary += getWorkingHoursOfMonth() * getSalaryOfHour();
        }
        return salary;
    }
}

class SalesEmployee extends Employee {
    /**
     * SalesEmployee：Employee的子类，销售人员，工资由月销售额和提成率决定。
     * 属性：月销售额 monthlySales 、提成率 royaltyRate
     */
    private double monthlySales;
    private double royaltyRate;

    public double getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(double monthlySales) {
        if (monthlySales >= 0) {
            this.monthlySales = monthlySales;
        } else {
            System.out.println("月销售额不能小于0");
        }
    }

    public double getRoyaltyRate() {
        return royaltyRate;
    }

    public void setRoyaltyRate(double royaltyRate) {
        if (royaltyRate >= 0) {
            this.royaltyRate = royaltyRate;
        } else {
            System.out.println("提成率不能小于0");
        }
    }

    SalesEmployee() {
        super();
    }

    SalesEmployee(String name, int birthMonth, double monthlySales, double royaltyRate) {
        super(name, birthMonth);
        this.setMonthlySales(monthlySales);
        this.setRoyaltyRate(royaltyRate);
    }

    @Override
    public double getSalary(int month) {
        double salary = 0;
        salary += super.getSalary(month);
        salary += getMonthlySales() * getRoyaltyRate();
        return salary;
    }
}

class BasePlusSalesEmployee extends SalesEmployee {
    /**
     * BasePlusSalesEmployee：SalesEmployee的子类，有固定底薪的销售人员，工资由底薪加上销售提成部分。
     * 属性：底薪 basicSalary  每小时的工资(salaryOfHour)、每月工作的小时数(workingHoursOfMonth)
     */
    private double basicSalary;

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary >= 0) {
            this.basicSalary = basicSalary;
        } else {
            System.out.println("底薪不能小于零");
        }
    }

    BasePlusSalesEmployee() {
        super();
    }

    BasePlusSalesEmployee(String name, int birthMonth, double monthlySales, double royaltyRate, double basicSalary) {
        super(name, birthMonth, monthlySales, royaltyRate);
        this.setBasicSalary(basicSalary);
    }

    @Override
    public double getSalary(int month) {
        return getBasicSalary() + super.getSalary(month);
    }
}
