package jrJava.practice;

public class CharSort {

	public static void main(String[] args){ 
		char[] a = new char[]{ 'c', 'n', 'a', 'b', 'p'};
		printArray(a);
		bubbleSort(a);
		printArray(a);
	}
	public static void printArray(char[] values){
		for(int i=0; i<values.length; i++){
			System.out.print(values[i]+ " ");
		}
		System.out.println();
	}
public static void bubbleSort(char[] a){
		
		boolean sorted = false;
		
		while(!sorted){
			for(int i=0; i<a.length-1; i++){
				
				if(a[i]>a[i+1]){
					char temp = (char) a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					sorted = false; 
				}
			}
			
		}
		
	}

}