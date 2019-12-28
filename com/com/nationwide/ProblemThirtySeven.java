package com.nationwide;

import java.util.List;

public class ProblemThirtySeven implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        List<Integer> primes = Util.primeSieve(1000000);
        int counter = 0;
        int total = 0;
        for(int i = 4; i < primes.size(); i++){


            int primeFlag = 1;
            int tempPrime = primes.get(i);


            //Check if a number is a trunc prime removing digits from the right
            while(Util.length(tempPrime) > 1){
                tempPrime = (tempPrime - tempPrime % 10) / 10;
                if(!(Util.isPrime(tempPrime))){
                    primeFlag = 0;
                }
            }

            //Check to make sure that the number is a trunc prime from above
            if(primeFlag == 1){
                tempPrime = primes.get(i);

                while(Util.length(tempPrime) > 1){
                    tempPrime = tempPrime % (int) Math.pow(10, Util.length(tempPrime)-1);


                    if(!(Util.isPrime(tempPrime))){
                        primeFlag = 0;
                    }
                }
            }

            //final check for when prime is only 1 digit

            if(primeFlag == 1){
                total += primes.get(i);
                counter++;
            }

            if(counter==11){
                break;
            }
        }

        value = total;

    }
}
