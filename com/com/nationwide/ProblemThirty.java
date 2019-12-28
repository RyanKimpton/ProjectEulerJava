package com.nationwide;

public class ProblemThirty implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        //5*9^5 gives a 6 digit number
        //6*9^5 also gives a 6 digit number and hence 6*9^5 is our upper bound
        int total = 0;

        for(int i = 2; i < 6*Math.pow(9,5); i++){
            int current = i;
            double powSum = 0;

            while(current>0){
                int pow = current % 10;
                current /= 10;

                powSum += Math.pow(pow, 5);
            }

            if(powSum == i){
                total += powSum;
            }
        }

        value = total;
    }
}
