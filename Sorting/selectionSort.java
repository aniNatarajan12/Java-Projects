package Sorting;


import java.util.Date;
import java.util.Scanner;

import Hpractice.dateTime;

public class selectionSort {

	public static void main(String[] args) {
		int values[] = arrayUtility.generateArray(20);
		arrayUtility.printArray(values);
		selectionSort(values);
		arrayUtility.printArray(values);
		selectionSortBack(values);
		arrayUtility.printArray(values);
	}
	
	public static void selectionSort(int[] values){
		int checker = 0;
		int smallNum = 0;
		int smallNumPlace = 0;
		for(int j=0;j<values.length;j++){
			smallNum = values[j];
			smallNumPlace = j;
			for(int i=j; i<values.length; i++){
				if((values[i]%10<smallNum%10) || (values[i]%10==smallNum%10 && values[i]<smallNum)){
					checker = smallNum;
					smallNum = values[i];
					smallNumPlace = i;
				}
			}
			if(checker!=smallNum){
				values[smallNumPlace] = values[j];
				values[j] = smallNum;
			}
		}
	}
	
	public static void selectionSortBack(int[] values){
		int checker = 0;
		int smallNum = 0;
		int smallNumPlace = 0;
		for(int j=0;j<values.length;j++){
			smallNum = values[j];
			smallNumPlace = j;
			for(int i=j; i<values.length; i++){
				if((values[i]%10>smallNum%10) || (values[i]%10==smallNum%10 && values[i]>smallNum)){
					checker = smallNum;
					smallNum = values[i];
					smallNumPlace = i;
				}
			}
			if(checker!=smallNum){
				values[smallNumPlace] = values[j];
				values[j] = smallNum;
			}
		}
	}


}