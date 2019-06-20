/*
Lab2: Calculating taxes.
Donovan Griego
*/

import java.util.Scanner;

public class Lab2_dgriego125 {
    public static void main (String args[]) {
        int exemp;
        double grossSal, intIn, capGain, charity, totalIn, adjIn, totalTax=5;
        Scanner sc = new Scanner(System.in);
        
        do {
        System.out.printf("Number of Exemptions: ");
        exemp = sc.nextInt();
        if (exemp < 0)
            System.out.printf("Invalid number. Please try again.\n");
        } while (exemp < 0);
        System.out.printf("Gross Salary: ");
        grossSal = sc.nextDouble();
        System.out.printf("Interest Income: ");
        intIn = sc.nextDouble();
        System.out.printf("Capital Gains: ");
        capGain = sc.nextDouble();
        System.out.printf("Charitable Contributions: ");
        charity = sc.nextDouble();

        totalIn = grossSal + intIn + capGain;
        adjIn = totalIn - (exemp * 1500.00) - charity;
        if(adjIn <= 10000)
            totalTax = 0;
        else
            if(adjIn <= 32000 && adjIn > 10000)
                totalTax = 0.15 * (adjIn - 10000);
            else
                if(adjIn <= 50000)
                    totalTax = (0.15 * (32000 - 10000)) + (0.23 * (adjIn - 32000));
                else
                    if(adjIn >50000)
                        totalTax = (0.15 * (32000 - 10000)) + (0.23 * (50000 - 32000)) + (0.28 * (adjIn - 50000));

        
        System.out.printf("Total Income:     $%.2f\n", totalIn);
        System.out.printf("Adjusted Income:  $%.2f\n", adjIn);
        System.out.printf("Total Tax:        $%.2f\n", totalTax);
    }
}