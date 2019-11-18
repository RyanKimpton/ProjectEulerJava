package com.nationwide;

public class ProblemTwentyEight implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        int total = 1;
        int square = 2;

        for( int spiralLevel = 1; spiralLevel <= 1000; spiralLevel += 2){
            int squareSquare = square*square;
            int squareSquarePlus = (square+1)*(square+1);
            System.out.println(squareSquare);
            System.out.println(squareSquarePlus);
            total += (squareSquare) + (squareSquare - spiralLevel) + (squareSquarePlus) + (squareSquarePlus - spiralLevel);
            square+=2;
        }

        value = total;
    }
}
