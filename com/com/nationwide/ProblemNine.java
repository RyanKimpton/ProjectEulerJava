package com.nationwide;

public class ProblemNine implements Runnable  {
    private int value;

    public int getValue() {
        return value;
    }

    public void run() {
        double a = 1;
        double b = 1;
        double c = 1;

        for(int m = 1; m < 50; m++){
            for(int n = 1; n < 50; n++){
                if(m*m + (m*n) == 500){

                    //The following is a magic formula to find triplets quickly

                    a = m*m - n*n;
                    b = 2*m*n;
                    c = m*m + n*n;
                }
            }
        }
        value = ( (int) (a*b*c));
    }
}
