package com.nationwide;

public class ProblemTwentySix implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        int longest = 0;
        for( int i = 2; i < 1000; i++){
            int length = Util.decimalCycleLength(i);
            if(longest < length){
                longest = length;
                value = i;
            }
        }
    }
}
