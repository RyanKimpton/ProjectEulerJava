package com.nationwide;

import java.util.List;

public class ProblemThree implements Runnable {

    private int value;

    public int getValue() {
        return value;
    }


    public void run() {
        double number = 600851475143L;
        List<Integer> primes = Util.primeFactors(number);

        value = primes.get(primes.size()-1);
    }

}
