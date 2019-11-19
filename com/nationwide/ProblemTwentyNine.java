package com.nationwide;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProblemTwentyNine implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        List<BigInteger> powers = new ArrayList<>();

        for( int a = 2; a < 101; a++){
            for( int b = 2; b < 101; b++){
                BigInteger currentPow = BigInteger.valueOf(a);
                BigInteger pow = currentPow.pow(b);
                int index = Collections.binarySearch(powers, pow);
                if(index < 0){
                    powers.add(-index - 1, pow);
                }
            }
        }
        value = powers.size();
    }
}
