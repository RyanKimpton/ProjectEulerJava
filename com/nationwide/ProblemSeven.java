package com.nationwide;

public class ProblemSeven implements Runnable  {
    private int value;

    public int getValue() {
        return value;
    }

    public void run() {
        int counter = 0;
        int nth = 10001;
        int prime = 2;
        while( counter < nth){
            if(Util.isPrime(prime)){
                counter++;
            }
            prime++;
        }
        prime --;
        value = (prime);
    }
}
