package jrJava.practice;

public class TwoDimenArray {

	public static void main(String[] args) {
		int[] [] a= new int [4][];

		a[0] = new int[]{5,7,6};
		a[1] = new int[]{11,15,19,12};
		a[2] = new int[]{4,7};
		a[3] = new int[]{9};

		int[][] b = new int[][]{ new int[]{5,7,6}, new int[] {11,15,19,12}, new int[]{4,7}, new int[]{9}};

		System.out.println(a[3][0]);
		
		System.out.println(sum(a));
			
		}
	public static int sum(int[][] values){
		
		int sum = 0;
		
		for(int i=0; i<values.length; i++){
			for(int j=0; j<values[i].length; j++){
				sum+= values[i][j];
			}
			
		}
		return sum;
	}


}
