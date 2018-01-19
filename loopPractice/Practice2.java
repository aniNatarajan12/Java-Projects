package jrJava.loopPractice;

import java.util.Scanner;

public class Practice2 {


	public static void main(String[] args) {

		int sum = 0;
		for(int i=1; i<=100; i++){
			sum = sum + i*(i+1);
		}
		System.out.println(sum);
	}

}
