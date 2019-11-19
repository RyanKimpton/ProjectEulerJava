package com.nationwide;

import java.util.ArrayList;

public class ProblemThirtyThree implements Runnable {
    private double value;

    public double getValue() {
        return value;
    }

    public void run() {
        //Check if numer and denom are coprime
        //if statement at the start to check if numer < denom
        //numer and denom both >9 and < 99

        double superNumer = 1;
        double superDenom = 1;

        for(double numer = 10; numer < 100; numer++){
            for(double denom = numer + 1; denom < 100; denom++){
                if(!(numer % 10 == 0 & denom % 10 == 0)){
                    //Both numbers are not divisible by 10 leading to trivial case
                    double numer1 = numer % 10;
                    double numer2 = (numer - (numer % 10 )) / 10;
                    double denom1 = denom % 10;
                    double denom2 = (denom - (denom % 10 )) / 10;

                    if(numer1 == denom2){
                        if(numer2 / denom1 == numer / denom){
                            superNumer *= numer;
                            superDenom *= denom;
                        }
                    }
                }
            }
        }

        ArrayList<Integer> lcmArray = new ArrayList<>();
        lcmArray.add((int) superNumer);
        lcmArray.add((int) superDenom);
        double gcd = superNumer*superDenom / Util.lcm(lcmArray);
        value = superDenom / gcd;
    }
}
