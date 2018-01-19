package Sorting;
public class arrayUtility {

	public static void printArray(int values[]){
		for(int x=0;x<values.length;x++){
			System.out.print(values[x] + " ");
		}
		System.out.println();
	}

	public static int[] generateArray(int size){
		int values[] = new int[size];
		for(int i=0;i<size;i++){
			values[i] = (int) (Math.random()*101);
		}
		return values;
	}
}
