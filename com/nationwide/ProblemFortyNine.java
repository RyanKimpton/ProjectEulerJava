package com.nationwide;

import java.util.*;

public class ProblemFortyNine implements Runnable {
    private String value;

    public String getValue() {
        return value;
    }

    public void run() {
        int[] primes = new int[1061];
        int index = 0;

        List<Integer> allPrimes = Util.primeSieve(10000);

        Set<Integer> primeCheckSet = new HashSet<>(allPrimes);

        for( int i = 1000; i < 10000; i++){
            if(primeCheckSet.contains(i) && primeCheckSet.contains(i+3330) && primeCheckSet.contains(i+6660)){
                String temp1 = "" + (i + 3330);
                String temp2 = "" + (i + 6660);
                String temp3 = "" + i;

                char[] check1 = temp3.toCharArray();
                char[] check2 = temp2.toCharArray();
                char[] check3 = temp1.toCharArray();

                Arrays.sort(check1);
                Arrays.sort(check2);
                Arrays.sort(check3);


                if(Arrays.equals(check1, check2)){
                    if(Arrays.equals(check2, check3)){
                        value = temp3 + temp1 + temp2;
                    }
                }
            }
        }


    }

}