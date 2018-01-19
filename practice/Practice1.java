package jrJava.practice;

public class Practice1 {

	public static void main(String[] args) {
		
		
		System.out.println( equal(4,6));
	}
	
		public static boolean equal(int a, int b){
			return a==b;
		
	}
		public static boolean equal(int a, int b, int c){
			return a==b && b==c;
		}
		
		public static int sum(int[] values){
			
			int sum= 0;
			for(int i=0; i<values.length; i++){
				sum = sum + values[i];
			}
			return sum;
			
		}
		
		public static int sumEvens(int[] values){
			int sum = 0;
			for(int i=0; i<values.length; i++){
				if(values[i]%2==0) 
					sum +=values[i];
			}
			return sum;
		}
		
		public static int min(int[] values){
			int min = Integer.MAX_VALUE;
			for(int i=0; i<values.length; i++){
				if(values[i]<min){
					min = values[i];
				}
			}
			return min;
		}

}
