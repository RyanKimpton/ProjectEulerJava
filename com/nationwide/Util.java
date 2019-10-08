package com.nationwide;

import java.lang.Math;
import java.math.BigInteger;
import java.util.*;


class Util {

    static boolean isPrime(long numb){

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

    static boolean isPalindrome(int numb){
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

    static List<Integer> primeFactors(double numb){
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

    static int lcm(ArrayList<Integer> num){

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

    static List<Integer> primeSieve(int max){
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

    static int nthTriangle(int n){
        return n*(n+1)/2;
    }

    static List<Integer> factors(int num){
        ArrayList<Integer> facs = new ArrayList<>();

        for(int i = 1; i < Math.ceil(Math.sqrt(num)) + 1; i++){
            if(num % i == 0){
                facs.add(i);
                facs.add(num / i);
            }
        }

        return facs;
    }

    static BigInteger factorial(int n){
        BigInteger fac = new BigInteger("1");
        for( int i = 1; i <= n; i++){
            fac = fac.multiply(new BigInteger(i + ""));
        }
        return fac;
    }

    static int numberLength(int n){

        //units
        if(n < 10){
            if( n == 0){
                return 0;
            }
            if(n == 1 || n == 2 || n == 6){
                return 3;
            }
            if(n == 4 || n == 5 || n == 9){
                return 4;
            }
            if(n == 3 || n == 7 || n == 8){
                return 5;
            }
        }

        // tens

        if( n < 100){



            if(n == 11 || n == 12) {
                return 6;
            }

            if(n == 15 || n == 16){
                return 7;
            }

            if(n == 13 || n == 14 || n == 18 || n == 19){
                return 8;
            }

            if(n == 17){
                return 9;
            }

            if( n == 10){
                return 3;
            }

            if( n == 20 || n == 30 || n == 80 || n == 90){
                return 6;
            }

            if( n == 40 || n == 50 || n == 60){
                return 5;
            }

            if ( n == 70){
                return 7;
            }

            return numberLength(n % 10) + numberLength( n - n % 10);

        }

        // Hundreds

        if( n < 1000){
           if( n % 10 == 0 && n % 100 == 0){
               System.out.println(n);
               return numberLength(n/100) + 7;
           }

            return numberLength((n - (n % 100)) / 100 ) + numberLength(n - ((n - (n % 100)))) + 10;


        }
        return 11;
    }

}
