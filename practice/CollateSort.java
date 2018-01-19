package jrJava.practice;

public class CollateSort {

	public static void main(String[] args) {
		int[] a = new int[]{5,8,2,3,11,9,15,14,4,1,6,10 };
		printArray(a);
		bubbleSort(a);
		printArray(a);
	}
	public static void printArray(int[] values){
		for(int i=0; i<values.length; i++){
			System.out.print(values[i]+ " ");
		}
		System.out.println();
	}
	
public static void bubbleSort(int[] a){
		
		boolean sorted = false;
		
		while(!sorted){
			for(int i=0; i<a.length-1; i=i+2){
				
				if(a[i]>a[i+1]){
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					sorted = false; 
				}
			}
			
		}
		
	}
}


		
	