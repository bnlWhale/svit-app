package com.svit.java.l5.threadlambda;

import java.util.*;

public class BankSyn implements IBank {

    private final double[] accounts;

    /**
     * Constructs the bank.
     * @param n the number of accounts
     * @param initialBalance the initial balance for each account
     */
    public BankSyn(int n, double initialBalance)
    {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Transfers money from one account to another.
     * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     */
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException
    {
        while (accounts[from] < amount){
            System.out.println("Bank transfer:"+ amount+" wait:"+Thread.currentThread());
            wait();
        }

        System.out.print("Bank transfer:"+Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    /**
     * Gets the sum of all account balances.
     * @return the total balance
     */
    public synchronized double getTotalBalance()
    {
        double sum = 0;

        for (double a : accounts)
            sum += a;

        return sum;
    }

    /**
     * Gets the number of accounts in the bank.
     * @return the number of accounts
     */
    public int size()
    {
        return accounts.length;
    }

}
