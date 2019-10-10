package com.nationwide;

import java.util.HashMap;
import java.util.Map;

public class ProblemNineteen implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        int counter = 0;

        for(int i = 1901; i<2001; i++){
            for( int j = 1; j < 13; j++){
                 if(Util.dayOfTheWeek(i, j, 1).equals("Sunday")){
                     System.out.println(i + "-" + j);
                     counter++;
                 }
            }
        }

        value = counter;
    }
}
