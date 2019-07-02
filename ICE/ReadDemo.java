/**
 * ReadDemo: Show opening and working with input and output streams.
 * @author Kenneth Ingham
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadDemo {

    /**
     * open the specified file, handling the exception. Exits on error.
     *
     * @param fname the file to open
     * @return a buffered reader for the specified file.
     */
    public static BufferedReader openRead(String fname) {
        BufferedReader r = null;
        try {
            r = new BufferedReader(new FileReader(fname));
        } catch (FileNotFoundException e) {
            System.err.println("Opening '" + fname + "' for reading Failed: "
                    + e.getMessage());
            System.exit(1);
        }
        /* 
         If we had not exited, we need to call r.close() in a finally
         block.  Unfortunately, close can thrown an IOException.  This gets messy.
         */
        return r;
    }

    /**
     * Open the specified file for writing, handling the exception. Exits on
     * error.
     *
     * @param fname the file to open
     * @return a PrintWriter connected to the specified file
     */
    public static PrintWriter openWrite(String fname) {
        PrintWriter w = null;
        try {
            w = new PrintWriter(new FileWriter(fname));
        } catch (FileNotFoundException e) {
            System.err.println("Opening '" + fname + "' for writing Failed: "
                    + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Opening '" + fname + "' for writing Failed: "
                    + e.getMessage());
            System.exit(1);
        }
        /* 
         If we had not exited, we need to call w.close() in a finally
         block.  Unfortunately, close can thrown an IOException.  This gets messy.
         */
        return w;
    }

    /**
     * Copy the input to the output.
     *
     * @param in a BufferedReader from which we read
     * @param out a PrintWriter to which we print the data.
     * @param outName Output file name for exception error message
     */
    public static void copy(BufferedReader in, PrintWriter out, String outName) {
        try {
            String line;
            while ((line = in.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Writing to '" + outName + "' Failed: "
                    + e.getMessage());
            System.exit(1);
        }
        /* 
         If we had not exited, we need to call in.close() and out.close()
         in a finally block.  Unfortunately, close can thrown an
         IOException.  This gets messy.
         */
    }

    /**
     * Close the input file, handling the exception.
     *
     * @param in the input BufferedReader to close
     * @param inName the name of the input file for exception messages
     */
    public static void inClose(BufferedReader in, String inName) {
        try {
            in.close();
        } catch (IOException e) {
            System.err.println("Closing '" + inName + "' Failed: "
                    + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Close the printWriter for output. This method exists for parallelism with
     * the input version.
     *
     * @param out the PrintWrtter to close
     * @param outName the file name corresponding to out for error messages
     */
    public static void outClose(PrintWriter out, String outName) {
        out.close(); // oddly, this does not throw an exception.
        // Takeaway: You have to know the methods you use and when they can 
        // throw an exception and under what circumstances.
    }

    /** 
     * Get the name of the main class for error message production.
     * @return the class name for main.
     */
    public static String mainName() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement main = stack[stack.length - 1];
        return main.getClassName();
    }

    public static void main(String[] args) {
        final int nargs = 2;
        if (args.length != nargs) {
            System.err.printf("Incorrect argument count (%d) should be %d\n",
                args.length, nargs);
            System.err.println("Usage: java " + mainName() + " infile outfile");
            System.exit(1);
        }

        // Open
        BufferedReader infile = openRead(args[0]);
        PrintWriter outfile = openWrite(args[1]);

        // Showing that Scanner can use a BufferedReader
        // Then you can use the Scanner utilities to do input.
        //Scanner in = new Scanner(infile);

        // Copy
        copy(infile, outfile, args[1]);

        // Close.  This is important!
        inClose(infile, args[0]);
        outClose(outfile, args[1]);
    }
}