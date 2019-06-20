/*
DWSum: calculate the sum of values in an array using a do-while loop.
Donovan Griego
*/

public class DWSum {
    public static void main(String args[]) {
        double[] values = {12, 22, 15, 36, -5, 42, 15, 20, -35, 103};
        final double asize = values.length;
        double sum=0;
        int i = 0;
        do {
            sum += values[i];
            i++;
        } while (i != asize);
        System.out.printf("Values sum to: %f\n", sum);
    }
}