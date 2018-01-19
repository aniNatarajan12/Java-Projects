package jrJava.Algorithm;

public class Wk2 {
	
	public static void main(String[] args) {

	}
	
	// P1:
	public static boolean isEvenNumber(int number){
		return (number % 2) == 0;
	}
	
	
	// P2:
	public static boolean isOddNumber(int number){
		return (number % 2 == 1);
	}
	
	
	// P3:
	public static int countNumbersGreaterThan(int[] values, int threshold){
		int count = 0;
		for(int i=0; i<values.length; i++){
			if(values[i] > threshold){
				count ++;
			}
		}
		return count;
	}
	
	
	// P4:
	public static int sumOfNumberLessThan(int[] values, int threshold){
		int sum = 0;
		for(int i=0; i<values.length; i++){
			if(values[i] < threshold){
				sum = sum + values[i];
			}
		}
		return sum;
	}
	
	
	// P5:
	public static int countEvenNumbers(int[] values){
		int count = 0;
		for(int i=0; i<values.length; i++){
			if((values[i] % 2) == 0){
				count ++;
			}
		}
		return count;
	}
	
	
	// P6:
	public static int sumOfOddNumbers(int[] values){
		int sum = 0;
		for(int i=0;i<values.length;i++){
			if((values[i] % 2) != 0){
				sum = sum + values[i];
			}
		}
		return sum;
	}
	
	
	// P7:
	public static boolean betweenTwoNumbers(int number, int lowerLimit, int upperLimit){
		
		if(number>lowerLimit && number<upperLimit){
			return true;
		}
		return false;
	}
	
	
	// P8:
	public static boolean outsideTwoNumbers(int number, int lowerLimit, int upperLimit){
		
		if(number<lowerLimit || number>upperLimit){
			return true;
		}
		return false;
	}
	
	// P9:
	public static boolean[] andBooleanArrays(boolean[] values1, boolean[] values2){
		if(values1.length != values2.length){
			return null;
		}
		
		boolean[] values = new boolean[values1.length];
		
		for(int i=0;i<values1.length;i++){
			values[i] = values1[i] && values2[i];
		}
		return values;
	}
	
	
	// P10:
	public static boolean[] orBooleanArrays(boolean[] values1, boolean[] values2){
		if(values1.length != values2.length){
			return null;
		}
		
		boolean[] values = new boolean[values1.length];
		
		for(int i=0;i<values1.length;i++){
			values[i] = values1[i] || values2[i];
		}
		return values;
	}
}
