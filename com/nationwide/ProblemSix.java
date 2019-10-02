package com.nationwide;

public class ProblemSix implements Runnable  {
    public void run() {
        int total = 0;
        int max = 100;
        for( int i = 0; i < max + 1; i++){
            for( int j = i + 1; j < max + 1; j++){
                total += 2*i*j;
            }
        }
        System.out.println(total);
    }
}
