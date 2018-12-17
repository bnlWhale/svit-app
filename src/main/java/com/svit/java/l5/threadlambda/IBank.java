package com.svit.java.l5.threadlambda;

public interface IBank {

    public void transfer(int from, int to, double amount) throws InterruptedException;
    public double getTotalBalance();
}
