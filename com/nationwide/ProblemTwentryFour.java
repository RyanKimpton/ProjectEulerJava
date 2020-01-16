package com.nationwide;

public class ProblemTwentryFour implements Runnable {
    private long value;

    public long getValue() {
        return value;
    }

    public void run() {
        long[] pandigitals = Util.allPandigitals(9);

        value = pandigitals[637118];
    }
}
