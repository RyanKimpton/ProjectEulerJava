package com.nationwide;

import java.util.List;

//TODO Performance improvements
public class ProblemThirtyFive implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {


        List<Integer> primes =  Util.primeSieve(1000001);
        int total = 0;

        for( int i = 0; i < primes.size(); i++){
            //Gives the length of the current number so we know how many rotations are needed
            int flag = 0;
            int ithPrime = primes.get(i);
            int len = Util.length(ithPrime);
            for( int j = 1; j < len+1; j++){
                int nextPrime =  Integer.parseInt(Util.stringRotator(String.valueOf(ithPrime), j));

                if(!(primes.contains(nextPrime))){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                total++;
            }
        }
        value = total;
    }
}
