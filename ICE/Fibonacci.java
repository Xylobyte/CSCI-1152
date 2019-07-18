/**
 * Recursive calculation of the Fibonacci number.  F(n) = F(n-1) + F(n-2)
 *
 * @author Kenneth Ingham
 */

public class Fibonacci {

    static int F(int n) {
        if (n < 0) {
            String msg = String.format("Fibonacci got %d ", n);
            msg += "but cannot work with negative values";
            throw new IllegalArgumentException(msg);
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        return F(n-1) + F(n-2);
    }

    static public void main(String[] args) {
        final int max = 10;
        for (int n=0; n<max; ++n) {
            int fib = F(n);
            System.out.println("Fibonacci number (" + n + ") = " + fib);
        }
    }
}