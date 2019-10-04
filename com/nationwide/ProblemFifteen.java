package com.nationwide;

public class ProblemFifteen implements Runnable {
    private double value;

    public double getValue() {
        return value;
    }

    public void run() {
        value = Util.factorial(40) / Math.pow( Util.factorial(20), 2);
    }
}
