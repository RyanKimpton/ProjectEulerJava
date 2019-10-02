package com.nationwide;

import java.util.ArrayList;

public class ProblemFive implements Runnable  {
    public void run() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < 20; i++){
            numbers.add(i);
        }
        System.out.println(Util.lcm(numbers));
    }
}
