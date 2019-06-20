/*
fact: calculate the factorial of an integer
Donovan Griego
*/

import java.util.Scanner;

public class fact {
    public static void main (String args[]){
        int solution, number;
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("Please enter an integer: ");
        number = sc.nextInt();
        solution = factorial(number);

        System.out.printf("%d! = %d\n", number, solution);
    }

    public static int factorial(int number){
        int solution = number, i;
        
        for (i=solution - 1; i>0; --i){
            solution *= i;
        }
        return solution;
    }
}