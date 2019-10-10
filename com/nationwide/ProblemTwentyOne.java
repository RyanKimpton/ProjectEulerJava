package com.nationwide;

import java.util.ArrayList;

public class ProblemTwentyOne implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        ArrayList<Integer> pairs = new ArrayList<>();

        for( int i = 5; i < 10000; i++){
            int sum1 = 0;
            int sum2 = 0;
            for( int j = 1; j < Util.factors(i).size(); j++){
                sum1 += Util.factors(i).get(j);
            }

            for( int j = 1; j < Util.factors(sum1).size(); j++){
                sum2 += Util.factors(sum1).get(j);
            }

            if(i == sum2 && i != sum1){
                pairs.add(i);
            }

        }

        for (Integer pair : pairs) {
            value += pair;
        }

    }
}
