package com.nationwide;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


class Util {
    /**
     * Function to check if a given number is prime
     * @param numb The number to be prime tested
     * @return Returns true only if numb is prime
     */
    static boolean isPrime(long numb){
        if( numb == 1){
            return false;
        }

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

    /**
     * Function to check if a given number is a palindrome
     * @param numb the number to test in base 10
     * @param base the base of the number system you want to check in
     * @return Returns true only if numb is a palindrome
     */
    static boolean isPalindrome(int numb, int base){
        int reverse = 0;
        int temp = numb;

        while(temp > 0){
            reverse = base * reverse + temp % base;
            temp /= base;
        }

        return numb == reverse;
    }

    /**
     * Function that will return a list of all prime factors of a number 1 is not included, numb if prime will be
     * @param numb the number to find the prime factors of
     * @return Returns a List of all prime factors
     */
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

    /**
     * Function to find the lowest common multiple of all numbers in a list
     * @param num A list of numbers to find the LCM of
     * @return Returns the integer value of the LCM
     */
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

    /**
     * Function to find all the prime numbers up but NOT INCLUDING a given value
     * @param max The upper bound of the primes to find
     * @return Returns a list of all primes up to max
     */
    static List<Integer> primeSieve(int max){
        List<Integer> primes = new ArrayList<>();
        boolean[] prime = new boolean[max+1];

        //Set all values in the prime array to be prime;
        for(int i=0;i<max;i++)
            prime[i] = true;


        for(int p = 2; p*p <=max; p++){
            //If the number being checked is prime then remove all multiples from the sieve
            //Otherwise all its multiples are already removed and do not need to be checked again
            if(prime[p]){
                for(int i = p*p; i <= max; i += p) {
                    prime[i] = false;
                }
            }
        }

        //If index in the prime array is true then send it to the List to return
        for(int i = 2; i <= max; i++) {
            if(prime[i]){
                primes.add(i);
            }
        }

        return primes;
    }

    /**
     * A simple function to return the nth triangular number, this is the same as the sum from 1 to n
     * @param n The index of the triangular number to find
     * @return The nth triangular number
     */
    static int nthTriangle(int n){
        return n*(n+1)/2;
    }

    /**
     * A function to create a list of all the factors of a number. The list is not returned in order, 1 and the number
     * are both returned
     * @param num The number to find the factors of
     * @return An unordered list of all the factors of a number. num is always the first number in the list, 1 is the
     * second
     */
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

    /**
     * A function to find large factorials through the use of BigInteger. To be used when the factorial being found
     * is greater than 20
     * @param n the number to find n!
     * @return the factorial of n
     */
    static BigInteger factorial(int n){
        BigInteger fac = new BigInteger("1");
        for( int i = 1; i <= n; i++){
            fac = fac.multiply(new BigInteger(i + ""));
        }
        return fac;
    }

    /**
     * A lighter function used to calculate small factorials up to 19! without using Big Integer leading to improved
     * performance
     * @param n the number to find n!
     * @return the factorial of n
     */
    static int smallFactorial(int n){
        //Lightweight function for finding small factorial values that don't need to use BigInteger
        int fac = 1;
        for( int i = 1; i <= n; i++){
            fac = fac * i;
        }
        return fac;
    }

    /**
     * A function to find the length of a numbers English representation. Note that this is only for numbers up to 1000
     * and should not be used for numbers higher than that but can easily be expanded.
     * @param n The number to find the length of the name of
     * @return The length of the numbers English representation
     */
    static int numberWordLength(int n){

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

            return numberWordLength(n % 10) + numberWordLength( n - n % 10);

        }

        // Hundreds

        if( n < 1000){
           if( n % 10 == 0 && n % 100 == 0){
               return numberWordLength(n/100) + 7;
           }

            return numberWordLength((n - (n % 100)) / 100 ) + numberWordLength(n - ((n - (n % 100)))) + 10;


        }
        return 11;
    }

    /**
     * A function that is used to find the highest sum path through a triangle of digits.
     * @param upper
     * @param lower
     * @return
     */
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

        return (phiN.subtract(minusPhiN)).divide(BigDecimal.valueOf(Math.sqrt(5)), RoundingMode.HALF_UP).round(new MathContext(1, RoundingMode.HALF_UP));
    }

    static int decimalCycleLength(int n){
        //Pre logic input editing
        while(n % 2 == 0){
            n /= 2;
        }

        while(n % 5 == 0){
            n /= 5;
        }

        int mod = 10 % n;
        int currentMod = mod;
        int length = 1;

        while(true){
            if(currentMod == 0 || currentMod == 1){
                return length;
            }
            currentMod = (currentMod * mod) % n;
            length ++;
        }
    }

    static boolean ninePandigital(String n){
        return n.contains("1") && n.contains("2") && n.contains("3") && n.contains("4") && n.contains("5") && n.contains("6") && n.contains("7") && n.contains("8") && n.contains("9");
    }

    private static double func(double x){
        //function only used when called in newtonsMethod below
        return Math.pow(10.0, x) - 36288 * x;
    }

    private static double derivativeFunc(double x){
        //function only used when called in newtonsMethod below
        return Math.pow(10, x)*Math.log(10) - 36288;
    }

    static double newtonsMethod(double n){
        double h = func(n) / derivativeFunc(n);

        while(Math.abs(h) >= 0.0001){
            h = func(n) / derivativeFunc(n);
            n -= h;
        }

        return n;
    }

    static String stringRotator(String s, int offset){
        int i = offset % s.length();
        return s.substring(i) + s.substring(0, i);
    }

    static int length(int n){
        if (n < 100000){
            // 5 or less
            if (n < 100){
                // 1 or 2
                if (n < 10)
                    return 1;
                else
                    return 2;
            }else{
                // 3 or 4 or 5
                if (n < 1000)
                    return 3;
                else{
                    // 4 or 5
                    if (n < 10000)
                        return 4;
                    else
                        return 5;
                }
            }
        } else {
            // 6 or more
            if (n < 10000000) {
                // 6 or 7
                if (n < 1000000)
                    return 6;
                else
                    return 7;
            } else {
                // 8 to 10
                if (n < 100000000)
                    return 8;
                else {
                    // 9 or 10
                    if (n < 1000000000)
                        return 9;
                    else
                        return 10;
                }
            }
        }
    }

    private static void swap(int[] data, int left, int right){

        // Swap the data
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;

        // Return the updated array
    }

    private static void reverse(int[] data, int left, int right){

        // Reverse the sub-array
        while (left < right) {
            int temp = data[left];
            data[left++] = data[right];
            data[right--] = temp;
        }

        // Return the updated array
    }

    private static int[] findNextPermutation(int[] data){

        // If the given dataset is empty
        // or contains only one element
        // next_permutation is not possible

        int last = data.length - 2;

        // find the longest non-increasing suffix
        // and find the pivot
        while (last >= 0) {
            if (data[last] < data[last + 1]) {
                break;
            }
            last--;
        }


        int nextGreater = data.length - 1;

        // Find the rightmost successor to the pivot
        for (int i = data.length - 1; i > last; i--) {
            if (data[i] > data[last]) {
                nextGreater = i;
                break;
            }
        }

        // Swap the successor and the pivot
        swap(data, nextGreater, last);

        // Reverse the suffix
        reverse(data, last + 1, data.length - 1);

        // Return true as the next_permutation is done
        return data;
    }

    static long[] allPandigitals(int n){
        int size = Util.smallFactorial(n+1)-Util.smallFactorial(n);
        long nextNumber = 0;

        long[] pandigitals = new long[size];
        int[] digits = new int[n+1];

        digits[0] = 1;
        digits[1] = 0;

        for(int i = 2; i < n+1; i++){
            digits[i] = i;
        }


        for(int j = 0; j < n+1; j++){
            nextNumber *= 10;
            nextNumber += digits[j];
        }

        pandigitals[0] = nextNumber;

        for(int i = 0; i < size-1; i++){
            Util.findNextPermutation(digits);

            nextNumber = 0;

            for(int j = 0; j < n+1; j++){
                nextNumber *= 10;
                nextNumber += digits[j];
            }

            pandigitals[i] = nextNumber;

        }

        return pandigitals;
    }

    static long[] allPandigitalsZero(int n){
        int size = Util.smallFactorial(n+1);
        long nextNumber = 0;

        long[] pandigitals = new long[size];
        int[] digits = new int[n+1];

        for(int i = 0; i < n+1; i++){
            digits[i] = i;
        }

        nextNumber = joiner(digits);

        pandigitals[0] = nextNumber;

        for(int i = 0; i < size-1; i++){
            Util.findNextPermutation(digits);

            nextNumber = joiner(digits);

            pandigitals[i+1] = nextNumber;

        }

        return pandigitals;
    }

    static long joiner(int[] numbers){
        long value = 0;

        for (int number : numbers) {
            value *= 10;
            value += number;
        }

        return value;
    }

    static boolean isPentagonal(double penta){
        double penTest = (Math.sqrt(1 + 24 * penta) + 1.0) / 6.0;
        return penTest == ((int) penTest);
    }

    static boolean isTriangular(double trian){
        double triTest = Math.sqrt(8 * trian + 1);
        return triTest == ((int) triTest);
    }
}
