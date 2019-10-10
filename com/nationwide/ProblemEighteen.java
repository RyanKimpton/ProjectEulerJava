package com.nationwide;

import java.util.ArrayList;
import java.util.Arrays;

public class ProblemEighteen implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        ArrayList<Integer> row1 = new ArrayList<>();
        ArrayList<Integer> row2 = new ArrayList<>();
        ArrayList<Integer> row3 = new ArrayList<>();
        ArrayList<Integer> row4 = new ArrayList<>();
        ArrayList<Integer> row5 = new ArrayList<>();
        ArrayList<Integer> row6 = new ArrayList<>();
        ArrayList<Integer> row7 = new ArrayList<>();
        ArrayList<Integer> row8 = new ArrayList<>();
        ArrayList<Integer> row9 = new ArrayList<>();
        ArrayList<Integer> row10 = new ArrayList<>();
        ArrayList<Integer> row11 = new ArrayList<>();
        ArrayList<Integer> row12 = new ArrayList<>();
        ArrayList<Integer> row13 = new ArrayList<>();
        ArrayList<Integer> row14 = new ArrayList<>();
        ArrayList<Integer> row15 = new ArrayList<>();

        row1.add(75);
        row2.addAll(Arrays.asList(95, 64));
        row3.addAll(Arrays.asList(17, 47, 82));
        row4.addAll(Arrays.asList(18, 35, 87, 10));
        row5.addAll(Arrays.asList(20, 4, 82, 47, 65));
        row6.addAll(Arrays.asList(19, 1, 23, 75, 3, 34));
        row7.addAll(Arrays.asList(88, 2, 77, 73, 7, 63, 67));
        row8.addAll(Arrays.asList(99, 65, 4, 28, 6, 16, 70, 92));
        row9.addAll(Arrays.asList(41, 41, 26, 56, 83, 40, 80, 70, 33));
        row10.addAll(Arrays.asList(41, 48, 72, 33, 47, 32, 37, 16, 94, 29));
        row11.addAll(Arrays.asList(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14));
        row12.addAll(Arrays.asList(70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57));
        row13.addAll(Arrays.asList(91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48));
        row14.addAll(Arrays.asList(63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31));
        row15.addAll(Arrays.asList( 4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23));

        row14 = Util.trianglePath(row14, row15);
        row13 = Util.trianglePath(row13, row14);
        row12 = Util.trianglePath(row12, row13);
        row11 = Util.trianglePath(row11, row12);
        row10 = Util.trianglePath(row10, row11);
        row9 = Util.trianglePath(row9, row10);
        row8 = Util.trianglePath(row8, row9);
        row7 = Util.trianglePath(row7, row8);
        row6 = Util.trianglePath(row6, row7);
        row5 = Util.trianglePath(row5, row6);
        row4 = Util.trianglePath(row4, row5);
        row3 = Util.trianglePath(row3, row4);
        row2 = Util.trianglePath(row2, row3);
        row1 = Util.trianglePath(row1, row2);

        value = Integer.valueOf(row1.get(0));

















        

    }
}
