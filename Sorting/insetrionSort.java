package Sorting;

public class insetrionSort {

	public static void main(String[] args) {
		int values[] = arrayUtility.generateArray(20);
		arrayUtility.printArray(values);
		insertionSort(values);
		arrayUtility.printArray(values);
		insertionSortBack(values);
		arrayUtility.printArray(values);
	}


	public static void insertionSort(int[] values){
		int i;
		int j;
		int temp;
		for(i=1;i<values.length;i++){
			temp = values[i];
			for(j=i-1;j>=0;j--){
				if((values[j]%10>temp%10)||(values[j]%10==temp%10 && values[j]>temp)){
					values[j+1] = values[j];
				}
				else{
					break;
				}
			}
			values[j+1] = temp;
		}
	}

	public static void insertionSortBack(int[] values){
		int i;
		int j;
		int temp;
		for(i=1;i<values.length;i++){
			temp = values[i];
			for(j=i-1;j>=0;j--){
				if((values[j]%10<temp%10)||(values[j]%10==temp%10 && values[j]<temp)){
					values[j+1] = values[j];
				}
				else{
					break;
				}
			}
			values[j+1] = temp;
		}
	}

}