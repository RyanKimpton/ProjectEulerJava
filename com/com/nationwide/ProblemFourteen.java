package com.nationwide;

public class ProblemFourteen implements Runnable{
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {

        int max = 0;
        int largeCollatz = 0;

        for(int i = 1; i<1000000; i++){
            long collatz = i;
            int current = 0;
            while(collatz != 1){
                if(collatz % 2 == 0){
                    collatz /= 2;
                    current++;
                } else {
                    collatz = (collatz * 3) + 1;
                    current++;
                }
            }
            if(max < current){
                max = current;
                largeCollatz = i;
            }
        }
        value = largeCollatz;
    }
}
