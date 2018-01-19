package jrJava.LinkedListPractice;

public class Link {
	
	public int id;
	public double value;
	public Link next;
	
	public Link(int _id, double _value){
		id = _id;
		value = _value;
	}
	
	public void display(){
		System.out.print("("+id+","+value + ") ");
	}
}
