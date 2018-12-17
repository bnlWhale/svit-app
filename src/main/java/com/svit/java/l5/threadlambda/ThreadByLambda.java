package com.svit.java.l5.threadlambda;

public class ThreadByLambda {

    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;


    public static void main(String[] args)
    {

        IBank bank = new BankSyn(4, 100);
        Runnable task1 = () ->
        {
            try
            {
                for (int i = 0; i < STEPS; i++)
                {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                    System.out.println("Sleep:"+Thread.currentThread());
                }
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException "+e+" "+Thread.currentThread());
            }
        };

        Runnable task2 = () ->
        {
            try
            {
                for (int i = 0; i < STEPS; i++)
                {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                    System.out.println("Sleep:"+Thread.currentThread());
                }
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException "+e+" "+Thread.currentThread());
            }
        };



        Thread t1;
        t1 = new Thread(task1);
        t1.start();

        Thread t2;
        t2 = new Thread(task2);
        t2.start();

        Runnable task3 = () ->
        {
            try
            {
                Thread.sleep(3000);
                System.out.println("t1 isInterrupted:"+t1.isInterrupted()+"  "+t1.getState());
                t1.interrupt();
                System.out.println("t1 isInterrupted:"+t1.isInterrupted()+"  "+t1.getState());
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException "+e);
            }
        };

        Thread t3;
        t3 = new Thread(task3);
        t3.start();
    }

}
