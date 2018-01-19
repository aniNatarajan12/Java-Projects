package jrJava.LinkedListPractice;

public class LinkedList {

	private Link first;

	public LinkedList(){
		first = null;
	}
	
	public Link getFirst(){
		return first;
	}

	public boolean isEmpty(){
		return first==null;
	}

	//	public void insertAtFirst(int id, double value){
	//		Link link = new Link(id,value);
	//		link.next = first;
	//		first = link;
	//	}

	public void insert(int id, double value){
		Link link = new Link(id,value);

		Link previous = null;
		Link current = first;

		while(current!=null && current.id<=id){
			previous = current;
			current = current.next;
		}

		if(previous==null){ // at beginning
			if(first!=null) link.next = first;
			first = link;
		}
		else{ // not beginning
			previous.next = link;
			link.next = current;
		}
	}

	public Link removeFirst(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public Link remove(int id){
		if(first==null) return null;
		
		Link previous = null;
		Link current = first;

		while(current.id!=id){
			previous = current;
			current = current.next;
			if(current==null||current.id>id) return null;
		}

		if(previous==null){
			first = current.next;
		}else{
			previous.next = current.next;
		}
		return current;
	}

	public void displayAll(){
		Link current = first;

		while(current!=null){
			current.display();
			current = current.next;
		}
		System.out.println();
	}
}
