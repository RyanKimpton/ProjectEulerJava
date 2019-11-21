package com.nationwide;

public class ProblemSeventeen implements Runnable {
    private int value;

    public int getValue() {
        return value;
    }

    public void run() {
        int total = 0;

        for( int i = 1; i < 1001; i++){
            total += Util.numberWordLength(i);
        }

        value = total;
    }
}
