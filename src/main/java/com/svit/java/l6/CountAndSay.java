package com.svit.java.l6;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, 1 is read off as “one 1 for 11. 11 is read off as
 * “two 1s for 21. 21 is read off as “one 2, then one 1 for 1211. Given an
 * integer, generate the the sequence. Note: The sequence of integers will be
 * represented as a string.
 * 
 * @author sv-it
 */
public class CountAndSay{
    public static void main(String[] args){
        for (int i=1; i<=10; i++){
            System.out.println("Count and Say-for "+ i + " : "+ countAndSay(i));
        }
    }
    /**
     * 
     * @param n
     * @return count and say number string as required
     */
    private static String countAndSay(int n) {
        String cur = "1";
        for(int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char lastDigit = cur.charAt(0);
            int count = 1;
            for(int j = 1; j < cur.length(); j++) {
                if (cur.charAt(j) == lastDigit) {
                    count ++;
                }  else  {
                    sb.append(count);
                    sb.append(lastDigit);
                    lastDigit = cur.charAt(j);
                    count = 1;
                }               
            }
            sb.append(count);
            sb.append(lastDigit);              
            cur = sb.toString();
        }
        return cur;
    }
}


