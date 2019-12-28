package com.nationwide;

import java.math.BigInteger;

public class ProblemSixteen implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        int sum = 0;
        BigInteger bigNum = new BigInteger("2").pow(1000);
        String numbers = bigNum.toString();

        for( int i = 0; i < numbers.length(); i++){
            sum += Integer.parseInt(numbers.substring(i, i+1));
        }

        value = sum;
    }
}
