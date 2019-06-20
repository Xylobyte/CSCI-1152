/*
ZeroDiv: Provide an appropriate exception for a dividing by zero error.
Donovan Griego
*/

public class ZeroDiv{
    public static void main(String args[]){
        int a = 1, b = 0, c;
        try {
            c = a / b;
        } catch (ArithmeticException e) {
            System.err.println("Recieved an Arithmetic Exception while dividing " + a + " by " + b + ".");
            System.err.println("Message: " + e.getMessage());
            System.err.println("String: " + e.toString());
            return;
        }
    }
}