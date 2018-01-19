package jrJava.LinkedListPractice;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.displayAll();
		
		list.insert(10, 0.10);
		list.displayAll();
		list.insert(14, 0.14);
		list.displayAll();
		list.insert(16, 0.16);
		list.displayAll();
		list.insert(19, 0.19);
		list.displayAll();
		list.insert(5, 0.05);
		list.displayAll();
		list.insert(22, 0.22);
		list.displayAll();
		
		list.removeFirst().display();
		System.out.println();
		Link link = list.remove(19);
		if(link==null) System.out.println("Not Found");
		else{
			link.display();
			System.out.println();
		}
		list.displayAll();
	}

}
