package com.nationwide;

public class ProblemNine implements Runnable  {
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
        System.out.println( (int) (a*b*c));
    }
}
