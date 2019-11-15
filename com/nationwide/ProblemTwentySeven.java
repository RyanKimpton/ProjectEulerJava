package com.nationwide;

import java.util.Collections;
import java.util.List;

public class ProblemTwentySeven implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        List<Integer> primes = Util.primeSieve(110000);
        int longest = 0;
        int aMax = 0;
        int bMax = 0;

        for( int a = -999; a < 1001; a += 2){
            // a must be odd


            for( int b = -999; b < 1001; b+=2){
                if(Collections.binarySearch(primes, b) > 0){
                    //b is prime
                    int n = 0;
                    int currentLength = 0;
                    int primeFlag = 0;
                    while(primeFlag == 0){
                        int currentNum = (n*n) + (a * n) + b;
                        if(Collections.binarySearch(primes, currentNum) > 0){
                            n++;
                            currentLength++;
                            if(longest < currentLength){
                                longest = currentLength;
                                aMax = a;
                                bMax = b;
                            }
                        } else {
                            primeFlag = 1;
                        }
                    }
                }
            }
            value = aMax * bMax;
        }
    }
}
