package com.nationwide;

import java.math.BigInteger;
import java.util.ArrayList;

public class ProblemTwentyThree implements Runnable {
    private long value;

    public long getValue() {
        return value;
    }

    public void run() {

        int[] abundant = new int[6963];
        int[] numbers = new int[28123];

        for(int i = 0; i < 28123; i++){
            numbers[i] = i;
        }

        int sumOfFactors;
        int index = 0;
        int temp;

        for( int i = 12; i < 28112; i++){
            sumOfFactors = 0;

            for( int j = 1; j < Util.factors(i).size(); j++){
                sumOfFactors += Util.factors(i).get(j);
            }

            if(sumOfFactors > i){
                if(Math.sqrt(i) % 1 == 0){
                    sumOfFactors -= Math.sqrt(i);

                    if(sumOfFactors > i){
                        abundant[index] = i;
                        index++;
                    }

                } else {
                    abundant[index] = i;
                    index++;
                }
            }
        }

        for(int i = 0; i < 6963; i++){
            for( int j = i; j < 6963; j++){
                temp = abundant[i] + abundant[j];


                if(temp < 28123){
                    numbers[temp] = 0;
                } else {
                    j++;
                }
            }
        }



        for(int i = 0; i < 28123; i++){
            value += numbers[i];
        }

    }
}
