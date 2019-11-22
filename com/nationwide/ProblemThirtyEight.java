package com.nationwide;

public class ProblemThirtyEight implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        int biggestPan = 0;

        for(int i = 2; i < 10000; i++){
            StringBuilder tempPan = new StringBuilder();
            int j = 1;

            while(tempPan.length() < 9){
                tempPan.append(i*j);
                j++;
            }

            if(tempPan.length() == 9){
                if(Util.ninePandigital(tempPan.toString())){
                    int intTempPan = Integer.parseInt(tempPan.toString());
                    if(biggestPan < intTempPan){
                        biggestPan = intTempPan;
                    }
                }
            }
        }

        value = biggestPan;
    }
}
