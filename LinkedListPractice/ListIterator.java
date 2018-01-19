package jrJava.LinkedListPractice;

public class ListIterator {
	
	private Link previous;
	private Link current;
	private LinkedList list;
	
	public ListIterator(LinkedList _list){
		list = _list;
	}
	
	public void reset(){
		previous = null;
		current = list.getFirst();
	}
	
	public boolean hasNext(){
		return false;
	}
	
	public Link next(){
		return null;
	}
	
	public Link remove(){
		return null;
	}
}
