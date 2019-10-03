package com.nationwide;

import java.util.ArrayList;

public class ProblemFive implements Runnable  {
    private int value;

    public int getValue() {
        return value;
    }

    public void run() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < 20; i++){
            numbers.add(i);
        }
        value = (Util.lcm(numbers));
    }
}
