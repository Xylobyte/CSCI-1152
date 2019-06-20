/*
Box: drawing a box out of '*' symbols
Donovan Griego
*/

import java.util.Scanner;

public class Box {
    public static void main(String args[]) {
        int width, height;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Please enter parameters for your box:\n");
        do {
            System.out.printf("Width: ");
            width = sc.nextInt();
            if(width <=0)
                System.out.printf("Invalid value. Please try again.\n");
        } while(width <=0);
        do {
            System.out.printf("Height: ");
            height = sc.nextInt();
            if(height <=0)
                System.out.printf("Invalid value. Please try again.\n");
        } while(height <=0);
        System.out.printf("Drawing your box now...\n");
        drawBox(width, height);
        System.out.printf("Your box was drawn successfully.\n");
    }

    public static void drawBox(int x, int y) {
        int place, i, line;
        
        
        for (line=1; line<=y; ++line){
                if(line == 1 || line == y){
                    for (i=1; i<=x; ++i){
                    System.out.printf("*");

                    }
                } else for(place = 1; place <=x; ++place){
                    if(place == 1 || place == x){
                        System.out.printf("*");
                    } else System.out.printf(" ");
                }
            System.out.printf("\n");
        }
    }
}