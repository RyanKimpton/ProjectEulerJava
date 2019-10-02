package com.nationwide;

public class ProblemTwo implements Runnable {

    private int value;

    public int getValue() {
        return value;
    }

    public void run() {
        int fib_1 = 1;
        int fib_2 = 1;
        int fib_3 = 0;
        int total = 0;
        int max = 4000000;

        while(fib_3 < max){
            fib_3 = fib_1 + fib_2;

            if(fib_3%2 == 0 && fib_3 < max){
                total += fib_3;
            }

            fib_1 = fib_2;
            fib_2 = fib_3;


        }
        value = total;
    }
}
