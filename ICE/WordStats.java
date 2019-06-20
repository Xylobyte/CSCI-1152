/*
Word Stats: Print out stats of words given by user
Donovan Griego
*/

import java.util.Scanner;

public class WordStats {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] words = new String[10];
        String longest = "initiallized", shortest = "initiallized";
    int lessFour = 0, fiveToEight = 0, moreEight = 0, mostLetters = 0, leastLetters = 200000;       //least letters needs to be initiallized to a big number to prevent breaking
        final double asize = words.length;

        System.out.printf("Please enter ten words:\n");
        System.out.printf("-----------------------\n");
        for (int i = 0; i < asize; ++i) {
            words[i] = sc.nextLine();
            if (lessFour(words[i]) == true)     //less than four letters check
                lessFour++;
            if (fiveToEight(words[i]) == true)      //five to eight letters check
                fiveToEight++;
            if (moreEight(words[i]) == true)     //more than eight letters check
                moreEight++;
            if (words[i].length() > mostLetters) {      //longest letter check
                longest = words[i];
                mostLetters = words[i].length();
            }
            if (words[i].length() < leastLetters) {     //shortest letter check
                shortest = words[i];
                leastLetters = words[i].length();
            }
        }
        System.out.printf("-----------------------\n");
        System.out.printf("Words with four or less letters: %d\n", lessFour);
        System.out.printf("Words with between 5 and 8 letters: %d\n", fiveToEight);
        System.out.printf("Words with mroe than eight letters: %d\n", moreEight);
        System.out.printf("The shortest word was: '%s'\n", shortest);
        System.out.printf("The longest word was: '%s'\n", longest);
    }

    public static boolean lessFour(String word){
        if (word.length() <= 4)
            return true;
        else
            return false;
    }
    public static boolean fiveToEight(String word){
        if (word.length() <= 8 && word.length() >= 5)
            return true;
        else
            return false;
    }
    public static boolean moreEight(String word){
        if (word.length() > 8)
            return true;
        else
            return false;
    }
}

