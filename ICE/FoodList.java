import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * A small demo showing List operations
 *
 * @author Kenneth Ingham
 */
public class FoodList {

    /**
     * Read a collection of Strings (one per line) and return an ArrayList of
     * them.
     *
     * @param fname The file to read
     * @return an array of the integers read from fname
     */
    public static ArrayList<String> readStrings(String fname) {
        ArrayList<String> lines = new ArrayList<>();
        Scanner in = new Scanner(openRead(fname));
        while (in.hasNext()) {
            lines.add(in.nextLine());
        }
        in.close();
        return lines;
    }

    /**
     * Read a single string from in after printing the prompt. Exits if we
     * cannot read a string.
     *
     * @param in the Scanner to read from
     * @param prompt What to print before trying to get the string
     * @return the string read
     */
    public static String readString(Scanner in, String prompt) {
        System.out.print(prompt);
        if (in.hasNext()) {
            return in.nextLine();
        } else {
            System.err.println("No input available when trying to read "
                    + "a string from " + in.toString());
            System.exit(1);
        }
        /*NOTREACHED*/
        return null;
    }

    /**
     * Use an iterator to print the elements in a List. The code is general and
     * will work with ArrayList or LinkedList.
     *
     * @param lines a List of strings
     */
    public static void printList(List<String> list) {
        ListIterator<String> iter = list.listIterator();
        while (iter.hasNext()) {
            String s = iter.next();
            System.out.print(s);
            if (iter.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // Error checking for usage
        final int nargs = 1;
        if (args.length != nargs) {
            System.err.printf("Incorrect argument count (%d) should be %d\n",
                    args.length, nargs);
            System.err.println("Usage: java " + mainName() + " infile");
            System.exit(1);
        }

        ArrayList<String> foods = readStrings(args[0]);
        printList(foods);

        Scanner in = new Scanner(System.in);
        //while (in.hasNext()) {
        while (true) {
            System.out.print("Command: (a)dd, (d)elete, (s)earch, or (e)xit: ");
            String cmd = in.nextLine();
            if (cmd.length() != 1) {
                System.out.println("The input '" + cmd + "' is invalid.");
                System.out.println("Enter only the first letter of the command (a, d, or s).");
            } else {
                switch (cmd.charAt(0)) {
                    case 'a':
                        foods.add(readString(in, "Enter the new food: "));
                        break;
                    case 'd':
                        String toDel = readString(in, "Enter the food to delete: ");
                        if (foods.remove(toDel)) {
                            System.out.println("Successfully removed " + toDel);
                        } else {
                            System.out.println("'" + toDel
                                    + "' was not found in the list.");
                            System.out.print("List contains: ");
                        }
                        break;
                    case 's':
                        String toFind = readString(in, "Enter the food to search for: ");
                        int loc = foods.indexOf(toFind);
                        if (loc >= 0) {
                            System.out.println("'" + toFind
                                    + "' was found at index " + loc);
                        } else {
                            System.out.println("'" + toFind
                                    + "' was not found.");
                        }
                        break;
                    case 'e':
                        System.exit(0);
                    default:
                        System.out.println("The input '" + cmd
                                + "' is invalid.");
                        System.out.println("Enter only the first letter of "
                                + "the command (a, d, or s).");
                }
                printList(foods);
            }
        }
    }

    /* Below this, methods are identical to earlier examples */
    /**
     * Get the name of the main class for error message production.
     *
     * @return the class name for main.
     */
    public static String mainName() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement main = stack[stack.length - 1];
        return main.getClassName();
    }

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
}