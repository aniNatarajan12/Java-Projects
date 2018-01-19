package Sorting;

public class comparablesTest {

	public static void main(String[] args) {
		
//		Ball[] objs = new Ball[]{
//				new Ball(100, 101, 10, 21, 21, 22),
//				new Ball(100, 101, 12, 20, 21, 22),
//				new Ball(100, 101, 10, 20, 21, 22),
//				new Ball(100, 101, 11, 20, 21, 22),
//				new Ball(100, 101, 19, 21, 21, 22),
//				new Ball(100, 101, 13, 20, 21, 22),
//				new Ball(100, 101, 15, 21, 21, 22),
//				new Ball(100, 101, 17, 20, 21, 22),
//				new Ball(100, 100, 12, 21, 21, 22),
//				new Ball(100, 101, 16, 20, 21, 22),
//				new Ball(100, 101, 20, 21, 21, 22),
//				new Ball(100, 101, 11, 20, 22, 22),
//		};
		
		String[] objs = new String[]{"pranav","aman","yousuf","pooja","ishaan",
									 "kevin","alan","pranav2","nachiket","anirudh",
									  "nyna","alex","seddesh","sarang","ashwin"};
		
		ObjectSorter sorter = new ObjectSorter();
		printArray(objs);
		sorter.bubble(objs);
		printArray(objs);
	}
	
	public static void printArray(Object[] values){
		for(int x=0;x<values.length;x++){
			values[x].toString();
		}
		System.out.println();
		System.out.println();
	}

}
