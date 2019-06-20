/*
Lab 1
Donovan Griego
*/

public class Lab1_dgriego125 {
    public static void main(String[] args) {
        float operand1 = 20.0f, operand2 = 99.0f, addResult, subResult, divResult, multResult;
        addResult = operand1 + operand2;
        subResult = operand2 - operand1;
        multResult = operand1 * operand2;
        divResult = operand2 / operand1;
        System.out.printf("Donovan Griego\n");
        System.out.printf("The addition result is : %.1f\n", addResult);
        System.out.printf("The subtraction result is : %.1f\n", subResult);
        System.out.printf("The multiply result is : %.1f\n", multResult);
        System.out.printf("The division result is : %.2f\n", divResult);
    }
}