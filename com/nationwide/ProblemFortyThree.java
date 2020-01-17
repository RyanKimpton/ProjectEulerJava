package com.nationwide;

public class ProblemFortyThree implements Runnable {
    private long value;

    public long getValue() {
        return value;
    }

    public void run() {
        long[] pandigitals = Util.allPandigitalsZero(9);

        for (long pandigital : pandigitals) {
            long units = pandigital % 10;
            long tens = (pandigital % 100 - units) / 10;
            long hundreds = (pandigital % 1000 - tens) / 100;
            long thousands = (pandigital % 10000 - hundreds) / 1000;
            long tthousands = (pandigital % 100000 - thousands) / 10000;
            long hthousands = (pandigital % 1000000 - tthousands) / 100000;
            long millions = (pandigital % 10000000 - hthousands) / 1000000;
            long tmillions = (pandigital % 100000000 - millions) / 10000000;
            long hmillions = (pandigital % 1000000000 - tmillions) / 100000000;

            if (Util.joiner(new int[]{(int) hmillions, (int) tmillions, (int) millions}) % 2 != 0) {
                continue;
            }

            if (Util.joiner(new int[]{(int) tmillions, (int) millions, (int) hthousands}) % 3 != 0) {
                continue;
            }

            if (Util.joiner(new int[]{(int) millions, (int) hthousands, (int) tthousands}) % 5 != 0) {
                continue;
            }

            if (Util.joiner(new int[]{(int) hthousands, (int) tthousands, (int) thousands}) % 7 != 0) {
                continue;
            }

            if (Util.joiner(new int[]{(int) tthousands, (int) thousands, (int) hundreds}) % 11 != 0) {
                continue;
            }

            if (Util.joiner(new int[]{(int) thousands, (int) hundreds, (int) tens}) % 13 != 0) {
                continue;
            }

            if (Util.joiner(new int[]{(int) hundreds, (int) tens, (int) units}) % 17 != 0) {
                continue;
            }

            value += pandigital;
        }
    }
}
