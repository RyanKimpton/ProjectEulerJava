package com.nationwide;

public class ProblemFortyFive implements Runnable {
    private double value;

    public double getValue() {
        return value;
    }

    public void run() {
        boolean notFound = true;
        int i = 144;

        while(notFound){
            i++;
            int hexa = i * (2 * i - 1);

            if(Util.isPentagonal(hexa)){
                if(Util.isTriangular(hexa)){
                    value = hexa;
                    notFound = false;
                    break;
                }
            }
        }

    }
}