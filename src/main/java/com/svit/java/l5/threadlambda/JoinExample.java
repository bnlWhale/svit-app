package com.svit.java.l5.threadlambda;

public class JoinExample {






    public static void main(String[] args){


        int MaxStep = 4;
        Runnable task=()->{
            try{
                for(int i=0;i<MaxStep;i++){
                    System.out.println("sub task in Main excute "+i+"  then sleep 1 second");
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){

            }

        };


        Thread t1 = new Thread(task,"t1");
        t1.start();
        /*try{ // the Main will wait for t1's finish
            t1.join();
        }catch (InterruptedException e){
        }*/
        try{
            for(int i=0;i<MaxStep;i++){
                System.out.println("Main task  excute "+i+"  then sleep 1 second");
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){

        }


    }

}
