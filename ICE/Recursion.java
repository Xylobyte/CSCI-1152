/**
 * Simple recursion demonstration
 *
 * @author Kenneth Ingham
 */

public class Recursion {

    static int recurseSum(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    String.format("recurseSum got %d but cannot work with negative values", n));
        }
        System.out.println("RecurseSum: n is " + n);
        if (n == 0) {
            System.out.println("RecurseSum: returning 0");
            return 0;
        }
        
        int recursiveValue = recurseSum(n - 1);
        System.out.println("RecurseSum: recursive call returned " + recursiveValue);
        int result = n + recursiveValue;
        System.out.println("RecurseSum: returning " + result);
        return result;
    }

    static public void main(String[] args) {
        final int top = 10;
        int sum = recurseSum(top);
        System.out.println("recurseSum(" + top + ") = " + sum);
    }
}