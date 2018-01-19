package Sorting;

public class ObjectSorter{
	
	public void bubble(Comparable[] values){
		
		int i;
		Comparable temp;
		boolean sorted = false;
		
		while(!sorted){
			sorted = true;
			for(i=0;i<values.length-1;i++){
				if(values[i].compareTo(values[i+1])>0){
					temp = values[i];
					values[i] = values[i+1];
					values[i+1] = temp;
					sorted = false;
				}
			}
		}
	}
	
	public void insertion(Comparable[] values){
		int i;
		int j;
		Comparable temp;
		for(i=1;i<values.length;i++){
			temp = values[i];
			for(j=i-1;j>=0;j--){
				if(values[j].compareTo(temp)>0){
					values[j+1] = values[j];
				}
				else{
					break;
				}
			}
			values[j+1] = temp;
		}
	}
	
	public void selectionSort(Comparable[] a){
		int checker = 0;
		Comparable temp;
		for(int i=0;i<a.length-2;i++){
			checker = i;
			for(int j=i+1; j<a.length; j++){
				if(a[i].compareTo(a[checker])<0)checker = j;
			}
			temp = a[i];
			a[i] = a[checker];
			a[checker] = temp;
		}
	}
	
}