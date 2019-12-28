package com.nationwide;

public class ProblemOne implements Runnable {

    private int value;

    public int getValue() {
        return value;
    }

    public void run() {
        int current = 0;
        int total = 0;
        int max = 1000;

        while (current < max){
            if(current%3 == 0 || current%5 ==0){
                total += current;
            }
            current += 1;
        }
        value = total;
    }
}
