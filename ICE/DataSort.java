
/*
arraySort: sort a list of numbers
Donovan Griego
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.IllegalFormatConversionException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataSort {
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
    public static void main(String args[]) {
        boolean b, isInt=true, isDouble=true, isBoolean=true;
        int i;
        double d;
        String str= "initiallized";
        char c;
        final int numargs = 1;
        if (args.length != numargs) {
            System.err.printf("Incorrect argument count (%d) should be %d\n", args.length, numargs);
            System.err.println("Usage: 'java DataSort [file]'");
            System.exit(1);
        }

        BufferedReader file = openRead(args[0]);

        Scanner in = new Scanner(file);
        if(in.hasNextLine() == false)
            System.err.printf("'%s' is empty.\nFile can not be empty!\n", args[0]);
        outer:
        while (in.hasNextLine()) {
            isDouble=true; isInt=true; isBoolean=true;
            try {
                i = in.nextInt();
                System.out.printf("'%d' is an integer\n", i);
                continue outer;
            } catch(InputMismatchException e) {isInt = false;}
            try {
                d = in.nextDouble();
                System.out.printf("'%f' is a double\n", d);
                continue outer;
            } catch(InputMismatchException e) {isDouble = false;}
            
            try {
                b = in.nextBoolean();
                System.out.printf("'%b' is a boolean\n", b);
                continue outer;
            } catch(InputMismatchException e) {isBoolean = false;}
            if(isBoolean==false && isDouble==false && isInt==false){
                try {
                    str = in.nextLine();
                    if(str.length() >1){
                        System.out.printf("'%s' is a string\n", str);
                    } else{
                        c=str.charAt(0);
                        System.out.printf("'%c' is a character\n", c);
                    }
                } catch(InputMismatchException e) {
                    System.err.printf("Data '%s' is not able to be identified.\nPlease use valid data types!\n", str);
                }
            }
            
        }
        inClose(file, args[0]);
    }
}