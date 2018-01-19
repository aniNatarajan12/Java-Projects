package jrJava.practice;

public class ShiftAndSwap {

	public static void main(String[] args) {
		
		int[] a = new int[]{1,2,3,4,5,6};
		printArray(a);
		swap(a);
		printArray(a);
		



	}
	
	public static void printArray(int[] values){
		for(int i=0; i<values.length; i++){
			int temp = values[i];
			values[i] = values[values.length-1-i];
			values[i] = values[values.length-1-i];

		}
	}
	
	
	
	
	public static void swap(int[] values){
		for(int i=0; i<values.length; i++){
			System.out.print(values);
		} 
		
		values[0] = values[values.length-1];
	}
	
	public static void shiftRight(int[]values){
		int temp = values[values.length-1];
		for(int i=values.length-2; i>=0; i--){
			values[i+1] = values[i];
			
		}
		values[0] = temp;
		
	}
	public static void shiftLeft(int[]values){
		
	}
}
