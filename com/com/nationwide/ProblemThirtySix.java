package com.nationwide;

public class ProblemThirtySix implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        int total = 0;

        for( int i = 1; i < 1000001; i += 2){
            if(Util.isPalindrome(i, 10)){

                if(Util.isPalindrome(i, 2)){
                    total += i;
                }
            }
        }

        value = total;
    }
}
