package jrJava.usingInterface;

import java.util.ArrayList;

public class Test {

	
	public static void main(String[] args) {
		
		ArrayList<JavaTeacher> javaTeachers = new ArrayList<JavaTeacher>();
		ArrayList<Husband> husbands = new ArrayList<Husband>();
		ArrayList<Father> fathers = new ArrayList<Father>();
		
		
		Husband ref = new Programmer("Sir", 10);
		/*
		javaTeachers.add(ref);
		husbands.add(ref);
		fathers.add(ref);
		*/
		
		if(ref instanceof Programmer){
			System.out.println("Yes, it is");
		}
		else {
			System.out.println("No, it is not.");
		}
		
	}

}
