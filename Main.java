import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static boolean isPrime(long numb){

        if( numb == 2){
            return true;
        }

        for(int i = 2; i < Math.sqrt(numb)+1; i++){
            if(numb%i == 0){
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(int numb){
        String number = Integer.toString(numb);
        char[] indNumbers = number.toCharArray();
        int leng = indNumbers.length;

        for( int i = 0; i < Math.ceil(leng/2); i++){
            if(indNumbers[i] != indNumbers[leng-i-1]){

                return false;
            }
        }
        return true;
    }

    private static List<Integer> primeFactors(double numb){
        List<Integer> primefacs = new ArrayList();


        while(numb / 2 == Math.ceil(numb / 2)){
            primefacs.add(2);
            numb = numb / 2;
        }

        double max =  Math.sqrt(numb) + 1;

        for( int i = 3; i< max; i+=2 ){
            if(isPrime(i)){
                while(numb / i == Math.ceil(numb / i)){
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

    private static int lcm(ArrayList<Integer> num){

        int numLeng = num.size();
        int counter = 0;
        double lcm = 1;
        ArrayList<Integer> factors = new ArrayList();
        List<Integer> currentFactors = new ArrayList<Integer>();


        for( int i = 0; i < numLeng; i++){
            factors.addAll(primeFactors(num.get(i)));
        }

        int biggestFactor = Collections.max(factors);

        int[] frequency = new int[biggestFactor + 1];

        for(int i = 0; i < numLeng; i++){

            for(int j = 0; j < biggestFactor + 1; j++){
                counter = 0;
                currentFactors = primeFactors(num.get(i));

                for(int k = 0; k < currentFactors.size(); k++){
                    if(currentFactors.get(k) == j){

                        counter++;
                    }
                }
                if(counter > frequency[j]){
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


    private static int problemOne(){
        int current = 0;
        int total = 0;
        int max = 1000;

        while (current < max){
            if(current%3 == 0 || current%5 ==0){
                total += current;
            }
            current += 1;
        }

        return total;
    }

    private static int problemTwo(){
        int fib_1 = 1;
        int fib_2 = 1;
        int fib_3 = 0;
        int total = 0;
        int max = 4000000;

        while(fib_3 < max){
            fib_3 = fib_1 + fib_2;

            if(fib_3%2 == 0 && fib_3 < max){
                total += fib_3;
            }

            fib_1 = fib_2;
            fib_2 = fib_3;


        }

        return(total);
    }

    private static long problemThree(){
        double number = 600851475143L;
        List<Integer> primes = primeFactors(number);

        int biggest = primes.get(primes.size()-1);

        return biggest;
    }

    private static int problemFour(){
        int biggest = 0;

        for(int i = 100; i<999; i++){
            for(int j = i; j<999; j++){
                if( isPalindrome(i*j)){
                    if(i*j > biggest){
                        biggest = i*j;
                    }
                }
            }
        }

        return biggest;
    }

    private static int problemFive(){
        ArrayList numbers = new ArrayList<Integer>();
        for(int i = 1; i < 20; i++){
            numbers.add(i);
        }
        return lcm(numbers);
    }


    private static int problemSix(){
        int total = 0;
        int max = 100;
        for( int i = 0; i < max + 1; i++){
            for( int j = i + 1; j < max + 1; j++){
                total += 2*i*j;
            }
        }
        return total;
    }

    private static int problemSeven(){
        int counter = 0;
        int nth = 10001;
        int prime = 2;
        while( counter < nth){
            if(isPrime(prime)){
                counter++;
            }
            prime++;
        }
        return prime - 1;
    }

    private static long problemEight(){
        String bigNum = "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";
        long current;
        long biggest = 1L;
        int length = 13;

        char[] nums = bigNum.toCharArray();

        for( int i = 0; i < length; i++){
            biggest *= Character.getNumericValue(nums[i]);
        }

        for( int i = 0; i < nums.length - length; i++){
            current = 1;
            for( int j = 0; j < length; j++){
                current *= Character.getNumericValue(nums[i + j]);
            }

            if( current > biggest ){
                biggest = current;
            }
        }

        return biggest;
    }

    private static int problemNine(){
        double a = 1;
        double b = 1;
        double c = 1;

        for(int m = 1; m < 50; m++){
            for(int n = 1; n < 50; n++){
                if(m*m + (m*n) == 500){

                    //The following is a magic formula to find triplets quickly

                    a = m*m - n*n;
                    b = 2*m*n;
                    c = m*m + n*n;
                }
            }
        }
        return (int) (a*b*c);
    }






    public static void main(String[] args){
        long startTime = System.nanoTime();


        System.out.println("problem 1 = " + problemOne());
        System.out.println("problem 2 = " + problemTwo());
        System.out.println("problem 3 = " + problemThree());
        System.out.println("problem 4 = " + problemFour());
        System.out.println("Problem 5 = " + problemFive());
        System.out.println("Problem 6 = " + problemSix());
        System.out.println("Problem 7 = " + problemSeven());
        System.out.println("Problem 8 = " + problemEight());
        System.out.println("Problem 9 = " + problemNine());


        long endTime = System.nanoTime();
        double totalTime = (double) (endTime - startTime) / 1000000000;
        System.out.println("Time to run is: " + totalTime + " seconds");
    }
}
