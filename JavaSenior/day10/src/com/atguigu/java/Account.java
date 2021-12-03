package com.atguigu.java;

import java.io.Serializable;

/**
 * @author KeyboardHero
 * @create 2021-12-02 16:55
 */
public class Account implements Serializable {
    public static final long serialVersionUID=-486466589L;
    private double balance;

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
