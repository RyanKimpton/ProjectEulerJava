package com.nationwide;

import java.util.ArrayList;
import java.util.List;

public class ProblemThirtyNine implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        int[] frequencies = new int[1000];
        int max = 0;
        int index = 0;
        List<Integer> factors = new ArrayList<>();

        for( int r = 2; r < 250; r += 2){
            int s;
            int t;
            factors = Util.factors(r*r / 2);
            for( int i = 0; i< factors.size(); i+=2){
                s = factors.get(i);
                t = factors.get(i+1);

                int perimeter = r + s + r + t + r + s + t;

                if(perimeter < 1001){
                    frequencies[perimeter - 1]++;
                }
            }
        }

        for(int i = 0; i<1000; i++){
            if(max < frequencies[i]){
                max = frequencies[i];
                index = i + 1;
            }
        }

        value = index;
    }




}
