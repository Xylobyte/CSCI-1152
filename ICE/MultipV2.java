/*
MultipV2: print out the mutliples of 3 from 0 - 15 inclusive using a while statement
Donovan Griego
*/

public class MultipV2 {
    public static void main(String args[]) {
        int i=-3;
        
        System.out.printf("The multiples of 3 between 0 and 15 are:");
        while (i != 15) {
            i += 3;
            if(i %3 == 0)
                System.out.printf(" %d", i);
        }
        System.out.printf("\n");
    }
}