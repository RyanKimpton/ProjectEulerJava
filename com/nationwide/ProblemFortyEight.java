package com.nationwide;

import java.math.BigInteger;

public class ProblemFortyEight implements Runnable {
    private BigInteger value;

    public BigInteger getValue() {
        return value;
    }

    public void run() {
        BigInteger sum = new BigInteger("0");
        BigInteger modulus = new BigInteger("10000000000");

        for(int i = 1; i < 1001; i++){
            BigInteger pow = new BigInteger(String.valueOf(i));
            sum = sum.add(pow.modPow(BigInteger.valueOf(i), modulus));
        }

        value = sum;
    }
}