package com.nationwide;

public class ProblemFour  implements Runnable {
    private int value;

    public int getValue() {
        return value;
    }
    public void run() {
        int biggest = 0;

        for(int i = 100; i<999; i++){
            for(int j = i; j<999; j++){
                if( Util.isPalindrome(i*j, 10)){
                    if(i*j > biggest){
                        biggest = i*j;
                    }
                }
            }
        }

        value = (biggest);
    }
}
