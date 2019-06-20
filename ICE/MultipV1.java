/*
MultipV1: print out the mutliples of 3 from 0 - 15 inclusive
Donovan Griego
*/

public class MultipV1 {
    public static void main(String args[]) {
        int i;

        System.out.printf("The multiples of 3 between 0 and 15 are:");
        for (i=0; i <=15; ++i) {
            if (i%3 == 0)
                System.out.printf(" %d", i);
        }
        System.out.printf("\n");
    }
}