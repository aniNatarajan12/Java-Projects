package jrJava.Algorithm;

import java.awt.Color;

public class Wk1 {
	
	public static void main(String[] args) {

	}
	
	// P1:

	public static void printData(int[] values){
		for(int i=0;i<values.length;i++){
			System.out.print(values[i] + " ");
		}
	}

	//P2:

	public static boolean allEqual(int a, int b, int c){
		if(a==b){
			if(b==c){
				return true;
			}
		}
		return false;
	}

	//P3:

	public static int sum(int[] values){
		int sum = 0;
		for(int i=0;i<values.length;i++){
			sum += values[i];
		}
		return sum;
	}

	//p4:

	public static double average(int[] values){
		double average = 0;
		for(int i=0;i<values.length;i++){
			average += values[i];
		}
		average /= values.length;
		return average;
	}

	//P5: 

	public static boolean allTrue(boolean[] values){
		for(int i=0;i<values.length;i++){
			if(values[i]==false){
				return false;
			}
		}
		return true;
	}

	//P6:

	public static boolean allFalse(boolean[] values){
		for(int i=0;i<values.length;i++){
			if(values[i]==true){
				return false;
			}
		}
		return true;
	}

	//P7:

	public static boolean copyArray(int[] values1, int[] values2){
		if(values1.length>values2.length){
			return false;
		}
		for(int i=0;i<values1.length;i++){
			values1[i] = values2[i];
		}
		return true;
	}

	//P8:

	public static void addAllBy(int[] values, int numberToAdd){
		for(int i=0;i<values.length;i++){
			values[i] += numberToAdd;
		}
	}

	//P9:

	public static void substractAllBy(int[] values, int numberToSubtract){
		for(int i=0;i<values.length;i++){
			values[i] -= numberToSubtract;
		}
	}

	//P10:

	public static void squareAll(int[] values){
		for(int i=0;i<values.length;i++){
			values[i] = (int) Math.pow(values[i], 2);
		}
	}
}
