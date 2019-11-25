package com.nationwide;

public class ProblemForty implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        int[] digits = {1, 10, 100, 1000, 10000, 100000, 1000000};
        int[] decadeLength = new int[5];
        int total = 1;
        double decimal;
        int integer;

        for(int i = 0; i < 5; i++){
            decadeLength[i] = (int) ((i+1) * 9 * Math.pow(10, i));
            System.out.println(decadeLength[i]);
        }

        for( int i = 0; i < 7; i++){
            double currentDigit = digits[i];

            for(int j = 0; j < 5; j++){
                if(currentDigit > decadeLength[j]){
                    currentDigit -= decadeLength[j];
                }
            }

            if(i == 0 || i == 1){
                decimal = 1 ;
            } else {
                if(i == 2){
                    currentDigit = (currentDigit / 2) + 9;
                    decimal = (currentDigit - (int) currentDigit) * 2;
                } else {
                    if(i == 3){
                        currentDigit = (currentDigit / 3) + 99;
                        decimal = (currentDigit - (int) currentDigit) * 3;
                    } else {
                        if(i == 4){
                            currentDigit = (currentDigit / 4) + 999;
                            decimal = (currentDigit - (int) currentDigit) * 4;
                        } else {
                            if(i == 5){
                                currentDigit = (currentDigit / 5) + 9999;
                                decimal = (currentDigit - (int) currentDigit) * 5;
                            } else {
                                currentDigit = (currentDigit / 6) + 99999;
                                decimal = (currentDigit - (int) currentDigit) * 6;
                            }
                        }
                    }
                }
            }

            decimal = Math.round(decimal);
            integer = (int) currentDigit;

            int index = (int) decimal - 1;

            String finalNumber = Integer.toString(integer).substring(index, index + 1);

            total *= Integer.parseInt(finalNumber);
        }

        value = total;
    }
}
