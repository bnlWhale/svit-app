package com.svit.java.l5.threadlambda;

public class ThreadAdding {

    static class AddingProcess{

       private int addingNum = 0;
       private final int MaxAdding = 10;

        public synchronized void adding() throws InterruptedException{

              if(addingNum > MaxAdding){

                   throw new InterruptedException("ReachMax");
               }
               addingNum++;
               System.out.println("adding "+addingNum+"  "+Thread.currentThread());
               //wait();
               //notify();

        }

        public  boolean isReach() throws InterruptedException{
            if(addingNum >= MaxAdding){
                throw new InterruptedException("Reach");
            }
            return addingNum >= MaxAdding;
        }

        public void showNumber(){
            System.out.println("value is:"+addingNum+" "+Thread.currentThread());
        }

    }





    public static void main(String[] args){

        AddingProcess ap = new AddingProcess();
        Runnable task=()->{

            if(!Thread.currentThread().isInterrupted()){
                try{
                    while (!ap.isReach()) {
                        ap.adding();
                        Thread.sleep(1);
                    }
                } catch (InterruptedException e){
                    ap.showNumber();
                    Thread.currentThread().interrupt();
                }

            }

        };

         Thread t1 = new Thread(task);
         Thread t2 = new Thread(task);
         t1.start();
         t2.start();


    }


}
