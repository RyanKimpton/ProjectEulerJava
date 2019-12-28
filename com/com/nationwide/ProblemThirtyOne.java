package com.nationwide;

public class ProblemThirtyOne implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] table = new int[201];
        table[0] = 1;

        for(int i = 0; i < 8; i++){
            for(int j = coins[i]; j < 201; j++){
                table[j] += table[j-coins[i]];
            }
        }

        value = table[200];
    }
}
