package com.nationwide;

public class ProblemFifteen implements Runnable {
    private double value;

    public double getValue() {
        return value;
    }

    public void run() {
        value = Util.factorial(40).doubleValue() / Math.pow( Util.factorial(20).doubleValue(), 2);
    }
}
