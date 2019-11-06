package com.nationwide;

import java.lang.Math;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                facs.add(num / i);
                facs.add(i);
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
               return numberLength(n/100) + 7;
           }

            return numberLength((n - (n % 100)) / 100 ) + numberLength(n - ((n - (n % 100)))) + 10;


        }
        return 11;
    }

    static ArrayList<Integer> trianglePath(ArrayList<Integer> upper, ArrayList<Integer> lower){
        ArrayList<Integer> path = new ArrayList<>();

        for( int i = 0; i < upper.size(); i++){
            int current = upper.get(i);
            path.add(Math.max(current + lower.get(i), current + lower.get(i + 1)));
        }

        return path;
    }

    static String dayOfTheWeek(int year, int month, int day){
        String date = day + "/" + month + "/" + year;
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dt1 = format1.parse(date);
            DateFormat format2 = new SimpleDateFormat("EEEE");
            return format2.format(dt1);
        } catch (ParseException e) {
            System.out.println("Something is broken in dayOfTheWeek");
        }

        return "Error";

    }

    static BigDecimal nthFib(int n){
        BigDecimal phi, minusPhi, phiN, minusPhiN;
        phi = BigDecimal.valueOf((Math.sqrt(5) + 1)/2);
        phiN = phi.pow(n);
        minusPhi = phi.multiply(new BigDecimal(-1));
        minusPhiN = (new BigDecimal(1)).divide(minusPhi.pow(n), 10, RoundingMode.HALF_UP);

        return (phiN.subtract(minusPhiN)).divide(new BigDecimal(Math.sqrt(5)), RoundingMode.HALF_UP).round(new MathContext(1, RoundingMode.HALF_UP));
    }

}
