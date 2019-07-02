/*
StrMethods: manipulating strings given to explore possible string functions.
Donovan Griego
*/

public class StrMethods {

    public static String middleThree(String word) {
        int index =1;
        String result="initialized";
        if(word.length()%2 == 1){
            index = (int)(Math.ceil(word.length()/2f)) - 2;    //finding the starting index of the three middle characters
            result = word.substring(index, index + 3);
        }else
            result = ("Can't be given from a word of even length");
            
        return result;
    }

    public static String lastTwo(String word){
        int index=1;
        char first='a', second='a';
        String modified="mod", result="initialized";

        index = word.length() - 2;    //finding the starting index of the last two charaters;
        first = word.charAt(index);
        second = word.charAt(index + 1);
        modified = word.substring(0, index);
        result = modified + second + first;
        return result;
    }

    public static boolean xyBalance(String word){
        int pos;
        boolean xSeen = false, xBalanced = false;
        
        for(pos=0; pos <= word.length() - 1; ++pos){
            if(word.charAt(pos) == 'x'){
                xSeen = true;
                xBalanced = false;
            }
            if(word.charAt(pos) == 'y'){
                xBalanced = true;
            }
        }
        if((xSeen == true && xBalanced == true) || xBalanced == true)
            return true;
        else
            return false;
    }

    public static void main(String args[]) {
        final int numargs = 1;
        if (args.length != numargs) {
            System.err.printf("Incorrect argument count (%d) should be %d\n", args.length, numargs);
            System.err.println("Usage: 'java StrMethods [word]'");
            System.exit(1);
        }

        String word=args[0];
        System.out.println("Word: '" + word + "'");
        System.out.println("Middle Three: " + "'" + middleThree(word) + "'");
        System.out.println("Last Two: " + "'" + lastTwo(word) + "'");
        System.out.println("X-Y-Balanced: " + "'" + xyBalance(word) + "'");
    }
}