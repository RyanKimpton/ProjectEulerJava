package com.nationwide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProblemThirtyTwo implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        int sum = 0;
        List<Integer> added = new ArrayList<>();

        for( int mult1 = 2; mult1 < 9876; mult1++){
            for( int mult2 = mult1; mult2 < 9876; mult2++){
                boolean cont = true;

                if(Util.length(mult1) == 1 && Util.length(mult2) == 4){
                    cont = false;
                }

                if(Util.length(mult1) == 2 && Util.length(mult2) == 3){
                    cont = false;
                }

                if(cont){
                    continue;
                }


                int total = mult1 * mult2;
                //String representation for checking if it is pandigital
                String niner = "" + total + mult1 + mult2;
                if(niner.length() == 9){
                    //For number to be 9 pandigital it must be of length 9
                    if(Util.ninePandigital(niner)){
                        //Number is pandigital
                        if(!added.contains(total)){
                            //We haven't already counted this number
                            sum += total;
                            added.add(total);
                        }
                    }
                }
            }
        }
        value = sum;
    }
}
