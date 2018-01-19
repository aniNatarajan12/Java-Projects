package jrJava.greeting;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		
		System.out.println("What's your name? Type it in.");
		
		Scanner myFirstScanner = new Scanner(System.in);
		String name = myFirstScanner.next();
		
		int mathScore;
		int scienceScore;
		int sum; 
		
		mathScore = 65;
		scienceScore = 37;
		
		sum = mathScore + scienceScore;
		
		System.out.println("The sum for " + name + " is " + sum);

	}

}
