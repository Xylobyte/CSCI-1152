/*
CharCount: Count occurrences of characters in a file
Donovan Griego
*/


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.io.IOException;

public class CharCount {

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
            System.err.println("Opening '" + fname + "' for reading Failed: "
                    + e.getMessage());
            System.exit(1);
        }

        return r;
    }
    public static void main(String[] args) throws Exception {
        final int nargs = 1;
        if (args.length != nargs) {
            System.err.printf("Incorrect argument count (%d) should be %d\n",
                    args.length, nargs);
            System.err.println("Usage: java CharCount" + " infile");
            System.exit(1);
        }
        String fname = args[0];

        BufferedReader file = openRead(fname);
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        Scanner scanner = new Scanner(openRead(fname));
        while (scanner.hasNext()) {
            char[] chars = scanner.nextLine().toLowerCase().toCharArray();
            for (Character c : chars) {
                if (hashMap.containsKey(c)) {
                    hashMap.put(c, hashMap.get(c) + 1);
                } else {
                    hashMap.put(c, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
        inClose(file, fname);
    }
}