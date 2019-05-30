/*
kmtomi: convert kilometers to miles from input.
Donovan Griego
*/

import java.util.Scanner;

public class kmtomi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double mi, km;
		System.out.printf("Enter the kilometers to convert: ");
		km = sc.nextDouble();
		mi = 0.6213719224 * km;
		System.out.printf("Kilometers: %.2f Miles: %.2f\n", km, mi);
	}
}