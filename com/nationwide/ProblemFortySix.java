package com.nationwide;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemFortySix implements Runnable {
    private double value;

    public double getValue() {
        return value;
    }

    public void run() {
        int currentNumber = 9;
        int currentPrime = 2;
        int counter = 0;

        List<Integer> primeNumbers = Util.primeSieve(10000);
        Set primes = new HashSet(primeNumbers);

        //Run until the number is found
        outer:
        while(true){
            System.out.println(currentNumber);
            //Is currentNumber prime
            if(!(primes.contains(currentNumber))){
                currentPrime = primeNumbers.get(counter);
                //While the difference between currentNumber and currentPrime is positive
                while(currentPrime < currentNumber){
                    double numberToCheck = Math.sqrt((currentNumber - currentPrime) * 0.5);

                    if(numberToCheck == (int) numberToCheck){
                        //There exists a prime that the result holds for
                        counter = 0;
                        currentNumber += 2;
                    } else {
                        if(primeNumbers.get(counter + 1) > currentNumber){
                            //There are no other primes to check
                            value = currentNumber;
                            break outer;
                        } else {
                            //There are other, larger, primes that we need to check the condition for
                            counter++;
                            currentPrime = primeNumbers.get(counter);
                        }
                    }
                }
            } else {
                currentNumber += 2;
            }
        }
    }
}
