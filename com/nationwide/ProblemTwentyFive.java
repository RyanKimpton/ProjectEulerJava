package com.nationwide;

public class ProblemTwentyFive implements Runnable {
    private int value;

    public int getValue() {
        return value;
    }

    public void run() {
        int flag = 0;
        int fib = 150;
        int pow;
        int upper = 200;
        int lower = 100;
        String str = "";



        while(flag == 0){
            str = Util.nthFib(fib).toString();
            pow = Integer.parseInt(str.substring(3, str.length()));
            if(pow <= 1000) {
                lower *= 2;
                upper *= 2;
                fib *= 2;
            } else {
                flag = 1;
            }
        }

        while(flag == 1){
            str = Util.nthFib(fib).toString();
            pow = Integer.parseInt(str.substring(3, str.length()));
            if(pow == 999){
                value = fib + 1;
                flag = -1;
            }
            fib--;
        }
    }
}
