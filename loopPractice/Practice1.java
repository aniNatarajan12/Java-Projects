package jrJava.loopPractice;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {

		Scanner in = new Scanner (System.in) ;

		System.out.println("When I think of you, I think ");
		
		System.out.println("How many times are you awesome?");
		int num = in.nextInt();
		
		for(int i=1; i<=num; i++){
			//System.out.println("You are awesome!");
		}

		System.out.println("That's true.");

	}

}
