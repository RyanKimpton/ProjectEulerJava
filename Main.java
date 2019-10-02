import java.lang.Math;
import java.util.*;


public class Main {

    private static boolean isPrime(long numb){

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


    private static List primeSieve(int max){
        List primes = new ArrayList<Integer>();
        boolean prime[] = new boolean[max+1];

        for(int i=0;i<max;i++)
            prime[i] = true;

        for(int p = 2; p*p <=max; p++){
            if(prime[p] == true){
                for(int i = p*p; i <= max; i += p) {
                    prime[i] = false;
                }
            }
        }

        for(int i = 2; i <= max; i++) {
            if(prime[i] == true){
                primes.add(i);
            }
        }

        return primes;
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

    private static long problemTen(){
        int max = 2000000;
        long sum = 0;
        List<Integer> primes = new ArrayList();

        primes = primeSieve(max);

        for(int i = 0; i < primes.size(); i++){
            sum += primes.get(i);
        }

        return sum;
    }

    private static int problemEleven(){
        String bigNum = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 " +
                "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 " +
                "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 " +
                "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 " +
                "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 " +
                "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 " +
                "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 " +
                "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 " +
                "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 " +
                "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 " +
                "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 " +
                "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 " +
                "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 " +
                "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 " +
                "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 " +
                "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 " +
                "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 " +
                "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 " +
                "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 " +
                "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
        String[] doubles = bigNum.split(" ");
        int max = 0;
        int current = 0;
        int index;

        //Row start
        for( int i = 0; i < 20; i++) {
            //col start
            for (int j = 0; j < 20; j++) {
                index = i + 20 * j;
                //Decreasing diag:
                if (i < 17 & j < 17) {
                    current = Integer.parseInt(doubles[index]) * Integer.parseInt(doubles[index + 21]) * Integer.parseInt(doubles[index + 42]) * Integer.parseInt(doubles[index + 63]);
                    if (current > max) {
                        max = current;
                    }
                }
                //Increasing diag:
                if (i < 17 & j > 2) {
                    current = Integer.parseInt(doubles[index]) * Integer.parseInt(doubles[index - 19]) * Integer.parseInt(doubles[index - 38]) * Integer.parseInt(doubles[index - 57]);
                    if (current > max) {
                        max = current;
                    }
                }
                //Top to bottom:
                if (j < 17) {
                    current = Integer.parseInt(doubles[index]) * Integer.parseInt(doubles[index + 20]) * Integer.parseInt(doubles[index + 40]) * Integer.parseInt(doubles[index + 60]);
                    if (current > max) {
                        max = current;
                    }
                }
                //Left to right
                if (i < 17) {
                    current = Integer.parseInt(doubles[index]) * Integer.parseInt(doubles[index + 1]) * Integer.parseInt(doubles[index + 2]) * Integer.parseInt(doubles[index + 3]);
                    if (current > max) {
                        max = current;
                    }
                }
            }
        }
        return max;
    }

    private static int problemTwleve(){
        
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
        System.out.println("Problem 10 = " + problemTen());
        System.out.println("Problem 11 = " + problemEleven());



        long endTime = System.nanoTime();
        double totalTime = (double) (endTime - startTime) / 1000000000;
        System.out.println("Time to run is: " + totalTime + " seconds");
    }
}
