package jrJava.greeting;

import java.util.Scanner;

public class HelloThere {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in) ;
		
		System.out.println("Type in your first name and press the enter key");
		String TheFirstName = scanner.next();
		
		System.out.println("Type in your last name and press the enter key");
		String TheLastName = scanner.next();
		
		System.out.println("Type in your grade and press the enter key");
		int TheGrade = scanner.nextInt();

		System.out.println("Well, your name is " + TheFirstName + " " + TheLastName + " and you are in " + TheGrade + "th grade.");

	}

}
