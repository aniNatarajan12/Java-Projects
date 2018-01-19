package jrJava.practice;

public class Sorting {

	public static void main(String[] args) {
		int[] a = generateArray(20);
		printArray(a);
		insertSort(a);
		printArray(a);
		
	}
	
	public static void selectSort(int[] values){
		int i, j, mIndex, temp;
		for(i=0; i<values.length-1; i++){
			mIndex = i;
			for(j=i+1; j<values.length; j++){
				if(values[j]> values[mIndex]) mIndex = j;
			}
			temp = values[i];
			values[i] = values[mIndex];
			values[mIndex] = temp;
		}
	}
	
	public static void insertSort(int[] values){
		int i, j, key;
		
		for(i=1; i<values.length; i++){
			
			key = values[i];
			for(j=i-1; j>=0; j--){
				if(values[j]>key) values[j+1] = values[j];
				else break;
			}
			values[j+1] = key;
		}
	}
	
	public static int[] generateArray(int size){
		
		int[] values = new int[size];
		for(int i=0; i<values.length; i++){
			values[i] = (int) (Math.random()*100);
		}
		
		
		return values;
	}
	public static void printArray(int[] values){
		for(int i=0; i<values.length; i++){
			System.out.print(values[i]+ " ");
		}
		System.out.println();
	}
	
	public static void bubbleSort(int[] values){
		
		boolean sorted = false;
		
		while(!sorted){
			for(int i=0; i<values.length-1; i++){
				
				if(values[i]>values[i+1]){
					int temp = values[i];
					values[i] = values[i+1];
					values[i+1] = temp;
					sorted = false; 
				}
			}
			
		}
		
	}

}
