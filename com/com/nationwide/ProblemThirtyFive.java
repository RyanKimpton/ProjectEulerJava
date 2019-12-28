package com.nationwide;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemThirtyFive implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        List<Integer> primeNumbers =  Util.primeSieve(1000001);
        Set primes = new HashSet(primeNumbers);
        int total = 0;

        for( int i = 0; i < primes.size(); i++){
            //Flag that is 0 when the prime is circular, 1 otherwise
            int flag = 0;
            //Current value to go through rotations
            int ithPrime = primeNumbers.get(i);
            //Gives the length of the current number so we know how many rotations are needed
            int len = Util.length(ithPrime);

            //Loop through all rotations of the current prime, checking if each one is also prime
            for( int j = 1; j < len+1; j++){
                //Next rotation
                int nextPrime =  Integer.parseInt(Util.stringRotator(String.valueOf(ithPrime), j));

                //If this prime is not in our list of primes then flag it and break out of the loop
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
