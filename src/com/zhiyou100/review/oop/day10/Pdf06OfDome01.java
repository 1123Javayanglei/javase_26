package com.zhiyou100.review.oop.day10;

/**
 * @packageName: javase_26
 * @className: Pdf06OfDome01
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/2/14 6:22 下午
 */
public class Pdf06OfDome01 {
    public static void main(String[] args) {
        String name = "123456";
        System.out.println(name.length());
    }
}

class Account {
    /**
     * id 账户id
     * balance 账户余额
     */
    private long id;
    private double balance;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Account(long id, String password) {
        this.id = id;
        this.password = password;
    }

    public Account() {
    }

    public Account(long id, double balance, String password) {
        this.id = id;
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

    public SavingAccount(long id, double balance, String password) {
        super(id, balance, password);
    }

    public SavingAccount(long id, String password, double interestRate) {
        super(id, password);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public SavingAccount() {

    }

    public SavingAccount(double interestRate) {
        this.interestRate = interestRate;
    }


    public SavingAccount(long id, double balance, String password, double interestRate) {
        super(id, balance, password);
        this.interestRate = interestRate;
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

    public CreditAccount(long id, double balance, String password) {
        super(id, balance, password);
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }

    public CreditAccount() {
    }

    public CreditAccount(double creditLine) {
        this.creditLine = creditLine;
    }

    public CreditAccount(long id, double balance, String password, double creditLine) {
        super(id, balance, password);
        this.creditLine = creditLine;
    }
}

class Bank {
    /**
     * 如果一个类没有使用到实例成员，最好定义为static静态的
     * @param id
     * @param password
     * @param type
     * @return
     */
   static Account openAccount(long id, String password, int type) {
        if (type == 0) {
            return new Account(id, 0, password);
        }
        if (type == 1) {
            return new SavingAccount(id, 0, password);
        }
        if (type == 2) {
            return new CreditAccount(id, 0, password);
        }
        return null;
    }

   static double deposit(Account a, double amount) {
        a.setBalance(amount);
        return a.getBalance();
    }

   static double withdraw(Account a, double amount) {
        /**
         * 不考虑类型
         */
        if (a.getBalance() <= 0) {
            return a.getBalance();
        } else {
            a.setBalance(a.getBalance() - amount);
            return a.getBalance();
        }
    }
}