package com.nationwide;

public class ProblemTwelve implements Runnable  {
    private int value;

    public int getValue() {
        return value;
    }

    public void run() {
        int tri = 0;
        int size = 0;
        int counter = 1;

        while(size < 500){
            tri = Util.nthTriangle(counter);
            size = Util.factors(tri).size();
            counter++;
        }

        value = (tri);
    }
}
