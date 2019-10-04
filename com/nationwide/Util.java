package com.nationwide;

import java.lang.Math;
import java.math.BigInteger;
import java.util.*;


public class Util {

    public static boolean isPrime(long numb){

        if( numb == 2){
            return true;
        }

        if( numb % 2 == 0){
            return false;
        }


        for(int i = 3; i < Math.sqrt(numb)+1; i += 2){
            if(numb%i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int numb){
        String number = Integer.toString(numb);
        char[] indNumbers = number.toCharArray();
        int leng = indNumbers.length;

        for( int i = 0; i < leng/2 + 1; i++){
            if(indNumbers[i] != indNumbers[leng-i-1]){

                return false;
            }
        }
        return true;
    }

    public static List<Integer> primeFactors(double numb){
        ArrayList<Integer> primefacs = new ArrayList<>();


        while(numb % 2 == 0){
            primefacs.add(2);
            numb = numb / 2;
        }

        double max =  Math.sqrt(numb) + 1;

        for( int i = 3; i< max; i+=2 ){
            if(isPrime(i)){
                while(numb % i == 0){
                    primefacs.add(i);
                    numb = numb / i;

                }
            }
        }

        if(numb > 2){
           primefacs.add( (int) numb);
        }
        return primefacs;

    }

    public static int lcm(ArrayList<Integer> num){

        int counter;
        double lcm = 1;
        ArrayList<Integer> factors = new ArrayList<>();
        List<Integer> currentFactors;


        for (Integer value : num) {
            factors.addAll(primeFactors(value));
        }

        int biggestFactor = Collections.max(factors);

        int[] frequency = new int[biggestFactor + 1];

        for (Integer integer : num) {

            for (int j = 0; j < biggestFactor + 1; j++) {
                counter = 0;
                currentFactors = primeFactors(integer);

                for (Integer currentFactor : currentFactors) {
                    if (currentFactor == j) {
                        counter++;
                    }
                }
                if (counter > frequency[j]) {
                    frequency[j] = counter;
                }
            }
        }

        for(int i = 0; i< biggestFactor + 1; i++){
            if(frequency[i] > 0){
                lcm = lcm * Math.pow(i, frequency[i]);

            }
        }

        return (int) lcm;

    }

    public static List<Integer> primeSieve(int max){
        List<Integer> primes = new ArrayList<>();
        boolean[] prime = new boolean[max+1];

        for(int i=0;i<max;i++)
            prime[i] = true;

        for(int p = 2; p*p <=max; p++){
            if(prime[p]){
                for(int i = p*p; i <= max; i += p) {
                    prime[i] = false;
                }
            }
        }

        for(int i = 2; i <= max; i++) {
            if(prime[i]){
                primes.add(i);
            }
        }

        return primes;
    }

    public static int nthTriangle(int n){
        return n*(n+1)/2;
    }

    public static List<Integer> factors(int num){
        ArrayList<Integer> facs = new ArrayList<>();

        for(int i = 1; i < Math.ceil(Math.sqrt(num)) + 1; i++){
            if(num % i == 0){
                facs.add(i);
                facs.add(num / i);
            }
        }

        return facs;
    }

    public static BigInteger factorial(int n){
        BigInteger fac = new BigInteger("1");
        for( int i = 1; i <= n; i++){
            fac = fac.multiply(new BigInteger(i + ""));
        }
        System.out.println(fac);
        return fac;
    }

}
