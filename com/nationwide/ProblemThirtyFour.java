package com.nationwide;


public class ProblemThirtyFour implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        int sumOfFactorions = 0;
        for( int i = 3; i < 1500000; i++){
            int total = 0;
            int number = i;

            while(number > 10){
                int digit = number % 10;
                total += Util.smallFactorial(digit);
                number = (number - digit) / 10;
            }

            total += Util.factorial(number).intValue();

            if(total == i){
                sumOfFactorions += i;
            }
        }
        value = sumOfFactorions;
    }
}
