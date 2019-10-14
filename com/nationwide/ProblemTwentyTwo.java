package com.nationwide;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProblemTwentyTwo implements Runnable {
    private int value;

    public long getValue() {
        return value;
    }

    public void run() {
        Scanner in = null;
        ArrayList<String> text = new ArrayList<>();
        int counter;
        String temp;


        try {
            in = new Scanner(new File("C:\\Users\\admin\\Documents\\p022_names.txt")).useDelimiter("[\",]+");
        } catch (FileNotFoundException e) {
            System.out.println("Problem finding the file to read from");
        }

        assert in != null;

        while (in.hasNext()) {
            text.add(in.next());
        }

        Collections.sort(text);

        for( int i = 0; i < text.size(); i++){
            counter = 0;
            temp = text.get(i);

            for(int j = 0; j < temp.length(); j++){
                counter +=  Character.getNumericValue(temp.charAt(j)) - 9;
            }



            value += (i+1) * counter;
        }
    }
}
