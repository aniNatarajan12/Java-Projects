package jrJava.recursion;

public class CalculationsByRecursion {

	public static void main(String[] args) {

		System.out.println(sum(10));		
	}

	public static int sum(int n){
		if(n==1) return 1;
		return sum(n-1)+n;

	}

	public static int factorial(int n){
		if(n==1) return 1;
		return n*factorial(n-1);
	}
	
	public static double geoSum(double base, int n){
		if(n==0) return 1;
		return geoSum(base, n-1) + Math.pow(base, n);
	}

}
