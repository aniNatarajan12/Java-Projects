package jrJava.practice;

public class March19_2 {

	public static void main(String[] args) {
		
		int[] values = generateArray(100);
		int[] values2 = new int[100];
		printArray(values);
		Work(values, values2, 69);
		printArray(values2);
		
	}
	
	public static void Work(int[] a,int[] b,int num){
		int count = 0;
		int less = 0;
		int more = a.length-1;
		
		for(int i=0;i<a.length;i++){
			if(a[i]<num){
				b[less] = a[i];
				less++;
			}
			else if(a[i]==num){
				for(int j=0;j<a.length;j++){
					if(b[j]==0){
						b[j] = num;
					}
				}
			}
			else if(a[i]>num){
				b[more] = a[i]; 
				more--;
			}
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

}
