package jrJava.practice;

public class PreAndPost {

	public static void main(String[] args) {

		int a,b;
		
		a=5;
		b=a++ + ++a;
		
		System.out.println(a);
		System.out.println(b);
	}

}
