package com.nationwide;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemFortyFour implements Runnable {
    private double value;

    public double getValue() {
        return value;
    }

    public void run() {
        boolean notFound = true;
        int i = 1;

        while(notFound){
            i++;

            for( int j = i - 1; j > 1; j--){
                double n = 0.5 * ( 3 * i * i - i);
                double m = 0.5 * ( 3 * j * j - j);

                if (Util.isPentagonal(n + m) && Util.isPentagonal(n - m)) {
                    value = n - m;
                    notFound = false;
                    break;
                }
            }

        }


    }
}
