package Sorting;

public class bubbleSort {

	public static void main(String[] args) {
		int values[] = arrayUtility.generateArray(30);
		arrayUtility.printArray(values);
		bubbleSort(values);
		arrayUtility.printArray(values);
		bubbleSortBack(values);
		arrayUtility.printArray(values);
	}

	public static void bubbleSort(int[] values){

		boolean sorted = false;
		int i,storage=0;
		while(!sorted){
			sorted = true;
			for(i=0;i<values.length-1;i++){
				if((values[i]%10>values[i+1]%10)||((values[i]%10==values[i+1]%10)&&(values[i]>values[i+1]))){
					storage = values[i];
					values[i] = values[i+1];
					values[i+1] = storage;
					sorted = false;
				}
			}
//			arrayUtility.printArray(values);
		}
	}
	
	public static void bubbleSortBack(int[] values){

		boolean sorted = false;
		int i,storage=0;
		while(!sorted){
			sorted = true;
			for(i=0;i<values.length-1;i++){
				if((values[i]%10<values[i+1]%10)||((values[i]%10==values[i+1]%10)&&(values[i]<values[i+1]))){
					storage = values[i];
					values[i] = values[i+1];
					values[i+1] = storage;
					sorted = false;
				}
			}

		}
	}
}
