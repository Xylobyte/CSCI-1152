/*
ArraySort: sorts a list of numbers in decending order, then prints min and max.
DOnovan Griego
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ArraySort {
    public static void inClose(BufferedReader in, String inName) {
        try {
            in.close();
        } catch (IOException e) {
            System.err.println("Closing '" + inName + "' Failed: "
                    + e.getMessage());
            System.exit(1);
        }
    }
    
    public static BufferedReader openRead(String fname) {
        BufferedReader r = null;
        try {
            r = new BufferedReader(new FileReader(fname));
        } catch (FileNotFoundException e) {
            System.err.println("Opening '" + fname + "' for reading Failed: " + e.getMessage());
            System.exit(1);
        }
        return r;
    }

    public static void main(String[] args) {
        String fname = "randomfloat.txt";
        BufferedReader file = openRead(fname);
        ArrayList<Double> list = new ArrayList<>();

        Scanner in = new Scanner(file);

        while (in.hasNext()) {
            list.add(in.nextDouble());
        }
        
        Comparator c = Collections.reverseOrder();
        Collections.sort(list, c);
        System.out.println("Min = " + list.get(list.size()-1));
        System.out.println("Max = " + list.get(0));
        inClose(file, fname);
    }
}
