package com.nationwide;

import java.util.List;

public class ProblemTen implements Runnable  {
    private long value;

    public long getValue() {
        return value;
    }

    public void run() {
        int max = 2000000;
        long sum = 0;
        List<Integer> primes;

        primes = Util.primeSieve(max);

        for (Integer prime : primes) {
            sum += prime;
        }

        value = (sum);
    }
}
