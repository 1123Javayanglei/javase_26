package com.zhiyou100.oop.day10;

/**
 * @packageName: javase_26
 * @className: Pdf06OfDome01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/14 6:22 下午
 */
public class Pdf06OfDome01 {
    public static void main(String[] args) {
        Account a1 = new Account();

        Account a2 = new Account();

        System.out.println(a1.getId());
        //输出 100001

        System.out.println(a2.getId());
        //输 100002
    }
}

class Account {
    /**
     * id 账户id
     * balance 账户余额
     */
    final long id = 100000;
    static long idCunt = 1;

    public long getId() {

        return id + idCunt++;
    }

    private double balance;
    private String password;

    public Account() {

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        /**
         * 修改getPassword 方法，要求每次都返回null 值。
         */
        return null;
    }

    public void setPassword(String password) {
        /**
         * 修改setPassword 方法，要求：
         *
         * setPassword 判断新密码长度是否是6 位，如果不是则不予修改；
         */
        if (password.length() == 0) {
            this.password = password;
        }
    }

    public Account(double balance, String password) {
        this.balance = balance;
        this.password = password;
    }
}

class SavingAccount extends Account {

    /**
     * SavingAccount 储蓄账户
     * interestRate 存款利率
     */
    private double interestRate;


    public SavingAccount(long id, String password, double interestRate) {
        super(id, password);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }


    public void setInterestRate(double interestRate) {
        /**
         * set要求利率大于0并且小于 10%
         */
        if (interestRate > 0 && interestRate < 0.1) {
            this.interestRate = interestRate;
        }
    }
}

class CreditAccount extends Account {
    /**
     * CreditAccount 信用账户
     * creditLine 信用额度
     */
    private double creditLine;

    public CreditAccount(long id, String password, double creditLine) {
        super(id, password);
        this.creditLine = creditLine;
    }


    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }


}

class Bank {
    /**
     * 如果一个类没有使用到实例成员，最好定义为static静态的
     *
     * @param id
     * @param password
     * @param type
     * @return
     */
//   static Account openAccount(long id, String password, int type) {
//        if (type == 0) {
//            return new Account(id, 0, password);
//        }
//        if (type == 1) {
//            return new SavingAccount(id, 0, password);
//        }
//        if (type == 2) {
//            return new CreditAccount(id, 0, password);
//        }
//        return null;
//    }
    static double deposit(Account a, double amount) {
        a.setBalance(amount);
        return a.getBalance();
    }

    static double withdraw(Account a, double amount) {
        if (a instanceof CreditAccount) {
            double max = a.getBalance();
            CreditAccount creditAccount = (CreditAccount) a;
            if (max + creditAccount.getCreditLine() >= amount) {
                creditAccount.setCreditLine(amount - creditAccount.getCreditLine());
                return creditAccount.getCreditLine() + max - amount;
            }
        }
        if (a.getBalance() >= amount) {
            a.setBalance(a.getBalance() - amount);
            return a.getBalance();
        }
        return 0;
    }
}