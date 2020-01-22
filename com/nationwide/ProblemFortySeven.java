package com.nationwide;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemFortySeven implements Runnable {
    private double value;

    public double getValue() {
        return value;
    }

    // To improve performance for each iteration of the loop move the factors lists down a number and then only call primeFactors for fac4
    public void run() {
        int counter = 2*3*5*7;

        while(true){
            List<Integer> factors1 = Util.primeFactors(counter);
            List<Integer> factors2 = Util.primeFactors(counter + 1);
            List<Integer> factors3 = Util.primeFactors(counter + 2);
            List<Integer> factors4 = Util.primeFactors(counter + 3);

            Set<Integer> set1 = new HashSet<>(factors1);
            Set<Integer> set2 = new HashSet<>(factors2);
            Set<Integer> set3 = new HashSet<>(factors3);
            Set<Integer> set4 = new HashSet<>(factors4);

            if(set1.size() == 4){
                if(set2.size() == 4){
                    if(set3.size() == 4){
                        if(set4.size() == 4){
                            value = counter;
                            break;
                        }
                    }
                }
            }

            counter++;
        }
    }
}