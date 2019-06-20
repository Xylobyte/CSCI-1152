/*
VorC: check to see if a character is a vowel or a consonant.
Donovan Griego
*/

public class VorC {
    public static void main(String[] args) {
        char letter = 'e';
        switch (letter) {
            case 'a' :
            case 'e' :
            case 'i' :
            case 'o' :
            case 'u' : System.out.printf("%c is a vowel", letter); break;
            default : System.out.printf("%c is a consonant", letter);
        }
    }
}