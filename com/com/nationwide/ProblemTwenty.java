package com.nationwide;

import java.math.BigInteger;

public class ProblemTwenty implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        int sum = 0;
        BigInteger bigNum;
        bigNum = Util.factorial(100);
        String numbers = bigNum.toString();

        for( int i = 0; i < numbers.length(); i++){
            sum += Integer.parseInt(numbers.substring(i, i+1));
        }

        value = sum;
    }
}
