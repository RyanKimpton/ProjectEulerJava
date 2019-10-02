package com.nationwide;

public class ProblemSeven implements Runnable  {
    public void run() {
        int counter = 0;
        int nth = 10001;
        int prime = 2;
        while( counter < nth){
            if(Util.isPrime(prime)){
                counter++;
            }
            prime++;
        }
        prime --;
        System.out.println(prime);
    }
}
