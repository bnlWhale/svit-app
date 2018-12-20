package com.svit.java.l7;



/*



  1  2  3  4
  5  6  7  8
  9 10 11 12
  13 14 15 16

  [1], [2, 5], [3, 6, 9] [4, 7, 10, 13] ...


*/


public class Algo_MatrixDiagonal_print {

    public static  void main(String[] args){




        int dockNum = 4;
        for(int i=0;i<dockNum;i++){
            System.out.println("*** ");
            for(int j=0;j<dockNum;j++){

               if(j<=i){
                   System.out.print(i+j+" ");
               }

            }
            System.out.println("\n");

        }


    }


}
