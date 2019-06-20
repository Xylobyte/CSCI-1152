/*
ArrayAvg: calculate the sum and average of values in an array.
Donovan Griego
*/

public class ArrayAvg {
    public static void main(String args[]) {
        double[] values = {12, 22, 15, 36, -5, 42, 15, 20, -35, 103};
        final double asize = values.length;
        double sum=0, avg;

        for (int i = 0; i < asize; ++i) {
            sum += values[i];
        }
        avg = sum / asize;
        System.out.printf("Values sum: %f average: %f\n", sum, avg);
    }
}