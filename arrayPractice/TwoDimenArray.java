package jrJava.arrayPractice;

public class TwoDimenArray{
	public static void main(String[] args){
		
		int[][] a = new int[5][];
		
		a[0] = new int[5];
		a[1] = new int[4];
		a[2] = new int[3];
		a[3] = new int[2];
		a[4] = new int[1];
		a[4][0] = 7;
		
		printAll(a);
		shiftUp(a);
		printAll(a);
	}
	
	public static void printAll(int[][] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void shiftUp(int[][] a){
		int i,j;
		int temp = a[0][0];
		
		for(i=0;i<a.length;i++){
			for(j=0;j<=a[i].length-2;j++){
				a[i][j] = a[i][j+1];
			}
			if(i!=a.length-1) a[i][a[i].length-1] = a[i+1][0];
			else a[i][a[i].length-1] = temp;
		}
	}
}
