/*
EvenInt: print all of the even integers in a list.
Donovan Griego
*/

public class EvenInt {
    public static void main(String[] args) {
        int i;
        int[] list = { -234, -456, -9807, -67, -928346, -37864, -398475, -23746, -3, -4879};
        
        System.out.printf("Even Integers:\n");
        for (i=0; i<list.length; ++i)  {
            if (list[i] % 2 == 0)
                System.out.println(list[i]);
        }
    }
}