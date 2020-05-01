package com.zhiyou100.oop.day08;

/**
 * @name: DemoPolymorphism02
 * @description: TODO 计算工资
 * @return:
 * @date: 2020/2/12 11:53 上午
 * @author: YangLei
 */
public class DemoPolymorphism02 {
    public static void main(String[] args) {
        // TODO 给一个有普通收入、工资收入和享受国务院特殊津贴的小伙伴算税:
        Income[] income = new Income[]{
                new Income(3000),
                new SalaryIncome(7500),
                new StateCouncilSpecialAllowance(15000)
        };
        System.out.println(totalTax(income));
        // TODO 给一个有工资收入和稿费收入的小伙伴算税
        Income[] incomes = new Income[]{
                new SalaryIncome(10000),
                new RoyaltyIncome(3000),
        };
        System.out.println(totalTax(incomes));

        Income stringTest=new StringText(100);
        System.out.println(stringTest.getTax());
        System.out.println(stringTest.sb);

    }

    public static double totalTax(Income[] incomes) {
        /**
         * @name: totalTax
         * @description: TODO  对所有人进行报税
         * @param incomes
         * @return: double
         * @date: 2020/2/12 11:59 上午
         * @author: YangLei
         *
         */
        double totalTas = 0;
        for (Income income :
                incomes) {
            totalTas += income.getTax();
        }

        return totalTas;
        /*
        观察totalTax()方法：利用多态，totalTax()方法只需要和Income打交道，
        它完全不需要知道Salary和StateCouncilSpecialAllowance的存在，
        就可以正确计算出总的税。
        如果我们要新增一种稿费收入，只需要从Income派生，然后正确覆写getTax()方法就可以。
        把新的类型传入totalTax()，不需要修改任何代码。
         */
    }
}

class Income {
    /**
     * @name: Income
     * @description: TODO   默认税率10%
     * @return:
     * @date: 2020/2/12 11:54 上午
     * @author: YangLei
     */
    protected double income;
    String sb="你是个一个sb";

    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1;
        // 税率10%
    }
}

class SalaryIncome extends Income {
    /**
     * @name: SalaryIncome
     * @description: TODO  工资收入小于的5000的部分无税，大于5000的20%
     * @return: double
     * @date: 2020/2/12 11:55 上午
     * @author: YangLei
     */
    public SalaryIncome(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income < 5000) {
            return 0;
        } else {
            return (income - 5000) * 0.2;
        }
    }
}

class StateCouncilSpecialAllowance extends Income {
    /**
     * @param null
     * @name: StateCouncilSpecialAllowance
     * @description: TODO   若享受国务院津贴，免税
     * @return:
     * @date: 2020/2/12 11:58 上午
     * @author: YangLei
     */
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}

class RoyaltyIncome extends Income {
    /**
     * @param income
     * @name: RoyaltyIncome
     * @description: TODO  稿费收入是20%
     * @return:
     * @date: 2020/2/12 12:11 下午
     * @author: YangLei
     */
    public RoyaltyIncome(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return income * 0.2;
    }
}
class StringText extends Income{
    String a="你是250";
    public StringText(double income) {
        super(income);
    }
    @Override
    public double getTax() {
        System.out.println(a);
        return super.getTax();
    }
}